package YR2014.Q2GW;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class DirectorRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        // world.add(new Location(2, 1), new Rock());
        world.add(new Location(3, 1), new Bug());
        world.add(new Location(2, 0), new Director());

        world.show();
    }
}
