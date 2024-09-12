/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package omninode28;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 * Write a description of class OmniPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class OmniPanel extends JPanel
{

    protected ArrayList<Node> nodes;
    protected ArrayList<Connect> connections;

    public OmniPanel(ArrayList<Connect> cl, ArrayList<Node> nl)
    {
        nodes = nl;
        connections = cl;
    }

    /*
     * Get the point at which a node exists, based on its name
     */
    public static Node name2node(String name, ArrayList<Node> nodelist)
    {
        for (int itb = 0; itb < nodelist.size(); itb++)
        {
            if (nodelist.get(itb).getName().equalsIgnoreCase(name))
            {
                return nodelist.get(itb);
            }
        }
        return null;
    }

    /*
    Load Nodes into the arraylists that
     */
    public static void load(ArrayList<Node> nodelist, ArrayList<Connect> connectlist, String filename)
    {
        if (filename != null && (filename.substring(filename.length() - 4)).equals(".onm"))
        {
            try
            {
                FileInputStream fstream = new FileInputStream(filename);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String nodeName, xVal, yVal, isGue, node1, node2;
                double xValue, yValue;

                //Read File Line By Line
                String str = "one"; //= br.readLine();
                Scanner scan = null; //= new Scanner(str);
                while (!(str.equalsIgnoreCase("eon")))
                {
                    str = br.readLine();
                    if (!(str.equalsIgnoreCase("eon")))
                    {
                        scan = new Scanner(str);
                        scan.useDelimiter("/");
                        nodeName = scan.next();
                        xValue = Double.parseDouble(scan.next());
                        yValue = Double.parseDouble(scan.next());
                        isGue = scan.next(); // one of three things "hidden", "guessed", "visible"

                        //Add the node recovered from file to the arraylist.
                        Node tempb = new Node(new Point((int) xValue, (int) yValue), nodeName, isGue);
                        //Add it to the ArrayList
                        nodelist.add(tempb);
                    }
                }
                while (!(str.equalsIgnoreCase("eoc")))
                {
                    str = br.readLine(); //Get the line to text to parse
                    if (!(str.equalsIgnoreCase("eoc")))
                    {
                        scan = new Scanner(str);
                        scan.useDelimiter("/");

                        node1 = scan.next(); //Gets the name of the node
                        node2 = scan.next(); //Gets the name of the node
                        if (IO.name2node(node1, nodelist) != null && IO.name2node(node2, nodelist) != null)
                        {
                            Connect tc = new Connect(IO.name2node(node1, nodelist), IO.name2node(node2, nodelist));
                            connectlist.add(tc);
                        // add new connections to nodes connect list(interfaceconnrct.addCt)
                        } else
                        {
                            System.out.println("Error, those nodes dont exist.");
                        }
                    }
                }

                in.close();//Close the input stream
            } catch (Exception e)//Catch exception if any
            {
                System.out.println("Error: " + e.getMessage() + " IO Module line ~133");
                IO.errMsg("That file is incorrectly formatted.");

            }
        } else
        {
            IO.errMsg("Sorry, that file has an incorrect extension.");
        }
    }

    //error messages

    //save abstract
    //public abstract void save(ArrayList<Node> nodelist, ArrayList<Connect> connectlist, String filename);
}

