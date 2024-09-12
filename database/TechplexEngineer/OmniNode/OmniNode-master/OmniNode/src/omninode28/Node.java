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

import java.util.ArrayList;
import java.awt.*;

public class Node
{
    private Point loc;
    private String name;  // name of the node
    private int boxSize;  // calculated by name length
    private Point center; // approx center
    private String state = "hidden";
    private boolean selected = false;
    private ArrayList<Connect> myConnections; // list of all the connections that connect to me
    private boolean debug = false;
    int height = 25;


    /**
     *
     * @param location the point where the box will be drawn(java.awt.point)
     * @param objNm node of the node
     */
    public Node(Point location, String objNm)
    {

        myConnections = new ArrayList<Connect>();
        //myConnections = new ArrayList<Connect>();
        loc = location;
        name = objNm;
        boxSize =  (((objNm.length())*7) + 10); //fomula for box size
        center = new Point((int)(loc.getX()+(boxSize/2)), (int)(loc.getY()+7));//
        //System.out.println("BoxSize: " + boxSize);
        //setHidden();
    }
    /**
     * loaation refers tot he point where the box willbe drawn(java.awt.point),
     * objNm is usually the name that is displayed in the box,
     * state can be "visible", "hidden", or "guessed",
     */
    public Node(Point location, String objNm, String gstate)
    {
        //NP = NPt;
        myConnections = new ArrayList<Connect>();
        loc = location;
        name = objNm;
        boxSize =  (((objNm.length())*7) + 10); //fomula for box size
        center = new Point((int)(loc.getX()+(boxSize/2)), (int)(loc.getY()+7));

        if(gstate.equals("guessed"))
            setGuessed();
        else if(gstate.equals("visible"))
            setVisible();
        else if(gstate.equals("hidden"))
            setHidden();

    }




    //====================================================
    //******** get & access
    //====================================================
    /**
     *
     * @return the point of the upper left corner of the box
     */
    public Point getPoint()
    {
        return loc;
    }

    public int getX()
    {
        return (int)loc.getX();
    }
    public int getY()
    {
        return (int)loc.getY();
    }
    public int getW()
    {
        return (boxSize * 7) + 16;
    }
    public int getH()
    {
        return height;
    }

    public void setW(int w)
    {
        boxSize = (int)(w-16)/7;
    }
    public void setH(int h)
    {
        height = h;
    }



    //drawBox.x - 10, drawBox.y - 10, (strlength * 7) + 10, 25
    /**
     *
     * @return the approximate center of the box
     */
    public Point getCenter()
    {
        return center;
    }
    /**
     * Used to output nice looking ordered pairs
     * @return the X and Y values for the point, separated by string str
     */
    public String getOrderedPair(String str)
    {
        return this.getPoint().getX() + str + this.getPoint().getY();
    }
    /**
     *
     * @returns the name of the node
     */
    public String getName()
    {
        return name;
    }
    /**
     * @returns the length of the enclosing box arround the node
     */
    public int getBoxSize()
    {
        return boxSize;
    }
    //====================================================
    //******** Morph
    //====================================================
    /**
     * Moves the node to the Point p
     * @param p
     */
    public void moveTo(Point p)
    {
        loc = p;
        center = new Point((int)(loc.getX()+(boxSize/2)), (int)(loc.getY()+7));

    }
    /**
     * Changes the objects name to String str
     * @param str
     */
    public void setName(String str)
    {
        name = str;
    }

    /**
     * This method returns true if the given Point p is within the bounds of the node
     * @param p point to check
     * @return true if point p is in the bounds of the node
     */
    public boolean isPointInNode(Point p)
    {
        if(p != null && p.getX() >= loc.getX()-10 && p.getX() <= loc.getX()-10+getBoxSize() && p.getY() >= loc.getY()-10 && p.getY() <= loc.getY()+25-10)
            return true;
        else
            return false;
    }
    /**
     * Allows for the addition of Connect to the myConnections
     * @param Connect c is the connection to add to the myConnections list
     */
    public void addConnect(Connect c)
    {
        IO.d("addConnect: " +  this.getName() + " to " + c.getC(this).getName() , debug);
        //if(isGuessed()) // This Fixed the showing of nodes that should be hidden issue
        //{
            //System.out.println("updating");
            myConnections.add(c);
            updateConnections();
//        }
//        if(isVisible()) //adds new nodes  @todo understannd this
//        {
//            //@todo check for duplcates
//            myConnections.add(c);
//        }

    }
    //====================================================
    //******** Below are functions to deal with the state
    //====================================================
    public boolean isSelected()
    {
        return selected;
    }
    public void setSelected(boolean b)
    {
        selected = b;
    }
    public void toggleSelected()
    {
        selected = !selected;
    }







