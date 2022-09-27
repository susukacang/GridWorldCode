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

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bacteria;
import info.gridworld.actor.Heart;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains a Heart and Bacteria
 * all added at specified locations. Click on empty locations to add additional 
 * actors, but do so at your own risk as unpredictable results will occur.
 * Click on populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SaveMyHeartRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(5, 5), new Heart());
        //world.add(new Location(0, 9), new Bacteria());
        // try other locations
        // world.add(new Location(9, 9), new Bacteria());
        world.add(new Location(9, 0), new Bacteria());
        // world.add(new Location(0, 0), new Bacteria());
        world.show();
    }
}