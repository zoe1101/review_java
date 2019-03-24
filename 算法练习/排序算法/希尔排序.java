package ÅÅĞòËã·¨;

import java.util.Scanner;

public class Ï£¶ûÅÅĞò {
	public static void main(String[] args) {
		Scanner stdinScanner=new Scanner(System.in);
		int n=stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		
		arr=ShellSort(arr);
		printArray(arr);

	}
	

	// ´òÓ¡ËùÓĞÊı×éÔªËØ
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
		
//	  Ï£¶ûÅÅĞò
		public static int[] ShellSort(int[] arr) {
			
			
			for(int gap=arr.length/2;gap>=1;gap/=2) { 
				for (int i=gap;i<arr.length;i++) { 
					for(int j=i-gap;j>=0&&arr[j]>arr[j+gap];j-=gap) {
						int temp=arr[j];
						arr[j]=arr[j+gap];
						arr[j+gap]=temp;
					}

				}
				System.out.print(gap+": ");
				printArray(arr);
			}
			return arr;
		}
			
}
	
