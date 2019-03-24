package 排序算法;

import java.util.Scanner;
//选择排序：（比冒泡排序更快，运行次数更少）

public class 选择排序 {

	public static void main(String[] args) {
		Scanner stdinScanner=new Scanner(System.in);
		int n=stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		
		arr=SmalltoBig(arr);
		printArray(arr);
		arr=BigtoSmall(arr);
		printArray(arr);

	}
	

	// 打印所有数组元素
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
		
//	    从小到大
		public static int[] SmalltoBig(int[] arr) {
			for(int i=0;i<arr.length-1;i++) {  //i为已排序序列的末尾
				for (int j=i+1;j<arr.length;j++) { //j为未排序序列
					if(arr[j]<arr[i]) {  //找出未排序序列中的最小值
						
						//元素交换位置，放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
						int temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
			}
			return arr;
			
		}
		
//	    从大到小
		public static int[] BigtoSmall(int[] arr) {
			for(int i=0;i<arr.length-1;i++) {
				for (int j=i+1;j<arr.length;j++) {
					if(arr[j]>arr[i]) {
						int temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
			}
			return arr;
			
		}

}
