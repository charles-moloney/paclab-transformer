/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package omninode28;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author student
 */
public class Driver
{

    public static void main(String[] args)
    {
        ArrayList<Connect> Connectlist = new ArrayList<Connect>();
        ArrayList<Node> Nodelist = new ArrayList<Node>();

        JFrame omniFrame = new JFrame("OmniNode Mapper");

        EditPanel EP = new EditPanel(Connectlist, Nodelist, omniFrame);

        omniFrame.setJMenuBar(EP.createMenuBar());
        omniFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // dispose
        omniFrame.addWindowListener(EP.DL); // this is a window listner....

        omniFrame.setPreferredSize(new Dimension(800, 600));

        omniFrame.add(EP);// Shows all the nodes in the web(need two versions, admin, user)
        //JPanel jp = new JPanel("hello");
        //omniFrame.add(jp);

        // Sets Up the frame
        omniFrame.pack();
        omniFrame.setVisible(true);
    }
}
