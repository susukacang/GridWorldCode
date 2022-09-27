package YR2013.Q3GW;

import java.util.ArrayList;
import java.util.Iterator;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class JumpingRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        // example 1
        // bug is taken because of process actors method called inside act method. it removes all except rocks and critters.
        // world.add(new Location(2, 1), new Rock());
        // world.add(new Location(3, 1), new Bug());
        // world.add(new Location(2, 0), new JumpingCritter());

        // example 2
        // position of jumping critter
        int rj = 5, cj = 5;
        // fill up grid with rocks
        for (int r = 0; r < world.getGrid().getNumRows(); r++) {
            for (int c = 0; c < world.getGrid().getNumCols(); c++) {
                if (r != rj || c != cj) {
                    world.add(new Location(r, c), new Rock());
                }
            }
        }
        // modify as needed to create empty locations
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                world.remove(new Location(rj + r, cj + c));
            }
        }
        world.add(new Location(rj, cj), new JumpingCritter());

        world.show();

        ArrayList<Location> emptyLocations = GridWorldUtilities.getEmptyLocations(world.getGrid());
        Iterator<Location> iter = emptyLocations.iterator();
        while (iter.hasNext()) {
            Location loc = iter.next();
            System.out.print(loc.toString() + " ");
        }
        System.out.println();
        System.out.println(emptyLocations.size());
    }
}
