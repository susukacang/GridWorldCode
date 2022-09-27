package YR2008.Q3GW;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class OpossumRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7,8), new OpossumCritter());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(4, 1), new Bug());
        world.add(new Critter());
        world.show();
    }
}
