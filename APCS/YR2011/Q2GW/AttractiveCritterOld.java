package YR2011.Q2GW;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class AttractiveCritterOld extends Critter {
    public int getDirectionToward(Location attractedLoc) {
        Location loc = getLocation();
        int dr = loc.getRow() - attractedLoc.getRow();
        int dc = loc.getCol() - attractedLoc.getCol();
        if (Math.abs(dr) > Math.abs(dc)) {
            if (dr < 0)
                return Location.NORTH;
            else
                return Location.SOUTH;
        } else {
            if (dc < 0)
                return Location.WEST;
            else
                return Location.EAST;
        }

    }

    public void moveActors() {
        // ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Location> occupiedLocs = getGrid().getOccupiedLocations(); // location of all actors, including the
                                                                             // current attractive critter
        // Location loc = getLocation(); // attractive critter's current location
        Grid<Actor> grid = getGrid();
        for (Location occupiedLoc : occupiedLocs) {
            Actor actor = grid.get(occupiedLoc);
            Location newLoc = null;
            if (!this.equals(actor)) {
                int direction = getDirectionToward(occupiedLoc);
                if (direction == Location.NORTH) {
                    System.out.print(direction + " N");
                    newLoc = new Location(occupiedLoc.getRow() - 1, occupiedLoc.getCol());
                    if (getGrid().get(newLoc) == null) {
                        actor.removeSelfFromGrid();
                        actor.putSelfInGrid(getGrid(), newLoc);
                        System.out.println("move N");
                    }
                } else if (direction == Location.SOUTH) {
                    System.out.print(direction + " S");
                    newLoc = new Location(occupiedLoc.getRow() + 1, occupiedLoc.getCol());
                    if (getGrid().get(newLoc) == null) {
                        actor.removeSelfFromGrid();
                        actor.putSelfInGrid(getGrid(), newLoc);
                    }
                } else if (direction == Location.WEST) {
                    System.out.print(direction + " W");
                    newLoc = new Location(occupiedLoc.getRow(), occupiedLoc.getCol() - 1);
                    if (getGrid().get(newLoc) == null) {
                        actor.removeSelfFromGrid();
                        actor.putSelfInGrid(getGrid(), newLoc);
                        System.out.println("move W");
                    }
                } else if (direction == Location.EAST) {
                    System.out.print(direction + " E");
                    newLoc = new Location(occupiedLoc.getRow(), occupiedLoc.getCol() + 1);
                    if (getGrid().get(newLoc) == null) {
                        actor.removeSelfFromGrid();
                        actor.putSelfInGrid(getGrid(), newLoc);
                    }
                }
            }
            if(newLoc != null)System.out.println(newLoc.toString());

        }
    }

    public void act() {
        moveActors();
        super.act();
    }
}
