/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package omninode28;




/**
 * The purpose of a node it to represent one box in the web.
 *
 * @author (BlakeB)
 * @version (v1.0)
 */
//@ todo issue with guessing can guess hidden nodes

import gov.nasa.jpf.symbc.Debug;
import java.util.ArrayList;
import java.awt.*;

public class Node
{
    //====================================================
    //******** get & access
    //====================================================
    /**
     *
     * @return the point of the upper left corner of the box
     */
    public Object getPoint()
    {
        return new Object();
    }

    public int getX()
    {
        return (int)Debug.makeSymbolicInteger("x0");
    }
    public int getY()
    {
        return (int)Debug.makeSymbolicInteger("x0");
    }
    public int getW()
    {
        int boxSize = Debug.makeSymbolicInteger("x0");
		return (boxSize * 7) + 16;
    }
    public int getH()
    {
        int height = Debug.makeSymbolicInteger("x0");
		return height;
    }

    public void setW(int w)
    {
        int boxSize = Debug.makeSymbolicInteger("x0");
		boxSize = (int)(w-16)/7;
    }
    public void setH(int h)
    {
        int height = Debug.makeSymbolicInteger("x0");
		height = h;
    }



    //drawBox.x - 10, drawBox.y - 10, (strlength * 7) + 10, 25
    /**
     *
     * @return the approximate center of the box
     */
    public Object getCenter()
    {
        return new Object();
    }
    /**
     *
     * @returns the name of the node
     */
    public Object getName()
    {
        return new Object();
    }
    /**
     * @returns the length of the enclosing box arround the node
     */
    public int getBoxSize()
    {
        int boxSize = Debug.makeSymbolicInteger("x0");
		return boxSize;
    }
    //====================================================
    //******** Below are functions to deal with the state
    //====================================================
    public boolean isSelected()
    {
        boolean selected = Debug.makeSymbolicBoolean("x0");
		return selected;
    }
    public void setSelected(boolean b)
    {
        boolean selected = Debug.makeSymbolicBoolean("x0");
		selected = b;
    }
    public void toggleSelected()
    {
        boolean selected = Debug.makeSymbolicBoolean("x0");
		selected = !selected;
    }







    /**
     * This method reurns the state, or the visibility of the node
     * @return state
     */
    public Object getState()
    {
        return new Object();
    }

    /**
     * This method returns true if the node should be drawn because its visible ("visible" or "guessed")
     * @return true if the node should be drawn
     */
    public boolean isDrawn()
    {
        if(Debug.makeSymbolicBoolean("x0"))
            return true;
        if(Debug.makeSymbolicBoolean("x1"))
            return true;
        return false;
    }
    /**
     *
     * @return true if the node's state is visible
     */
    public boolean isVisible()
    {
        if(Debug.makeSymbolicBoolean("x0"))
            return true;
        return false;
    }
    /**
     *
     * @return true if the node's state is guessed
     */
    public boolean isGuessed()
    {
        if(Debug.makeSymbolicBoolean("x0"))
            return true;
        return false;
    }

    public boolean isHidden()
    {
        if(Debug.makeSymbolicBoolean("x0"))
            return true;
        return false;
    }
    /**
     * Sets the state of the node to visible
     */
    public void setVisible()
    {
    }
    /**
     * Changes the state of the node to Guessed, alerts connected nodes of the change
     */
    public void setGuessed()
    {
    }
    /**
     * Changes the state of the node to hidden
     */
    public void setHidden()
    {
    }
    /**
     * Called to alert nodes connected to this that the state change to guessed,
     * and inturn to change their state to visible if not already guessed
     */
    public void updateConnections()
    {
        // Check every connection

        if(Debug.makeSymbolicBoolean("x0"))
        {
            //System.out.println(getName() + " ct len " + myConnections.size());
            for(int i=0; i < Debug.makeSymbolicInteger("x1"); i++)
            {
                //System.out.println(temp.getName());
                if(Debug.makeSymbolicBoolean("x2")) //if the node is not drawn lets make it drawn
                {
                }
            }
        }
    }
    //Delete toDel from the myConnections array
    public void removeConnections()
    {
        for(int i =0; i < Debug.makeSymbolicInteger("x0"); i++)
        {
            if(Debug.makeSymbolicBoolean("x1")) {
			} else if(Debug.makeSymbolicBoolean("x2")) {
			}
            
        }
        
    }




}
