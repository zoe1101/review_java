package �����㷨;

import java.util.Arrays;
import java.util.Scanner;

public class ϣ������ {
	public static void main(String[] args) {
		Scanner stdinScanner=new Scanner(System.in);
		int[] arr=new int[] {3,2,5,1,7,2,6,4,0};
		System.out.println(Arrays.toString(arr));
		arr=ShellSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
		
//	  ϣ������
		public static int[] ShellSort(int[] arr) {
			for(int gap=arr.length/2;gap>=1;gap/=2) { //�������еĲ���
				for (int i=gap;i<arr.length;i++) { //��������Ԫ��
					for(int j=i-gap;j>=0;j-=gap) { //�������������е�Ԫ��
						if(arr[j]>arr[j+gap]) {
							int temp=arr[j];
							arr[j]=arr[j+gap];
							arr[j+gap]=temp;
						}
					}

				}
				System.out.print(gap+": ");
				System.out.println(Arrays.toString(arr));
			}
			return arr;
		}
			
}
	
