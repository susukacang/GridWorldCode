package YR2013.Q3GW;

import java.util.ArrayList;

import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class JumpingCritterOld extends Critter {
    /**
     * need to check this jump and critter act combination
     */
    public void act() {
        super.act();

        jump();
    }

    public void jump() {
        ArrayList<Location> emptyLocations = GridWorldUtilities.getEmptyLocations(getGrid());

        if (emptyLocations.size() == 0)
            removeSelfFromGrid();
        else {
            int randomIndex = (int) (emptyLocations.size() * Math.random());
            Location newLocation = emptyLocations.get(randomIndex);
            moveTo(newLocation);

            // int index = newLocation.getRow() * getGrid().getNumCols() +
            // newLocation.getCol();
            // System.out.println("jump to " + newLocation.toString() + ", index = " +
            // index);
        }
    }
}
