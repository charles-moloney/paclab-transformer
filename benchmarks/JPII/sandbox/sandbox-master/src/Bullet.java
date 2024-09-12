import gov.nasa.jpf.symbc.Debug;
import java.awt.*;

public class Bullet {
	public Bullet(int sx,int sy,int ex, int ey){
		boolean moving = Debug.makeSymbolicBoolean("x7");
		int count = Debug.makeSymbolicInteger("x6");
		int currenty = Debug.makeSymbolicInteger("x5");
		int currentx = Debug.makeSymbolicInteger("x4");
		double endy = Debug.makeSymbolicReal("x3");
		double endx = Debug.makeSymbolicReal("x2");
		double starty = Debug.makeSymbolicReal("x1");
		double startx = Debug.makeSymbolicReal("x0");
		startx = sx;
		starty = sy;
		endx = ex;
		endy = ey;
		currentx=(int)startx-1;
		currenty=(int)starty-1;
		count = 0;
		moving =false;
	}
	
	public boolean needsRepaint(){
		boolean moving = Debug.makeSymbolicBoolean("x0");
		if(moving)
			return true;
		return false;
	}
	
	protected void increaseX(int ammount){
		int currenty = Debug.makeSymbolicInteger("x10");
		int currentx = Debug.makeSymbolicInteger("x9");
		int count = Debug.makeSymbolicInteger("x6");
		double starty = Debug.makeSymbolicReal("x3");
		double endy = Debug.makeSymbolicReal("x2");
		double startx = Debug.makeSymbolicReal("x1");
		double endx = Debug.makeSymbolicReal("x0");
		double xdistance = endx-startx;
		double ydistance = endy-starty;
		double theta = Debug.makeSymbolicReal("x4");
		if(xdistance < 0 ){
			theta+=Debug.makeSymbolicReal("x5");
		}
		double x = (count)*Debug.makeSymbolicInteger("x7");
		double y = (count)*Debug.makeSymbolicInteger("x8");
		currentx=(int)(x+startx);
		currenty=(int)(y+starty);
		count+=2;
	}
	
	protected void finished(){
		boolean moving = Debug.makeSymbolicBoolean("x1");
		boolean done = Debug.makeSymbolicBoolean("x0");
		done = true;
		moving = false;
	}
	
	protected boolean isnearX(){
		double endx = Debug.makeSymbolicReal("x1");
		int currentx = Debug.makeSymbolicInteger("x0");
		if(currentx<(int)endx+2 && currentx > (int)endx-2){
				return false;
		}
		return true;
	}
	
	public boolean isdone(){
		boolean done = Debug.makeSymbolicBoolean("x0");
		return done;
	}
	public boolean getMoving(){
		boolean moving = Debug.makeSymbolicBoolean("x0");
		return moving;
	}
}
