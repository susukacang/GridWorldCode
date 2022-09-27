/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 * @author Adapted by Reg Hahne 11/2006
 * @author Edited by Reg Hahne 1/2007
 * @author Edited by Reg Hahne 2.2007
 */
package info.gridworld.actor;

import info.gridworld.grid.Location;
// import info.gridworld.actor.Actor;
// import info.gridworld.actor.Critter;

import java.awt.Color;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * A <code>WhiteBloodCellCritter</code> is an actor whose responsibility is to protect the Heart
 * This protection lies within a 5 by 5 cell grid with the Heart located in its center
 * Moves randomly within designated domain
 * This class is not tested on the AP CS A and AB exams.
 */
public class WhiteBloodCellCritter extends Critter
{
    /**
     * Constructs a yellow White Blood Cell critter.
     */
	public WhiteBloodCellCritter()
	{
		setColor(Color.YELLOW);
	}
    
	/**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: (1) The selected actors are contained in the same grid as
     * this critter. (2) The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        return null; // does nothing
    }

    /**
     * Processes selected actors. Implemented to "eat" (i.e. remove) selected
     * actors that are not rocks or critters. Override this method in subclasses
     * to process actors in a different way. <br />
     * Precondition: All elements of <code>actors</code> are contained in the
     * same grid as this critter. <br />
     * Postcondition: (1) The state of all actors other than this critter and
     * the elements of <code>actors</code> is unchanged. (2) The location of
     * this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
    	//does nothing
    }
    
    /**
     * Gets the possible locations for the next move. Implemented to return the
     * empty neighboring locations. Override this method in subclasses to look
     * elsewhere for move locations.<br />
     * Postcondition: (1) The move locations are valid in the grid of this
     * critter. (2) The state of all actors is unchanged.
     * @return a list of possible locations for the next move
     */
    
    public ArrayList<Location> getMoveLocations()
    {
    	ArrayList<Location> moveLocs;
    	moveLocs = getGrid().getEmptyAdjacentLocations(getLocation());
    	return removeInvalidLocations(moveLocs);
    	
    }
    
    /**
     * Returns true if loc is within a legal range from the location of the Heart
     */
    public boolean withinHeartRange(Location loc, Location heartLocation)
    {
    	int minRow = heartLocation.getRow() - 2;
    	int maxRow = heartLocation.getRow() + 2;
    	int minCol = heartLocation.getCol() - 2;
    	int maxCol = heartLocation.getCol() + 2;
    	return loc.getRow() >= minRow 
    	       && loc.getRow() <= maxRow 
    	       && loc.getCol() >= minCol 
    	       && loc.getCol() <= maxCol;
    }
    
    /**
     * Returns true if the location is valid, false otherwise
     */
    public boolean validLocation (Location loc, Location heartLocation)
    {
    	if (withinHeartRange(loc, heartLocation))	
    		return true;
    	else 
    		return false;
    }
    
    /**
     * Returns valid locations for the WhiteBloodCellCritter to move.
     */
    public ArrayList<Location> removeInvalidLocations (ArrayList<Location> locations)
    {
    	ArrayList<Location> tempHold = new ArrayList<Location>();
    	Iterator<Location> itr = locations.iterator();
    	while (itr.hasNext())
    	{
    		Location temp = itr.next();
    		if (validLocation (temp, getHeartLocation()))
    		{
    			tempHold.add(temp); 
    		}
    	}
    	return tempHold;
    }

    /**
     * Returns the location of the Heart 
     */
    public Location getHeartLocation()
    {
    	ArrayList <Location> inhabitedLocations = new ArrayList <Location>();
    	inhabitedLocations = getGrid().getOccupiedLocations();
    	for (Location loc : inhabitedLocations)
    	{
    		if (getGrid().get(loc) instanceof Heart)
    			return loc;	
    	}
    	return null;
    }  
}
