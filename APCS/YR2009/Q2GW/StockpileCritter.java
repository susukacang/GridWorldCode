package YR2009.Q2GW;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class StockpileCritter extends Critter {
    private int energy;

    public StockpileCritter() {
        energy = 0;
        setColor(Color.MAGENTA);
    }

    public void gobble() {
        Location loc = getLocation();
        ArrayList<Actor> actors = getGrid().getNeighbors(loc);
        energy += actors.size();
        for (Actor actor : actors) {
            actor.removeSelfFromGrid();
        }
    }

    public void act() {
        gobble();
        super.act();
        energy--;
        if (energy < 0)
            removeSelfFromGrid();
        System.out.println(energy);
    }

}
