package YR2011.Q2GW;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class AttractiveCritter extends Critter {
    // familiarity with GridWorld is required

    public AttractiveCritter() {
        setColor(Color.GREEN);
    }
    // overrides method. get all actors except self
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Location> locs = getGrid().getOccupiedLocations(); // all occupied locations including itself
        for (Location loc : locs) {
            if (!loc.equals(getLocation())) // exclude self
                actors.add(getGrid().get(loc));
        }
        return actors;
    }

    // use the getDirectionToward method in Location class
    // target is the attractivecritter. source is the actor attracted to the targeted attractive critter.
    public void processActors(ArrayList<Actor> actors) {
        Location targetLoc = this.getLocation();
        for (Actor actor : actors) {
            Location sourceLoc = actor.getLocation();
            int direction = sourceLoc.getDirectionToward(targetLoc);
            Location neighborLoc = sourceLoc.getAdjacentLocation(direction); // getAdjacentLocation does not check for boundary.
            Actor neighbor = getGrid().get(neighborLoc); // pick an adjacent neighbor pointed by direction.
            if (neighbor == null) { // if occupied, do nothing i.e. stay put
                actor.moveTo(neighborLoc);
            }
        }
    }

    public ArrayList<Location> getMoveLocations()
    {
        return null;
    }

}
