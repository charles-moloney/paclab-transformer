/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package omninode28;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author student
 */
public class SettingsFrame extends JFrame implements ActionListener
{

    Node WN;
    NodePanel NP;
    private JFrame NEF;
    private JTextField nameField;
    private JTextField XField;
    private JTextField hField;
    private JTextField YField;
    private JTextField wField;
    private JComboBox stateList;
    private JCheckBox cc1;

    public SettingsFrame(Node wn, NodePanel NPt)
    {
        NP = NPt;
        WN = wn;
        NEF = new JFrame("Editing: " + WN.getName());

        //NEF.setLayout(new BorderLayout());
        //JPanel panel = new JPanel(new GridLayout(0,2));
        //label then box
        //Stuff to edit:
        //x and y cordinates
        //name
        //connections
        //height and width
        //state at start
        // alternate acceptances
        input();

        NEF.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                NEF.setVisible(false);
                NEF.dispose();
            }
        });

        NEF.setSize(515, 245);
        NEF.setVisible(true);

    }

    //-----
    // Draws the whole panel
    //-----
    public void input()
    {

        //NEF.setTitle("Team " + Robo.getTeamNumber());

        // Create a panel with all the info labels in it.
        JPanel pane = new JPanel(new GridLayout(0, 2));


        // Spacer
        JLabel spacer1 = new JLabel("                  ");
        JLabel spacer2 = new JLabel("                  ");
        pane.add(spacer1);
        pane.add(spacer2);


        // TeamNr
        JLabel nameLabel = new JLabel("    Node:");

        nameField = new JTextField(WN.getName());

        //teamNo2.add(teamNo2a);

        pane.add(nameLabel);
        pane.add(nameField);

        // Spacer
        JLabel spacer3 = new JLabel("                  ");
        JLabel spacer4 = new JLabel("                  ");
        pane.add(spacer3);
        pane.add(spacer4);


        // Victories

        JLabel posLabel = new JLabel("    Position:");
        GridLayout GL1 = new GridLayout(0, 4);
        GL1.setVgap(5);
        JPanel cordinates = new JPanel(GL1);
        JLabel X = new JLabel("X:");
        cordinates.add(X);
        XField = new JTextField("" + WN.getX());
        cordinates.add(XField);
        JLabel Y = new JLabel("   Y:");
        cordinates.add(Y);
        YField = new JTextField("" + WN.getY());
        cordinates.add(YField);
        pane.add(posLabel);
        pane.add(cordinates);

        //pane.add(victories2);

        // Defeats
        JLabel dimensions = new JLabel("    Node Dimensions:");
        pane.add(dimensions);
        JPanel cordinates1 = new JPanel(new GridLayout(0, 4));
        JLabel Hlabel = new JLabel("Height:");
        cordinates1.add(Hlabel);
        hField = new JTextField("" + WN.getH());
        cordinates1.add(hField);
        JLabel Wlabel = new JLabel("   Width:");
        cordinates1.add(Wlabel);
        wField = new JTextField("" + WN.getW());
        cordinates1.add(wField);

        pane.add(cordinates1);

        // Spacer
        JLabel spacer5 = new JLabel("                  ");
        JLabel spacer6 = new JLabel("                  ");
        pane.add(spacer5);
        pane.add(spacer6);





        // Offensive / Defensive
        JLabel offensive1 = new JLabel("    How Should the node start?:");
        GridLayout test = new GridLayout(1, 3);
        test.setVgap(0);
        //JPanel state = new JPanel(test);
        //WN.getState();
        String[] options = new String[3];
        options[0] = WN.getState();
        if (WN.getState().equalsIgnoreCase("visible"))
        {
            options[1] = "hidden";
            options[2] = "guessed";

        } else if (WN.getState().equalsIgnoreCase("hidden"))
        {
            options[1] = "visible";
            options[2] = "guessed";

        }
        else //if (WN.getState().equalsIgnoreCase("guessed"))
        {
            options[1] = "visible";
            options[2] = "hidden";

        }

        //=
        //{
        //    "Guessed", "Visible", "Hidden"
        //};
        stateList = new JComboBox(options);
        //state.add(stateList);
        //guessed = new JRadioButton("Guessed", WN.isGuessed());
        //visible = new JRadioButton("Visible", WN.isVisible());
        //hidden = new JRadioButton("Hidden", WN.isHidden());
        //state.add(guessed);
        //state.add(visible);
        //state.add(hidden);

        pane.add(offensive1);
        pane.add(stateList);


//        ButtonGroup rbGroup = new ButtonGroup();
//        rbGroup.add(guessed);
//        rbGroup.add(visible);
//        rbGroup.add(hidden);


        // Can Hung
        JLabel connections = new JLabel("    Connections:");

        //Height varible needs to change based on number of connections
        JPanel connectContainer = new JPanel(new GridLayout(0, 2));
        cc1 = new JCheckBox("blake");
        //anHang2b = new JTextField(" + Robo.getAmountHang()", 1);
        //canHang2.add(canHang2a);
        connectContainer.add(cc1);

        pane.add(connections);
        pane.add(connectContainer);


        // Spacer
        JLabel spacer11a = new JLabel("                  ");
        JLabel spacer12a = new JLabel("                  ");
        pane.add(spacer11a);
        pane.add(spacer12a);





        NEF.add(pane);


        // BUTTONS

        // Panel with close button
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        // Close button
        JButton close = new JButton("Close");
        close.addActionListener(this);
        controls.add(close);

        // save button
        JButton save = new JButton("Save");
        save.addActionListener(this);
        controls.add(save);


        NEF.add(controls, BorderLayout.SOUTH);




    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        boolean error = false;

        //-----
        // SAVE BUTTON
        //-----
        if (e.getActionCommand().equals("Save"))
        {
            WN.setName(nameField.getText());
            error = false;

            int x = 0, y = 0, w = 0, h = 0;
            try
            {
                x = Integer.parseInt(XField.getText());
                y = Integer.parseInt(YField.getText());
                h = Integer.parseInt(hField.getText());
                w = Integer.parseInt(wField.getText());

            } catch (NumberFormatException NFE)
            {
                String err = NFE.getMessage();
                IO.errMsg(err.substring(19, err.length() - 1) + "Is invalid as it contains a non numerical or decimal value. \n Please enter an integer in the place of " + err.substring(19, err.length() - 1) + ".");
                error = true;

            }
            if (error == false)
            {
                WN.moveTo(new Point(x, y));
                WN.setH(h);
                WN.setW(w);

                if (((String) stateList.getSelectedItem()).equalsIgnoreCase("guessed"))
                {
                    WN.setGuessed();
                } else if (((String) stateList.getSelectedItem()).equalsIgnoreCase("hidden"))
                {
                    WN.setHidden();
                } else if (((String) stateList.getSelectedItem()).equalsIgnoreCase("visible"))
                {
                    WN.setVisible();
                }

                //@todo change how the text is centered in the box
                //@todo show invisible nodes

                NP.repaint();
                // close this window
                NEF.setVisible(false);
                NEF.dispose();
            }
        }

        //----
        // CLOSE BUTTON
        //----
        if (e.getActionCommand().equals("Close"))
        {
            NEF.setVisible(false);
            NEF.dispose();
        }


    }


}
