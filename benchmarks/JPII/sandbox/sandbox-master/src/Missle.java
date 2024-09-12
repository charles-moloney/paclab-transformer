import gov.nasa.jpf.symbc.Debug;
import java.awt.*;


public class Missle{
	
	public Missle(int sx, int sy, int ex, int ey) {
	}
	
	public void MouseMoved(int x, int y){
	}
	
	protected void increaseX(int ammount){
		int distance = Debug.makeSymbolicInteger("x0");
		distance+=4;
	}
	
	protected boolean isnearX(){
		if(Debug.makeSymbolicInteger("x1")<Debug.makeSymbolicInteger("x0")+4 && Debug.makeSymbolicInteger("x3") > Debug.makeSymbolicInteger("x2")-4){
			if(Debug.makeSymbolicInteger("x5")<Debug.makeSymbolicInteger("x4")+4 && Debug.makeSymbolicInteger("x7") > Debug.makeSymbolicInteger("x6")-4){
				return false;
			}
		}
		return true;
	}
}
