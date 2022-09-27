package YR2014.Q2GW;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class Director extends Rock {
    // private Color color;

    public Director() {
        super.setColor(Color.RED);
    }

    public void act() {
        super.act();
        direct();
    }

    public void direct() {
        if(super.getColor() == Color.RED) super.setColor(Color.GREEN);
        else if (super.getColor() == Color.GREEN) super.setColor(Color.RED);
        ArrayList<Actor> neighbors = getGrid().getNeighbors(getLocation());
        for (Actor neighbor : neighbors) {
            neighbor.setDirection(Location.RIGHT);
        }
    }

    public void setDirectorColor() {
        super.setColor(Color.MAGENTA);
    }
}
