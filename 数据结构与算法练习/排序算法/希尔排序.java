package �����㷨;

import java.util.Arrays;
import java.util.Scanner;

public class ϣ������ {
//	  ϣ������
	public static int[] shellSort(int[] arr) {
		for(int gap=arr.length/2;gap>=1;gap/=2) { //�������еĲ���
			//����ֱ�Ӳ�������
			for (int i=gap;i<arr.length;i++) { //����������
				for(int j=i-gap;j>=0;j-=gap) { //����ÿ�������е�Ԫ��
					if(arr[j]>arr[j+gap]) {
						swap(arr,j,j+gap);
					}
				}

			}
			System.out.print(gap+": ");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}

	public static void main(String[] args) {
		Scanner stdinScanner=new Scanner(System.in);
		int[] arr=new int[] {3,2,5,1,7,2,6,4,0};
		System.out.println(Arrays.toString(arr));
		arr=shellSort(arr);
		System.out.println(Arrays.toString(arr));

	}
			
}
	
