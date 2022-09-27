package YR2012.Q2GW;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class RetroBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        world.add(new Location(0, 0), new Rock());
        world.add(new Location(0, 3), new Rock());
        world.add(new Location(1, 2), new Rock());
        // world.add(new Location(1, 1), new Flower());
        world.add(new Location(1, 1), new Rock());

        world.add(new Location(2, 1), new RetroBug());

        world.show();
    }
}
