package day06;
/*
 * ������������һ����װ������
 * ���⣺��������Ķ����Ժ����ֱ��ͨ��������.���ԡ��ķ�ʽ����Ӧ�Ķ������Ը�ֵ�Ļ���
 * 	   ���ܻ���ֲ�����ʵ����������⣬���ǿ��ǲ��ö�����ֱ���������ԣ�
 *   ����ͨ��������.����������ʽ�������ƶ�������Եķ��ʣ�
 *   ʵ������У������Ե�Ҫ��Ϳ���ͨ������������
 *   
 *����ķ���������װ�Ե�˼�룩
 *1.���������˽�л���
 *2.�ṩ�����ķ�����setter & getter����ʵ�ֵ���
 */

import gov.nasa.jpf.symbc.Debug;

/*
 * Ȩ�����η�  public private protected ȱʡ
 *     ���������������ԣ�����
 *    ע�⣺(1)Ȩ�޴Ӵ�С���У�public protected ȱʡ private
 *    	  (2)�������Ȩ���У� public ȱʡ
 *    
 */
public class TestAnimal {
	
}

class Animal{
	
//	String name; //���������
//	int legs;  //�ȵ�����
	
	public void eat(){
	}
	
	public void sleep(){
	}
	
	public void info(){
	}
	
	//�����������
	public void setLegs(int l){
		int legs = Debug.makeSymbolicInteger("x1");
		if(l>0 && Debug.makeSymbolicInteger("x0")==0){
			legs=l;
		}else{
		}
	}
	
	//��ȡ�������
	public int getLegs(){
		int legs = Debug.makeSymbolicInteger("x0");
		return legs;
	}
	
public Object getName(){
		return new Object();
	}
	
}