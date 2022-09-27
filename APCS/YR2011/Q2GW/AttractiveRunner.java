package YR2011.Q2GW;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class AttractiveRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        // use rock and flower because they don't move by default. for example, don't use critter or bug because there will be double move i.e. they act as well
        world.add(new Location(1, 1), new Flower());
        world.add(new Location(4, 2), new Rock());
        world.add(new Location(1, 2), new AttractiveCritter());
        world.show();


    }
}
