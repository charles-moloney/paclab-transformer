/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package omninode28;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// is there a way to tell is a user is lookaing at a spesific tab?

public class EndUserPanel extends OmniPanel
{
    //private ArrayList<Node> Nodes;
    //private ArrayList<Connect> Connections;

    private int strlength;
    private JTextField abc;
    private JLabel label;
    private JButton sub;
    ArrayList<Node> nodelist;
    ArrayList<Connect> connectlist;
    DynamicListener DL;
    //-----------------------------------------------------------------
    //  Sets up this panel with two labels.
    //-----------------------------------------------------------------

    public EndUserPanel(ArrayList<Node> nl, ArrayList<Connect> cl, JFrame of)
    {
        super(cl, nl);

        nodelist = new ArrayList<Node>();
        connectlist = new ArrayList<Connect>();
        for (int i = 0; i < nl.size(); i++)
        {
            nodelist.add(nl.get(i));
        }

        for (int i = 0; i < cl.size(); i++)
        {
            connectlist.add(cl.get(i));
        }



        NodePanel NP = new NodePanel(nodes, connections, false); //repaint();
        DL = new DynamicListener(of, nl, cl, NP, this);
        

        /*
        //========================================================
        load = new JButton ("Load");
        load.addActionListener (new ButtonListener());
        add (load);
        //========================================================
        end = new JLabel("");
        end.setForeground(Color.white);
        add (end);*/
        abc = new JTextField(20);
        //abc.setColumns(20);
        abc.addActionListener(DL);
        label = new JLabel("Enter Your guess");
        label.setForeground(Color.white);
        sub = new JButton("Submit");
        sub.addActionListener(DL);

        //abc.addActionListener(new ButtonListener());
        NP.add(label);
        NP.add(abc);
        NP.add(sub);
        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        add(NP);
        addMouseListener(DL);
        addMouseMotionListener(DL);

    }

    
    /**
     * listens for mouse events
     */
    class DynamicListener implements ActionListener, MouseListener, MouseMotionListener, WindowListener
    {

        JFrame omniFrame;
        ArrayList<Node> nodes;
        ArrayList<Connect> connections;
        JFileChooser fc;
        NodePanel NP;
        OmniPanel EP;
        Node WorkingNode;
        boolean onANode = false;
        Node end1, end2;
        int count = 0;
        boolean moving = false;
        int selectedCounter = 0;

        public DynamicListener(JFrame jf, ArrayList<Node> nl, ArrayList<Connect> cl, NodePanel NPt, OmniPanel EPt)
        {
            System.out.println("Dynamic Listner Created");
            omniFrame = jf;
            nodes = nl;
            connections = cl;
            NP = NPt;
            EP = EPt;
            fc = new JFileChooser();
        }


        //--------------------------------------------------------------
        //  Does stuff when a button is pushed.  @todo make better comments  guessing part
        //--------------------------------------------------------------
        public void actionPerformed(ActionEvent event)
        {
            String text = abc.getText();//from textfield

            // only check visible boxes
            for (int i = 0; i < nodes.size(); i++)
            {
                if (nodes.get(i).getName().equalsIgnoreCase(text) && nodes.get(i).isVisible())// @todo does it get set to
                {
                    nodes.get(i).setGuessed();
                }

            }
            //abc.setColumns(20);
            abc.setText("");
            //abc.addActionListener(new abcListener());
            NP.repaint();
        //@todo save and inport issue

        //String filename = (String)JOptionPane.showInputDialog(null,"Please name the file to save as:","Open:", JOptionPane.PLAIN_MESSAGE,null,null,"out.txt");

        }

        public void mouseClicked(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mousePressed(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseReleased(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseEntered(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseExited(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseDragged(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseMoved(MouseEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowOpened(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowIconified(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent arg0)
        {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     *
     */
    public Node point2node(Point click)
    {
        for (int ita = 0; ita < nodes.size(); ita++)
        {
            if (nodes.get(ita).isPointInNode(click))
            {
                return nodes.get(ita);
            }
        }
        return null;
    }

    /**
     *
     */
    public Node name2node(String name)
    {
        for (int itb = 0; itb < nodes.size(); itb++)
        {
            if (nodes.get(itb).getName().equalsIgnoreCase(name))
            {
                return nodes.get(itb);
            }
        }
        return null;
    }
}



