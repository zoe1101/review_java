package �����㷨;

import java.util.Scanner;

public class ֱ�Ӳ������� {

	public static void main(String[] args) {
		int[] arr=new int[] {1,3,3,8,4,5,2,7};
		arr=Insertsort(arr);
		printArray(arr);
	}
	

	// ��ӡ��������Ԫ��
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
		
//	  ֱ�Ӳ�������
		public static int[] Insertsort(int[] arr) {
			
			for(int i=1;i<arr.length;i++) { //��������Ԫ��
				for (int j=i;j>0;j--) { //Ϊarr[i]��ǰ���arr[0...i-1]������������һ�����ʵ�λ��
					if(arr[j]<arr[j-1]) { //���arr[j]С��ǰһ���������в������,��arr[j]��arr[j-1]����
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

