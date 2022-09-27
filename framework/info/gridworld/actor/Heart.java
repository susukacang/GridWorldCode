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
 */
package info.gridworld.actor;


// import info.gridworld.actor.Actor;

import java.awt.Color;

/**
 * A <code>Heart</code> is an actor that does nothing.<br />
 * This class is not tested on the AP CS A and AB exams.
 */

public class Heart extends Actor
{
    
    private static final Color DEFAULT_COLOR = Color.RED;

    /**
     * Constructs a red heart.
     */
    public Heart()
    {
        setColor(DEFAULT_COLOR);
    }

    /**
     * Overrides the <code>act</code> method in the <code>Actor</code> class
     * to do nothing.
     */
    public void act()
    {
    }
}
