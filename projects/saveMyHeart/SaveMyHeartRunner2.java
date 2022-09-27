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
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bacteria1;
import info.gridworld.actor.Heart;
import info.gridworld.actor.WhiteBloodCellCritter2;
import info.gridworld.grid.Location;

/**
 * This class runs a world that contains a Heart, Bacteria1 and a WhiteBloodCell2 
 * all added at random locations.
 * Click on populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class SaveMyHeartRunner2
{
    public static void main(String[] args)
    {
    	ActorWorld world = new ActorWorld();
    	world.add(new Location(4, 4), new WhiteBloodCellCritter2());
    	//world.add(new Location(6, 6), new WhiteBloodCellCritter2());
    	//world.add(new Location(4, 6), new WhiteBloodCellCritter2());
        world.add(new Location(5, 5), new Heart());
        world.add(new Location(0, 0), new Bacteria1());
        //world.add(new Location(9, 0), new Bacteria1b());
        //world.add(new Location(9, 9), new Bacteria1());
        //world.add(new Location(0, 9), new Bacteria1());
        world.show();
    }
}