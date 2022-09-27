
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
 * @author Edited by Reg Hahne 2.2007
 */
package info.gridworld.actor;

import info.gridworld.grid.Location;
// import info.gridworld.actor.Actor;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>Bacteria</code> moves in the direction of the Heart.<br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class Bacteria extends Actor
{
	/**
     * Constructs a blue Bacteria.
     */
    public Bacteria()
    {
        setColor(Color.BLUE);
    }

    /**
     * Constructs a Bacteria of a given color.
     * @param bacteriaColor is the color for this Bacteria
     */
    public Bacteria(Color bacteriaColor)
    {
        setColor(bacteriaColor);
    }
    
    /**
     * Turns and moves toward the location of the Heart
     * Terminates when adjacent to the Heart 
     */
    public void act ()
    {
    	Location heartLocation = getHeartLocation();
    	//System.out.println("Heart Location --> " + heartLocation);
    	if (heartLocation == null)
    		return;
    	ArrayList<Location> terminationLocations = getGrid().getValidAdjacentLocations(heartLocation);
    	boolean heartCheck = checkForTermination(terminationLocations, getLocation());
    	if (!heartCheck)//!(getLocation().equals(getGrid().get(heartLocation)))))
    	{
    		setDirection(getLocation().getDirectionToward(heartLocation));
        	moveTo(getLocation().getAdjacentLocation(getLocation().getDirectionToward(heartLocation)));
    	}
    	else
    		getGrid().get(heartLocation).setColor(Color.BLACK);
    	//  System.exit(0); // exit the program as the job has been done
    }
    
    /**
     * Returns true if Bacteria is adjacent to a Heart
     */
	public boolean checkForTermination(ArrayList<Location> terminationLocations, Location bacteriaLocation)
	{
		for (Location loc : terminationLocations)
		{
			if (loc.equals(bacteriaLocation))
				return true;
		}
		return false;
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
}