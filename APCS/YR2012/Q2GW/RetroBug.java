package YR2012.Q2GW;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class RetroBug extends Bug {
    private Location prevLocation;
    private int direction;

    public void restore() {
        if(getGrid().get(prevLocation) instanceof Flower) {
            moveTo(prevLocation);
            setDirection(direction);
        } else {
            setDirection(direction);
        }
    }

    public void act() {
        prevLocation = getLocation();
        direction = getDirection();
        super.act();
    }
}
