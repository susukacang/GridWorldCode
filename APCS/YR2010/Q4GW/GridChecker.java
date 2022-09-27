package YR2010.Q4GW;

import java.util.ArrayList;
import java.util.List;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class GridChecker {
    private BoundedGrid<Actor> gr;

    public GridChecker(BoundedGrid<Actor> gr) {
        this.gr = gr;
    }

    /**
     * part a
     * 
     * @return
     */
    public Actor actorWithMostNeighbors() {
        int maxSize = 0;
        Actor maxActor = null;

        ArrayList<Location> locs = gr.getOccupiedLocations();
        for (Location loc : locs) {
            ArrayList<Actor> actors = gr.getNeighbors(loc);
            int size = actors.size();
            if (maxSize < size) {
                maxSize = size;
                maxActor = gr.get(loc);
            }
        }

        return maxActor;
    }

    /**
     * part b
     * 
     * @param loc
     * @return
     */
    public List<Location> getOccupiedWithinTwo(Location loc) {
        ArrayList<Location> locs = new ArrayList<>(); // empty list if none
        int row = loc.getRow();
        int col = loc.getCol();

        for (int r = row - 2; r <= row + 2; r++) {
            for (int c = col - 2; c <= col + 2; c++) {
                if (r >= 0 && r < gr.getNumRows() && c >= 0 && c < gr.getNumCols())
                    if (r != row || c != col) {
                        Location locWithinTwo = new Location(r, c);
                        if (gr.get(locWithinTwo) != null)
                            locs.add(locWithinTwo);
                    }
            }
        }
        return locs;
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new Location(0, 0), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(3, 2), new Bug());
        world.add(new Location(5, 4), new Critter());
        world.add(new Location(5, 6), new Critter());
        world.show();

        BoundedGrid<Actor> gr = (BoundedGrid<Actor>) world.getGrid();
        GridChecker gridChecker = new GridChecker(gr);
        Actor actor = gridChecker.actorWithMostNeighbors();
        Location location = actor.getLocation();
        System.out.println("actor with most neighbors: " + location.getRow() + " " + location.getCol());

        System.out.println("loc\tgetOccupiedWithinTwo(loc)");
        Location loc_ = new Location(1, 1);
        System.out.print(loc_.getRow() + " " + loc_.getCol() + "\t| ");
        List<Location> locsWithinTwo_ = gridChecker.getOccupiedWithinTwo(loc_);
        for (Location locWithinTwo : locsWithinTwo_) {
            System.out.print(locWithinTwo.getRow() + " " + locWithinTwo.getCol() + "; ");
        }
        System.out.println();

        ArrayList<Location> locs = gr.getOccupiedLocations();
        for (Location loc : locs) {
            System.out.print(loc.getRow() + " " + loc.getCol() + "\t| ");
            List<Location> locsWithinTwo = gridChecker.getOccupiedWithinTwo(loc);
            for (Location locWithinTwo : locsWithinTwo) {
                System.out.print(locWithinTwo.getRow() + " " + locWithinTwo.getCol() + "; ");
            }
            System.out.println();
        }


    }
}
