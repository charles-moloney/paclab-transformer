/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package omninode28;

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author student
 */
public class EditPanel extends OmniPanel {

    //protected ArrayList<Node> Nodes;
    //protected ArrayList<Connect> Connections;
    DynamicListener DL;

    public EditPanel(ArrayList<Connect> cl, ArrayList<Node> nl, JFrame of) {
        super(cl, nl);
        //Nodes = nl;
        //Connections = cl;

        // listner fallacy here
        NodePanel NP = new NodePanel(nodes, connections, true);
        DL = new DynamicListener(of, nl, cl, NP, this);

        add(NP);
        addMouseListener(DL);
        addMouseMotionListener(DL);

    }

    /*
     * Saves the nodes
     */
    public void save(ArrayList<Node> nodelist, ArrayList<Connect> connectlist, String filename) {
        if (filename != null) {
            if (!filename.substring(filename.length() - 4).equals(".onm")) {
                filename += ".onm";
            }
            try {
                FileWriter fstream = new FileWriter(filename);
                BufferedWriter out = new BufferedWriter(fstream);

                for (int count = 0; count < nodelist.size(); count++) {
                    if (nodelist.get(count) != null) {
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
                for (int count = 0; count < connectlist.size(); count++) {
                    if (connectlist.get(count) != null) // Why would it be null?
                    {
                        out.write(connectlist.get(count).getN1().getName());
                        out.write("/");
                        out.write(connectlist.get(count).getN2().getName());
                        out.write("\n");
                    } else {
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
        } else {
            IO.errMsg("Sorry the name must be at least 1 character long");
        }
        //@todo make restrictions on file names
    }

    /*
     * Menu Bar at the top of the frame
     */
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;


        //Create the menu bar.
        menuBar = new JMenuBar();
        //ml = new MenuListener();

        //Build the first menu.
        menu = new JMenu("File");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(DL);
        menu.add(menuItem);

        menuItem = new JMenuItem("Open");
        menuItem.addActionListener(DL);
        menu.add(menuItem);

        menuItem = new JMenuItem("Close");
        menuItem.addActionListener(DL);
        menu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Show OmniNode");
        menuItem.addActionListener(DL);
        menu.add(menuItem);

        menu = new JMenu("Edit");
        menuBar.add(menu);

        //@todo if only one node is selected, enable the menu items, else disable them
        menuItem = new JMenuItem("Node");
        menuItem.addActionListener(DL);
        menu.add(menuItem);

        menuItem = new JMenuItem("Connection");
        menuItem.addActionListener(DL);
        menu.add(menuItem);

        menu = new JMenu("Help");
        menuBar.add(menu);

        menuItem = new JMenuItem("Show Tutorial");
        menuItem.addActionListener(DL);

        menuItem = new JMenuItem("About");
        menuItem.addActionListener(DL);

        menu.add(menuItem);

        return menuBar;
    }

    /*
     * Right Click Popup / COntext Menu
     */
    JPopupMenu createPopupMenu(Point abc, DynamicListener DL) {
        //ml = new MenuListener(abc);
        JMenuItem menuItem;

        //Create the popup menu.
        JPopupMenu popup = new JPopupMenu();

        JMenu popupSub = new JMenu("New");
        menuItem = new JMenuItem("Node"); //will be available based on left click too
        menuItem.addActionListener(DL);
        popupSub.add(menuItem);

        menuItem = new JMenuItem("Connection");
        menuItem.addActionListener(DL);
        popupSub.add(menuItem);
        popup.add(popupSub);

        menuItem = new JMenuItem("Edit");
        menuItem.addActionListener(DL);
        popup.add(menuItem);

//        menuItem = new JMenuItem("Move");
//        menuItem.addActionListener(DL);
//        popup.add(menuItem);

        menuItem = new JMenuItem("Delete");
        menuItem.addActionListener(DL);
        popup.add(menuItem);

        return popup;
    }
}

/*
 * 
 */
class DynamicListener implements ActionListener, MouseListener, MouseMotionListener, WindowListener {

    JFrame omniFrame;
    ArrayList<Node> nodes;
    ArrayList<Connect> connections;
    JFileChooser fc;
    NodePanel NP;
    OmniPanel EP;
    Node WorkingNode;
	Point lastPoint;
    boolean onANode = false;
    Node end1, end2;
    int count = 0;
    boolean moving = false;
    int selectedCounter = 0;

    public DynamicListener(JFrame jf, ArrayList<Node> nl, ArrayList<Connect> cl, NodePanel NPt, OmniPanel EPt) {
        //System.out.println("Dynamic Listner Created");
        omniFrame = jf;
        nodes = nl;
        connections = cl;
        NP = NPt;
        EP = EPt;
        fc = new JFileChooser();
    }

	
    public void actionPerformed(ActionEvent event) {
        //Button Pushes here
        //System.out.println("Dyn Listner: " + event.getActionCommand());

        String e = event.getActionCommand();
        //System.out.println(e);

        if (e.equals("Node")) // lets make a new node
        {
            String str = JOptionPane.showInputDialog("Enter a word: "); //(debug)System.out.println(str);

            if (str != null) // if they dont press cancel and dont leave the box blank
            {
				//make sure that there is no duplicates.
				if (IO.name2node(str, nodes) == null) 
				{
					if (nodes.isEmpty()) // its the first set guessed so its visible
					{
						nodes.add(new Node(lastPoint, str, "guessed"));
					} else {
						nodes.add(new Node(lastPoint, str));
					}

				} else {
					IO.errMsg("Sorry a node with that name aready exists.", "Error: Names Match");
				}
		
            }
        }
        if (e.equals("Edit")) {
            if (onANode) {
                new NodeEditFrame(WorkingNode, NP);
            }
        }
        if (e.equals("Delete")) {
            if (onANode) {
                WorkingNode.removeConnections();
                nodes.remove(WorkingNode);



                Node toDel = WorkingNode;
                for (int i = 0; i < connections.size(); i++) {
                    Connect temp = connections.get(i);
                    if (temp.getN1().equals(toDel)) {
                        connections.remove(temp);
                    } else if (temp.getN2().equals(toDel)) {
                        connections.remove(temp);
                    }

                }
                NP.repaint();



                //connections.remove(WorkingNode);
                //alert
                //if confiremd
                //then delete
                System.out.println("Yea, I'm not ready to delete that node");
            }
        }
        if (e.equals("Connection")) {
            if (onANode) {
                System.out.println("are there two selected, select the current node first");
                //new NodeEditFrame(WorkingNode, NP);
            }
            System.out.println("Not On a node");
        }
//        if (e.equals("Move"))
//        {
//        }

        if (e.equals("Save")) {
            String filename = (String) JOptionPane.showInputDialog(null, "Please name the file to save as:", "Open:", JOptionPane.PLAIN_MESSAGE, null, null, ".onm");
            if (filename != null) {
                IO.write(nodes, connections, filename); //label.setText("Saved");
                //end.setForeground(Color.red);
                //end.setText("Saved"); //@todo need a nice message and for connect
            }
        }
        if (e.equals("Open")) {
            String filename = (String) JOptionPane.showInputDialog(null, "What file would you like to open?:", "Open:", JOptionPane.PLAIN_MESSAGE, null, null, ".onm");
            if (filename != null) {
                IO.load(nodes, connections, filename);
                NP.repaint();
            }
        }
        if (e.equals("Close")) {
            windowClosing(null);
        }
        if (e.equals("Show Tutorial")) {
        }
        if (e.equals("Show OmniNode")) {
            //Show the End User Panel
            JFrame EUF = new JFrame("OmniNode Mapper");
            EndUserPanel EUP = new EndUserPanel(nodes, connections, EUF);
            EUF.add(EUP);
            EUF.setPreferredSize(new Dimension(800, 600));
            EUF.pack();
            EUF.setVisible(true);
        }
		
		NP.repaint();
    }
////////////////////////////////////////////////////////////////////////////////

    public void mouseClicked(MouseEvent event) {
        //System.out.println("clicked");
		lastPoint = event.getPoint();
        WorkingNode = IO.point2node(event.getPoint(), nodes);
        if (WorkingNode != null) {
            onANode = true;
        } else {
            onANode = false;
        }
        clickAction(event);
    }

    public void mousePressed(MouseEvent event) {
        //System.out.println("Mouse Pressed");
        //this is needed for drag functions
        Point pressed = event.getPoint();
		lastPoint = event.getPoint();
        // is it pressed and released on a node, or a connection
        WorkingNode = IO.point2node(pressed, nodes);
        if (WorkingNode != null) {
            onANode = true;
        } else {
            onANode = false;
        }

    }

    public void mouseReleased(MouseEvent event) {
//        if (onANode)
//        {
//            WorkingNode.moveTo(event.getPoint());
//        }
//        NP.repaint();
        onANode = false;
        moving = false;

    }

    public void mouseEntered(MouseEvent me) {
        //do nothing
    }

    public void mouseExited(MouseEvent me) {
        //do nothing
    }

    public void mouseDragged(MouseEvent event) {
        if (onANode) {
            //Distance formula:
            double dist = Math.pow((Math.pow((event.getY() - WorkingNode.getY()), 2) + Math.pow((event.getX() - WorkingNode.getX()), 2)), 2);
            //System.out.println(dist);
            // if we do move a significant amount
            if (dist > 10) {
                moving = true;
                WorkingNode.moveTo(event.getPoint());
                NP.repaint();
                //System.out.println("Moveing Box");//draw and redraw
            } else {
                //System.out.println("Don't Move");
                if (!moving) {
                    //System.out.println("Don't Move");
                    clickAction(event);
                }

                // this gets called multiple times on a drag......
            }
        }
    }
    Node n1, n2;

    public void clickAction(MouseEvent event) {
        //@todo deselect all option, along with select all - one and do toggle

        if (event.isPopupTrigger() || event.getButton() == 3) //right click
        {
            ((EditPanel) EP).createPopupMenu(new Point(event.getX(), event.getY()), this).show(event.getComponent(), event.getX(), event.getY());
            WorkingNode = IO.point2node(event.getPoint(), nodes);
        } else {
            if (onANode) {
                if (WorkingNode.isSelected()) {
                    WorkingNode.setSelected(false);
                    selectedCounter--;
                } else {
                    WorkingNode.setSelected(true);
                    selectedCounter++;
                }
                NP.repaint();
                System.out.print("selected noted: " + selectedCounter);
                if (selectedCounter == 2) {
                    int choice = JOptionPane.showConfirmDialog(null, "Would you like to make a connection between the two selected nodes?", "choose one", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        for (int i = 0; i < nodes.size(); i++) {
                            if (nodes.get(i).isSelected()) {
                                if (n1 == null) {
                                    n1 = nodes.get(i);
                                } else {
                                    n2 = nodes.get(i);
                                    break;
                                }
                            }

                        }
                        //check for a connection between two nodes
                        boolean connection = false;
                        for (int i = 0; i < connections.size(); i++) {
                            if (connections.get(i).equalsConnectBetween(n1, n2)) {
                                connection = true;
                                break;
                            }
                        }

                        if (!connection) {
                            connections.add(new Connect(n1, n2));//create connection
                            n1 = n2 = null;

                            for (int i = 0; i < nodes.size(); i++) {
                                if (nodes.get(i).isSelected()) {
                                    nodes.get(i).setSelected(false);
                                    selectedCounter--;
                                }
                            }
                        }
                    }
                }
            } else {
                // When mouse is clicked show popup window store response in string str.
                String str = JOptionPane.showInputDialog("Enter a word: "); //(debug)System.out.println(str);

                if (str != null) // if they dont press cancel and dont leave the box blank
                {
                    //make sure that there is no duplicates.
                    if (IO.name2node(str, nodes) == null) {
                        if (nodes.size() == 0) // its the first set guessed so its visible
                        {
                            //Node tempa = new Node(event.getPoint(), str, "guessed");
                            //tempa.setGuessed();
                            nodes.add(new Node(event.getPoint(), str, "guessed"));
                        } else {
                            nodes.add(new Node(event.getPoint(), str));
                        }

                        //  a new node was created check for connections to it
                /* trace
                         * node ctr > set guessed > updates connections
                         */
                    } else {
                        IO.errMsg("Sorry a node with that name aready exists.", "Error: Names Match");
                    }

                    // @todo (feature)should allow for for the teacher to enter special chars for hint
                }
            }
        }

        NP.repaint();
        //@todo it repaints a lot when entering enduser
    }

    public void mouseMoved(MouseEvent arg0) {
        //do nothing
    }
//==============================================================================

    public void windowOpened(WindowEvent arg0) {
        //do nothing = initilization?
    }

    public void windowClosing(WindowEvent arg0) {
        //provide save dialog :)
        //save dialog
        //JOptionPane.showConfirmDialog(null, str, "Error",);
        int out = JOptionPane.showConfirmDialog(null, "Do you want to save your changes?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION);

        if (out == JOptionPane.YES_OPTION) {
            omniFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                IO.write(nodes, connections, file.getPath());
                //This is where a real application would save the file.
                //log.append("Saving: " + file.getName() + "." + newline);
            }

        } else if (out == JOptionPane.NO_OPTION) {
            // exit without saveing
            omniFrame.setVisible(false);
            omniFrame.dispose();
        } else //if(out == JOptionPane.CANCEL_OPTION)
        {
            omniFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }


    }

    public void windowClosed(WindowEvent arg0) {
    }

    public void windowIconified(WindowEvent arg0) {
    }

    public void windowDeiconified(WindowEvent arg0) {
    }

    public void windowActivated(WindowEvent arg0) {
    }

    public void windowDeactivated(WindowEvent arg0) {
    }
}


