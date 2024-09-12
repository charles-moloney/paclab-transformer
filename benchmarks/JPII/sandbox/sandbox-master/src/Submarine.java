import gov.nasa.jpf.symbc.Debug;
import java.awt.*;
import java.util.ArrayList;

public class Submarine{
	
	public Submarine(int x,int y,int color,double angle){
	}
	
	public boolean needsRepaint(){
		boolean moving = Debug.makeSymbolicBoolean("x0");
		if (moving)
			return true;
		for(int index = 0; index<Debug.makeSymbolicInteger("x1");index++){
			if(Debug.makeSymbolicBoolean("x2")){
				return true;
			}
		}
		return false;
	}
	
	public void MouseMoved(int x, int y){
		for(int index = 0; index<Debug.makeSymbolicInteger("x0"); index++){
		}
	}
	public void MouseClicked(int x, int y){
	}
}
