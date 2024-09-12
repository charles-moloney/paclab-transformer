/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package omninode28;

/**
 * Stores two points. store two nodes
 *
 *
 * @author (Blake B)
 * @version (v1.0)
 */
import java.awt.*;

public class Connect
{

    private Node n1;
    private Node n2;

    /**
     * Constructor requires two node objects
     * @param node1 They become "Connected"
     * @param node2 They become "Connected"
     */
    public Connect(Node node1, Node node2)
    {
        n1 = node1;
        //node1.addConnect(this);
        n2 = node2;
        //node2.addConnect(this);
        addCt();
    }

    /**
     * Add this connection to the list in each of the nodes
     * purpose: so the nodes cna change the state of eachother
     */
    public void addCt()
    {
        n1.addConnect(this);
        n2.addConnect(this);
    }

    /**
     * Returns the center of n1
     */
    public Point getP1()
    {
        return n1.getCenter();
    }

    /**
     * Returns the center of n1
     */
    public Point getP2()
    {
        return n2.getCenter();
    }

    /**
     *
     * @return true if node1 and node2 are visible
     */
    public boolean isVisible()
    {
        if (n1.isDrawn() && n2.isDrawn())
        {
            return true;
        }
        return false;
    }

    /**
     *
     * @return reference to node one
     */
    public Node getN1()
    {
        return n1;
    }

    /**
     *
     * @return reference to node two
     */
    public Node getN2()
    {
        return n2;
    }

    /**
     * returns the node that is part of the connection but not the one in the parameter.
     * @param other
     * @return the node that is not the same as other
     */
    public Node getC(Node other)
    {
        if (getN1().getName().equals(other.getName()))
        {
            return getN2();
        }
        if (getN2().getName().equals(other.getName()))
        {
            return getN1();
        }
        return null;
    }

    public boolean equalsConnectBetween(Node na, Node nb)
    {
        if (n1.equals(na))
        {
            if (n2.equals(nb))
            {
                return true;
            }
        } else if (n1.equals(nb))
        {
            if (n2.equals(na))
            {
                return true;
            }
        }
        return false;

    }
}


