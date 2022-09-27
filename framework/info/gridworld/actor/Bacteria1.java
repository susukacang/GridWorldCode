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
 * @author Cay Horstmann
 * @author Adapted by Reg Hahne 11/2006
 * @author Edited by Reg Hahne 1/2007
 * @author Edited by Reg Hahne 2/2007
 */
package info.gridworld.actor;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>Bacteria1</code> moves towards the Heart manouvering
 * around a WhiteBloodCell <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class Bacteria1 extends Bacteria
{
    /**
     * Constructs a green Bacteria1
     */
    public Bacteria1()
    {
        super(Color.GREEN);
    }
    
    /**
     * Turns towards and moves towards the location of the Heart 
     * The Bacteria1 can �see� two grid blocks in any direction from its current position. 
     * If the Bacteria1 is within two grid blocks of the WhiteBloodCellCritter the Bacteria moves
     * one grid block the farthest legal distance away from the WhiteBloodCellCritter.
     * Checks if close to White Blood Cell first
     */
    public void act ()
    {
    	Location heartLocation = getHeartLocation(); 
    	Location whiteBloodCellLocation = getWhiteBloodCellLocation();
    	if (heartLocation == null || whiteBloodCellLocation == null)
    		return;
    	else if (closeToWhiteBloodCell()) // check for retreat
    	{
    		int reverseDirection =  (getLocation().getDirectionToward(whiteBloodCellLocation) + 180) % 360;
   		    Location reverseLocation = getLocation().getAdjacentLocation(reverseDirection);
   	       	if (getGrid().isValid(reverseLocation))
        	{
        		setDirection(getLocation().getDirectionToward(reverseLocation));
        		moveTo(getLocation().getAdjacentLocation(reverseDirection)); //move 180 degrees in the opposite direction from the White Blood Cell
        	}
    	}
    	else
    	{
    		ArrayList<Location> terminationLocations = getGrid().getValidAdjacentLocations(heartLocation);
    		boolean heartCheck = checkForTermination(terminationLocations, getLocation());
    		if (!heartCheck)//
    		{
    			setDirection(getLocation().getDirectionToward(heartLocation));
    			moveTo(getLocation().getAdjacentLocation(getLocation().getDirectionToward(heartLocation)));
    		}
    		else
    		{
    			getGrid().get(heartLocation).setColor(Color.BLACK);
    			//System.exit(0); // exit the program as the job has been done
    		}
    	}
    }
    
    /**
     * Returns the location of the Heart 
     */
    public Location getHeartLocation()
    {
    	ArrayList <Location> inhabitedLocations = getGrid().getOccupiedLocations();
    	for (Location loc : inhabitedLocations)
    	{
    		if (getGrid().get(loc) instanceof Heart)
    			return loc;	
    	}
    	return null;
    }
    
    /**
     * Returns true if Bacteria1 is within a 2 cell distance of a WhiteBloodCellCritter
     *
     */
    public boolean closeToWhiteBloodCell()
    {
    	Location whiteBloodCellLocation = getWhiteBloodCellLocation();
    	if (whiteBloodCellDetected(getLocation(), whiteBloodCellLocation))
    		return true;
    	else
    		return false;
    }
    
    /**
     * Returns the location of the WhiteBloodCellCritter
     */
    public Location getWhiteBloodCellLocation()
	{
		ArrayList <Location> inhabitedLocations = getGrid().getOccupiedLocations();
		for (Location loc : inhabitedLocations)
		{
			if (getGrid().get(loc) instanceof WhiteBloodCellCritter)// change
				return loc;	
		}
		return null;
	}
    
    /**
     * Returns true if a WhiteBloodCellCritter is within range
     */
    public boolean whiteBloodCellDetected(Location bacteria, Location whiteBloodCell)
    {
    	ArrayList<Location> tempLocations = getValidLocations(bacteria);
    	for (Location loc : tempLocations)
    	{
    		if(loc.equals(whiteBloodCell))
    			return true;
    	}
    	return false;
    }
    
    /**
     * Returns a list of available entries to check
     */
    public ArrayList<Location> getValidLocations(Location bacteria)
    {
    	ArrayList<Location> tempHold = new ArrayList<Location>();
    	for (int row = bacteria.getRow() - 2; row <= bacteria.getRow() + 2; row++)
    	{
    		for (int col = bacteria.getCol() - 2; col <= bacteria.getCol() + 2; col++)
    		{
    			Location tempLoc = new Location (row, col);
    			if (getGrid().isValid(tempLoc))
    			{
    				tempHold.add(tempLoc);
    			}
    		}
    	}
    	return tempHold;
    }
}
