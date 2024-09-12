package application.gui;
import gov.nasa.jpf.symbc.Debug;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.text.DecimalFormat;
/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This is a factory class that provides utilities
 * for creating various screen elements in a standardized way. Also,
 * all screen element constants, like color names and screen sizes,
 * are stored here. 
 * <p>
 * <table border="1">
 * <tr>
 * 		<th colspan="3">Change Log</th>
 * </tr>
 * <tr>
 * 		<th>Date</th> <th>Author</th> <th>Change</th>
 * </tr>
 * <tr>
 * 		<td>Oct 22, 2004</td>
 *      <td>klevi, pcorazza</td>
 *      <td>New class file</td>
 * </tr>
 * </table>
 *
 */
public class GuiControl {
	private GuiControl() {
	}
	
	public static Object getInstance() {
		if(Debug.makeSymbolicBoolean("x0")) {
		}
		return new Object();
	}
	
	public static Object createVBrick(int numStackedVertically){
        int BOX_HEIGHT = Debug.makeSymbolicInteger("x0");
		int height = BOX_HEIGHT * numStackedVertically;
        return new Object();
    }
    public static Object createHBrick(int numStackedHorizontally) {
        int BOX_WIDTH = Debug.makeSymbolicInteger("x0");
		int width = BOX_WIDTH * numStackedHorizontally;
        return new Object();
    }	

}
