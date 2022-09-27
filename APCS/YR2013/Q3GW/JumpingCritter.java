package YR2013.Q3GW;

import java.util.ArrayList;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class JumpingCritter extends Critter {


    public ArrayList<Location> getMoveLocations()
    {
        return GridWorldUtilities.getEmptyLocations(getGrid());
    }

    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        Location loc = super.selectMoveLocation(locs);
        if(loc == getLocation()) return null;
        return loc;
    }
}
