package YR2013.Q3GW;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class GridWorldUtilities {
    ArrayList<Location> emptyLocations;
    /**
     * part a
     * @param grid
     * @return
     */
    public static ArrayList<Location> getEmptyLocations(Grid<Actor> grid) {
        ArrayList<Location> emptyLocations = new ArrayList<>();
        for (int r = 0; r < grid.getNumRows(); r++) {
            for (int c = 0; c < grid.getNumCols(); c++) {
                Location loc = new Location(r, c);
                if(grid.get(loc) == null) emptyLocations.add(loc);
            }
        }
        return emptyLocations;
    }
}
