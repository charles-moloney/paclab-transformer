/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package omninode28;

/**
 * User can create boxes with words in them.
 *
 * Miss Luce
 * Blake B
 * @version (1.2)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.*;
//import omninode28.EndUserPanel.DynamicListener;
//import java.io.*;

public class NodePanel extends JPanel
{

    private final int WIDTH = 800,  HEIGHT = 600;
    private ArrayList<Node> nodelist;
    private ArrayList<Connect> connectlist;
    private int strlength; // used when drawing boxes
    //private JButton create,  grid,  connect,  save,  load;
    //private JLabel label,  end;
    //private String mode; // set by button push
    //private Node end1,  end2;
    //private int count;
    //private Node gridmode;
    //private boolean debug = false;
    //private JButton openButton,  saveButton;
    //private MenuListener ml;
    JFileChooser fc;
    boolean editing;

    /**
     * Gets nodes and connections, sets up mouse listner and button listners.
     * @param ntemp ArrayList of Node objects
     * @param ctemp ArrayList Connect objects
     */
    public NodePanel(ArrayList<Node> ntemp, ArrayList<Connect> ctemp, boolean et)
    {
        nodelist = ntemp;
        connectlist = ctemp;
        editing = et;

        //count = 0;
        //mode = "create"; // Default mode create

        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


        fc = new JFileChooser();
    //Add the buttons and the log to this panel.
    //add(buttonPanel, BorderLayout.PAGE_START);
    //add(logScrollPane, BorderLayout.CENTER);
    }
    /**
     * Draws all of the node and connections stored in the respective arraylists
     */
    @Override
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        // @todo the drawing needs some  the center of nodes si off

        if (editing)
        {
            page.setColor(Color.green);
            for (int i = 0; i < connectlist.size(); i++) //draws white connecting lines
            {   //x.y.w.h
                page.setColor(Color.white); //@todo mod colors
                // Draws a line between the two center points of the boxes
                page.drawLine((int) (connectlist.get(i).getP1().getX()), (int) (connectlist.get(i).getP1().getY()), (int) (connectlist.get(i).getP2().getX()), (int) (connectlist.get(i).getP2().getY()));
            }
            Point drawBox;
            for (int i = 0; i < nodelist.size(); i++) // Draws the boxes and textfrom the nodes
            {   //x.y.w.h
                page.setColor(Color.green);  // @todo allow user to mod colors
                strlength = nodelist.get(i).getName().length();
                drawBox = nodelist.get(i).getPoint();
                page.setColor(Color.blue);
                if (nodelist.get(i).isSelected())
                {
                    page.fillRect(drawBox.x - 13, drawBox.y - 13, (strlength * 7) + 16, (int) nodelist.get(i).getH() + 6); // selected
                //System.out.println("blue rect");
                }

                page.setColor(Color.green);
                page.fillRect(drawBox.x - 10, drawBox.y - 10, (strlength * 7) + 10, (int) nodelist.get(i).getH());// Math done for the sixe of the box
                page.setColor(Color.black);
                page.drawString(nodelist.get(i).getName(), drawBox.x - 3, drawBox.y + 7);// Draws the text on top of the box
            }
        } else
        {
            page.setColor(Color.green);
            Point drawBox;
            page.setColor(Color.white);
            for (int i = 0; i < connectlist.size(); i++) //draws white connecting lines
            {   //x.y.w.h
                //connectlist.get(i).update(); // Updates the point that the connection believes to be the center of the box
                // Draws a line between the two center points of the boxes
                if (connectlist.get(i).isVisible()) //??? here?
                {
                    page.drawLine((int) (connectlist.get(i).getP1().getX()), (int) (connectlist.get(i).getP1().getY()), (int) (connectlist.get(i).getP2().getX()), (int) (connectlist.get(i).getP2().getY()));
                }
            }
            for (int i = 0; i < nodelist.size(); i++) // Draws the boxes and textfro the nodes
            {
                // System.out.println(nodelist.get(i).getName() + " " +nodelist.get(i).getState()/* + " " + nodelist.get(i).isVisible()*/);

                //x.y.w.h
                //System.out.println(nodelist.size());
                //System.out.println(nodelist.get(i).getName() + " " +nodelist.get(i).getState() + " " + nodelist.get(i).isVisible());
                if (nodelist.get(i).isDrawn())
                {
                    //System.out.println("here");
                    page.setColor(Color.green);  // TODO allow user to mod colors
                    strlength = nodelist.get(i).getName().length();
                    drawBox = nodelist.get(i).getPoint();
                    page.fillRect(drawBox.x - 10, drawBox.y - 10, (strlength * 7) + 10, 25);// Math done for the sixe of the box
                    page.setColor(Color.black);
                    if (nodelist.get(i).isGuessed())
                    {
                        //System.out.println("yea i'm guessed" + nodelist.get(i).getName() + " " + i);
                        page.drawString(nodelist.get(i).getName(), drawBox.x - 3, drawBox.y + 7);// Draws the text on top of the box
                    } else if (nodelist.get(i).isVisible())  //@todo fixed? colerative updates? oh shit
                    {
                        //System.out.println("Yea i'm visible " + nodelist.get(i).getName() );
                        String str = "";
                        for (int a = 0; a < strlength; a++)
                        {
                            str += " ";
                        }
                        page.drawString(str, drawBox.x - 3, drawBox.y + 7);
                    }
                }//*/
            }
        }
    }

   
}



