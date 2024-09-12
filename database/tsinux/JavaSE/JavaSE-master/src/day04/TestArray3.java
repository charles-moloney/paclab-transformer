
package day04;
/*
 * 1.求数组元素的最大值，最小值，平均数，总和等
 * 2.数组的复制，反转
 * 3.数组元素的排序
 */
public class TestArray3 {

	public static void main(String[] args) {
	
		int[] arr=new int[]{12,43,9,0,-65,-99,100,9};
		
		//最大值
		int max=arr[0];
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		System.out.println("数组的最大值为："+max);
		
		//最小值
		int min=arr[0];
		for(int i=0;i<arr.length;i++){
			if(min>arr[i]){
				min=arr[i];
			}
		}
		System.out.println("数组的最小值为："+min);
		
		//总和
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
		}
		System.out.println("总和为："+sum);
		
		//平均值
		int avg=0;
		avg=sum/arr.length;
		System.out.println("平均数为："+avg);
		
		//数组的复制
		
		/*
		int[] array1,array2;
		array1=new int[]{2,3,5,7,11,13,17,19};
		
		for(int i=0;i<array1.length;i++){
			System.out.print(array1[i]+"\t");
		}
		
		System.out.println();
		
		array2=array1;        //不能这么复制，这样影响array1
		
		//for(int i=0;i<array2.length;i++){
		//	System.out.print(array2[i]+"\t");
		//}
		for(int i=0;i<array2.length;i++){
			if(i%2==0){
				array2[i]=i;
			}
		}
		
		for(int i=0;i<array1.length;i++){
			System.out.print(array1[i]+"\t");
		}
		
		
		//正确复制如下
		int[] array1,array2;
		array1=new int[]{2,3,5,7,11,13,17,19};
		
		for(int i=0;i<array1.length;i++){
			System.out.print(array1[i]+"\t");
		}
		
		System.out.println();
		
		array2=new int[array1.length];
		//给array2赋值
		for(int i=0;i<array2.length;i++){
			if(i%2==0){
				array2[i]=i;
			}else{
				array2[i]=array1[i];
			}
			
		}
		
		System.out.println("array2：");
		for(int i=0;i<array2.length;i++){
			System.out.print(array2[i]+"\t");
		}
		
		System.out.println();
		
		System.out.println("array1：");
		for(int i=0;i<array1.length;i++){
			System.out.print(array1[i]+"\t");
		}
		*/
		int[] arr1=new int[arr.length];
		for(int i=0;i<arr1.length;i++){
			arr1[i]=arr[i];
		}
		
		//遍历
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
		
		
		//数组元素的反转
		/*for(int i=0;i<arr.length/2;i++){
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		*/
		for(int x=0,y=arr.length-1;x<y;x++,y--){
			int temp=arr[x];
			arr[x]=arr[y];
			arr[y]=temp;
		}
		
		System.out.println();
		System.out.println("反转之后的结果：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
		
		
		//使用冒泡排序使数组元素从小到大排列
		/*
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		*/
		
		
		//使用直接选择排序使数组元素从小到大排列
		/*
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		*/
		for(int i=0;i<arr.length-1;i++){
			int t=i;
			for(int j=i;j<arr.length;j++){
				if(arr[t]>arr[j]){
					t=j;
				}
			}
			if(t !=i){
				int temp=arr[t];
				arr[t]=arr[i];
				arr[i]=temp;
			}
		}
		
		
		
		
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
