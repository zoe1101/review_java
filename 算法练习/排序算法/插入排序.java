package 排序算法;

import java.util.Scanner;

public class 插入排序 {

	public static void main(String[] args) {
		Scanner stdinScanner=new Scanner(System.in);
		int n=stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		
		arr=Insertsort(arr);
		printArray(arr);

	}
	

	// 打印所有数组元素
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
		
//	  直接插入排序
		public static int[] Insertsort(int[] arr) {
			for(int i=1;i<arr.length;i++) { 
				for (int j=i;j>0;j--) { //为arr[i]在前面的arr[0...i-1]有序区间中找一个合适的位置
					if(arr[j]<arr[j-1]) { //如果arr[j]小于前一个数，进行插入调换
						int temp=arr[j];
						arr[j]=arr[j-1];
						arr[j-1]=temp;
					}
				}
				System.out.print(i+": ");
				printArray(arr);
			}
			
			
			
			return arr;
			
		}
	
			
}

