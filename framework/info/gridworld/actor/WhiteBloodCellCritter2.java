
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

// import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * A <code>WhiteBloodCellCritter</code> is an actor whose responsibility is to protect the Heart
 * This protection lies within a 5 by 5 cell grid with the Heart located in its center
 * Moves toward direction of Bacteria1 if within 2 grid blocks of Bacteria1
 * Otherwise moves randomly within designated domain
 * This class is not tested on the AP CS A and AB exams.
 */
public class WhiteBloodCellCritter2 extends WhiteBloodCellCritter
{
	/**
     * Constructs a orange White Blood Cell critter.
     */
	public WhiteBloodCellCritter2()
	{
		setColor(Color.ORANGE);
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
    	if (bacteriaDetected(getLocation(), getBacteriaLocation()))
    	{
    		moveLocs = new ArrayList<Location>();
    		int bacteriaDirection = getLocation().getDirectionToward(getBacteriaLocation());
    		Location nextLocation = getLocation().getAdjacentLocation(bacteriaDirection);
    		if (ValidLocation(nextLocation))
    			moveLocs.add(nextLocation);
    		return moveLocs;
    	}
    	else
    	{
    		return super.getMoveLocations();
    	}
    }
    
    /**
     * Returns true if WhiteBloodCellCritter is within a 2 cell distance of a Bacteria1 
     *
     */
    
    public boolean bacteriaDetected(Location whiteBloodCell, Location bacteria)
    {
    	ArrayList<Location> tempLocations = getValidLocations(whiteBloodCell);
    	for (Location loc : tempLocations)
    	{
    		if(loc.equals(bacteria))
    			return true;
    	}
    	return false;
    }
    
    /**
     * Returns true if loc is a valid location that the WhiteBloodCellCritter can move
     * otherwise returns false
     */
    public boolean ValidLocation(Location loc)
    {
    	ArrayList<Location> validLocs = getGrid().getEmptyAdjacentLocations(getLocation());
    	validLocs = removeInvalidLocations(validLocs);
    	if (withinHeartRange(validLocs, loc))
    		return true;
    	else
    		return false;
    }
    /** 
     * returns true if within location of the Heart
     */
    public boolean withinHeartRange(ArrayList<Location> validLocs, Location loc)
    {
       	Iterator<Location> itr = validLocs.iterator();
    	while (itr.hasNext())
    	{
    		Location temp = itr.next();
    		if (temp.equals(loc))
    		{
    			return true; 
    		}
    	}
    	return false;
    }

    /**
     * Returns the location of the Bacteria1 
     */
    public Location getBacteriaLocation()
    {
    	ArrayList <Location> inhabitedLocations = getGrid().getOccupiedLocations();
    	for (Location loc : inhabitedLocations)
    	{
    		if (getGrid().get(loc) instanceof Bacteria1)
    			return loc;	
    	}
    	return null;
    }
    
    /**
     * Gets the possible locations for the next move of the WhiteBloodCellCritter. 
     * Implemented to return the valid locations available to move to.
     * Postcondition: The locations must be valid in the grid of this critter.
     * @return a list of possible locations for the next move
     */
    public ArrayList<Location> getValidLocations(Location whiteBloodCell)
    {
    	ArrayList<Location> tempLocations = new ArrayList<Location>();
    	for (int row = whiteBloodCell.getRow() - 2; row <= whiteBloodCell.getRow() + 2; row++)
    	{
    		for (int col = whiteBloodCell.getCol() - 2; col <= whiteBloodCell.getCol() + 2; col++)
    		{
    			//System.out.println ("Adding a location");
    			tempLocations.add(new Location (row, col));
    		}
    	}
    	tempLocations = removeInvalidWhiteBloodCellLocations (tempLocations);
        return tempLocations;
    }
    
    /**
     * Returns valid locations for the WhiteBloodCellCritter to move.
     */
    public ArrayList<Location> removeInvalidWhiteBloodCellLocations (ArrayList<Location> locations)
    {
    	ArrayList<Location> tempHold = new ArrayList<Location>();
    	Iterator<Location> itr = locations.iterator();
    	while (itr.hasNext())
    	{
    		Location temp = itr.next();
    		if (validWhiteBloodCellLocation (temp, getBacteriaLocation()))
    		{
    			tempHold.add(temp); 
    		}
    	}
    	return tempHold;
    }
    
    /**
     * Returns true if the location is valid, false otherwise
     */
    public boolean validWhiteBloodCellLocation (Location loc, Location bacteriaLocation)
    {
    	if (withinWhiteBloodCellRange(loc, bacteriaLocation))	
    		return true;
    	else 
    		return false;
    }
    
    /**
     * Returns true if loc is within a legal range from the location of the Bacteria1
     */
    public boolean withinWhiteBloodCellRange(Location loc, Location bacteriaLocation)
    {
    	int minRow = bacteriaLocation.getRow() - 2;
    	int maxRow = bacteriaLocation.getRow() + 2;
    	int minCol = bacteriaLocation.getCol() - 2;
    	int maxCol = bacteriaLocation.getCol() + 2;
    	return loc.getRow() >= minRow 
    	       && loc.getRow() <= maxRow 
    	       && loc.getCol() >= minCol 
    	       && loc.getCol() <= maxCol;
    }
}
