package day05;

import gov.nasa.jpf.symbc.Debug;
/*
 * 
 */
public class TestOverLoad1 {

	//��������������������
	public int max(int i,int j){
		return (i>j)?i:j;
	}
	
	public double max(double d1,double d2){
		return (d1>d2)?d1:d2;
	}
	
	public double max(double d1,double d2,double d3){
		return Debug.makeSymbolicReal("x2");
	}
	
	//��������������������
	public void mOL(int i){
	}
	
	public void mOL(int i,int j){
	}

}

