import gov.nasa.jpf.symbc.Debug;
import java.util.*;
import java.awt.*;


public class Turret {
	public Turret() {}
	public Turret(int x, int y, int max, int min, int size, int shipRotation){
		boolean moving = Debug.makeSymbolicBoolean("x5");
		int gunSize = Debug.makeSymbolicInteger("x4");
		int rotation = Debug.makeSymbolicInteger("x3");
		int maxRotation = Debug.makeSymbolicInteger("x2");
		double centery = Debug.makeSymbolicReal("x1");
		double centerx = Debug.makeSymbolicReal("x0");
		centerx = x;
		centery = y;
		maxRotation = max;
		rotation = 0;
		gunSize = 4;
		moving = false;
	}
	
	public void MouseMoved(int x, int y){
		int rotation = Debug.makeSymbolicInteger("x0");
		rotation = Debug.makeSymbolicInteger("x1");
	}
	public void MouseClicked(int x, int y){
	}
	public void addX(int x){
		double centerx = Debug.makeSymbolicReal("x0");
		centerx+=x;
	}
	public void addY(int y){
		double centery = Debug.makeSymbolicReal("x0");
		centery+=y;
	}
	public void addSize(int s){
		int size = Debug.makeSymbolicInteger("x0");
		size+=s;
	}
	public boolean needsRepaint(){
		boolean moving = Debug.makeSymbolicBoolean("x0");
		if (moving)
			return true;
		for(int index=0; index<Debug.makeSymbolicInteger("x1"); index++){
			if(Debug.makeSymbolicBoolean("x2"))
				return true;
		}
		return false;
	}
	
	private int getAngle(int x, int y){
		int shipRotation = Debug.makeSymbolicInteger("x3");
		double centerx = Debug.makeSymbolicReal("x1");
		double centery = Debug.makeSymbolicReal("x0");
		double ycomp = centery-y;
    	double xcomp = centerx-x;
    	double theta = Debug.makeSymbolicReal("x2");
    	theta+=shipRotation;
    	if(xcomp<0)
    		theta+=180;
    	return (int) theta;
	}
	
	public void fireGun(int x, int y){
	}
	
	private void snapTurret(){
		int maxRotation = Debug.makeSymbolicInteger("x1");
		int desrotation = Debug.makeSymbolicInteger("x0");
		if(desrotation<0){
			desrotation +=360;
		}
		desrotation%=360;
		if(desrotation>maxRotation){
			int temp = 360-maxRotation;
			if(desrotation<=maxRotation +temp/2)
				desrotation = maxRotation;
			else
				desrotation = 0;
		}
	}
	
	private int getCos(int size,int gunRotation){
		return Debug.makeSymbolicInteger("x1");
	}
	private int getSin(int size, int gunRotation){
		return Debug.makeSymbolicInteger("x1");
	}
	
	public void shipRotated(double theta,int x, int y) {
		double centery = Debug.makeSymbolicReal("x4");
		double centerx = Debug.makeSymbolicReal("x3");
		double xdistance = Debug.makeSymbolicReal("x0");
		double ydistance = Debug.makeSymbolicReal("x1");
		double totaldistance = Debug.makeSymbolicReal("x2");
		
		centerx = x;
		centery = y;
	
		xdistance = (totaldistance*Debug.makeSymbolicReal("x5"));
		ydistance = (totaldistance*Debug.makeSymbolicReal("x6"));
		
		centerx += xdistance;
		centery += ydistance;
	}
}