    /**
     * This method reurns the state, or the visibility of the node
     * @return state
     */
    public String getState()
    {
        return state;
    }

    /**
     * This method returns true if the node should be drawn because its visible ("visible" or "guessed")
     * @return true if the node should be drawn
     */
    public boolean isDrawn()
    {
        if(state.equals("visible"))
            return true;
        if(state.equals("guessed"))
            return true;
        return false;
    }
    /**
     *
     * @return true if the node's state is visible
     */
    public boolean isVisible()
    {
        if(state.equals("visible"))
            return true;
        return false;
    }
    /**
     *
     * @return true if the node's state is guessed
     */
    public boolean isGuessed()
    {
        if(state.equals("guessed"))
            return true;
        return false;
    }

    public boolean isHidden()
    {
        if(state.equals("hidden"))
            return true;
        return false;
    }
    //====================================================
    //******** Morph
    //====================================================
     /**
     * This method allows the changing of the state, includes of validation of the string
     * @param st
     */
    public void setStateopmit(String str)
    {
        if(str.equalsIgnoreCase("hidden") || str.equalsIgnoreCase("visible") || str.equalsIgnoreCase("guessed"))
            state = str;
        else
            IO.errMsg("this state is not one of the presets.");
    }
    /**
     * Sets the state of the node to visible
     */
    public void setVisible()
    {
        IO.d("Set visible: " + this.getName(), debug);
        state = "visible";
    }
    /**
     * Changes the state of the node to Guessed, alerts connected nodes of the change
     */
    public void setGuessed()
    {
        IO.d("Set guessed: " + this.getName(), debug);
        state = "guessed";
        // when guessed tell my connected nodes to become visible
        updateConnections();
    }
    /**
     * Changes the state of the node to hidden
     */
    public void setHidden()
    {
        IO.d("Set hidden: " + this.getName(), debug);
        state = "hidden";
    }
    /**
     * Called to alert nodes connected to this that the state change to guessed,
     * and inturn to change their state to visible if not already guessed
     */
    public void updateConnections()
    {
        // Check every connection

        if(this.isGuessed())
        {
            //System.out.println(getName() + " ct len " + myConnections.size());
            for(int i=0; i < myConnections.size(); i++)
            {
                Node temp = myConnections.get(i).getC(this);
                //System.out.println(temp.getName());
                if(!(temp.isDrawn())) //if the node is not drawn lets make it drawn
                {
                    //System.out.println("setting visible " + this.getName());
                    temp.setVisible();
                    IO.d("Check Connections " + this.getName(), debug);
                }
            }
        }
    }
    //====================================================
    //******** Equality
    //====================================================
    /**
     * Preforms a three point check to see it the nodes are the same
     * @param check the node to compare th this
     * @return true if the node match 3 point check
     * @todo will one == this?
     */
    public boolean equals(Node check)
    {
        if(check.getCenter() == getCenter() && check.getName().equalsIgnoreCase(this.getName()) && check.getState().equals(this.getState()))
            return true;
        else
            return false;
     }
    public boolean equals(Node n1, Node n2)
    {
        if(n1.getCenter() == n2.getCenter() && n1.getName().equalsIgnoreCase(n2.getName()) && n1.getState().equals(n2.getState()))
            return true;
        else
            return false;
     }
    
//    //thisnode.delete();
//    public boolean delete()
//    {
//        //go to each node in the myConnections array, and ask it to delete
//        remove(this);
//
//        //remove the pointer from the master list
//
//
//
//
//        return true;
//    }
    
    
    //Delete toDel from the myConnections array
    public void removeConnections()
    {
        Node toDel = this;
        for(int i =0; i < myConnections.size(); i++)
        {
            Connect temp = myConnections.get(i);
            if(temp.getN1().equals(toDel))
                myConnections.remove(temp);
            else if(temp.getN2().equals(toDel))
                myConnections.remove(temp);
            
        }
        
    }




}
