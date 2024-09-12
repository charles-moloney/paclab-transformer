/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package omninode28;

/**
 * File Input/Output
 *
 * @author (Blake B)
 * @version (v1.0)
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;

public class IO
{
    //@todo  check for existing files
    //@todo  use a nicer saving mechanism
    /**
     * Save info to file
     * @param nodelist list of nodes to save
     * @param connectlist list of connections to save
     * @param filename name of file to save to
     */
    public static void write(ArrayList<Node> nodelist, ArrayList<Connect> connectlist, String filename)
    {
        if (filename != null)
        {
            if(!filename.substring(filename.length()-4).equals(".onm"))
                filename += ".onm";
            try
            {
                FileWriter fstream = new FileWriter(filename);
                BufferedWriter out = new BufferedWriter(fstream);

                for (int count = 0; count < nodelist.size(); count++)
                {
                    if (nodelist.get(count) != null)
                    {
                        out.write(nodelist.get(count).getName());
                        out.write("/");
                        out.write(nodelist.get(count).getOrderedPair("/"));
                        out.write("/");
                        out.write(nodelist.get(count).getState().toString());
                        out.write("\n");
                    }
                }
                out.write("EON\n");
                // End of Nodes
                for (int count = 0; count < connectlist.size(); count++)
                {
                    if (connectlist.get(count) != null) // Why would it be null?
                    {
                        out.write(connectlist.get(count).getN1().getName());
                        out.write("/");
                        out.write(connectlist.get(count).getN2().getName());
                        out.write("\n");
                    } else
                    {
                        System.err.println("Got a null object from connectlist");
                    }
                }
                out.write("EOC"); // End of Nodes
                out.close(); //Close the output stream
            } catch (Exception e)//Catch exception if any
            {
                //System.err.println("Error: " + e.getMessage() /*+ "Line 56 IO"*/);
                IO.errMsg("Something went wrong...");
            }
        } else
        {
            IO.errMsg("Sorry the name must be at least 1 character long");
        }
    //@todo make restrictions on file names
    }

    public static void load(ArrayList<Node> nodelist, ArrayList<Connect> connectlist, String filename)
    {
        if (filename != null && (filename.substring(filename.length()-4)).equals(".onm"))
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
        }
        else
            IO.errMsg("Sorry, that file has an incorrect extension.");
    }

    public static Node point2node(Point click, ArrayList<Node> nodelist)
    {
        for (int ita = 0; ita < nodelist.size(); ita++)
        {
            if (nodelist.get(ita).isPointInNode(click))
            {
                return nodelist.get(ita);
            }
        }
        return null;
    }

    /**
     *
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
    //@todo comment these
    public static void errMsg(String str)
    {
        JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void errMsg(String str, String str1)
    {
        JOptionPane.showMessageDialog(null, str, str1, JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Provides the capability of the programmer to hide deug System.out.println's
     * @param str the string to print
     */
    public static void d(String str, boolean debug)
    {
        if(debug)
            System.out.println(str);
    }

   

}
