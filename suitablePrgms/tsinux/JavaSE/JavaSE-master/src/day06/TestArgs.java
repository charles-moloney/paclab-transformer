package day06;

import gov.nasa.jpf.symbc.Debug;
/*
 * �ɱ�������βεķ���
 * 1.��ʽ�����ڷ������βΣ���������...�β���
 * 2.�ɱ�������βεķ�����ͬ���ķ���֮�乹������
 * 3.�ɱ�������β��ڵ���ʱ��������0��ʼ����������������
 * 4.ʹ�ÿɱ����βεķ����뷽�����β�ʹ��������һ�µ�
 * 5.�������д��ڿɱ�������βΣ���ôһ��Ҫ�����ڷ����βε����
 * 6.��һ�������У��������һ���ɱ�������β�
 */
public class TestArgs {

	//����4��������������
	public void sayHello(){
	}
	
	//�ɱ�����βε�ʹ�õ�����
	public int getSum(int i,int j){
		return i+j;
	}
	public int getSum(int i,int j,int k){
		return i+j+k;
	}
	
	public int getSum(int ... args){
		int sum=0;
		for(int i=0;i<Debug.makeSymbolicInteger("x0");i++){
			sum+=args[i];
		}
		return sum;
	}
	
	
	
	
}

