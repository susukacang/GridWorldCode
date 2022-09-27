package YR2009.Q2GW;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;

public class StockpileRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Rock());
        world.add(new StockpileCritter());
        world.show();
    }
}
