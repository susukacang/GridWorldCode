package YR2008.Q3GW;

import java.awt.Color;
import java.util.ArrayList;

import critters.ChameleonCritter;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bacteria;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class OpossumCritter extends Critter {
    private int numStepsDead;
    public OpossumCritter() {
        numStepsDead = 0;
        setColor(Color.ORANGE);
    }

    /**
     * part a
     */
    public void processActors(ArrayList<Actor> actors) {
        int numFriend = 0;
        int numFoe = 0;
        for (Actor actor : actors) {
            if(isFriend(actor)) numFriend++;
            if(isFoe(actor)) numFoe++;
        }
        if(numFriend < numFoe) {
            numStepsDead++;
            setColor(Color.BLACK);
        } else {
            numStepsDead = 0;
            setColor(Color.ORANGE);
            // set move location?
        }
    }

    /**
     * part b
     */
    public Location selectMoveLocation(ArrayList<Location> locs) {
        if(numStepsDead == 0) { 
            return super.selectMoveLocation(locs);
        }
        if(numStepsDead < 3) return getLocation();
        return null;
    }

    private boolean isFriend(Actor other) {
        if(other instanceof Critter) return true;
        else return false;
    }

    private boolean isFoe(Actor other) {
        if(other instanceof Bug) return true;
        else return false;
    }
}
