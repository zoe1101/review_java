package �����㷨;

import java.util.Scanner;

public class �������� {

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
	

	// ��ӡ��������Ԫ��
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
		
//	  ֱ�Ӳ�������
		public static int[] Insertsort(int[] arr) {
			for(int i=1;i<arr.length;i++) { 
				for (int j=i;j>0;j--) { //Ϊarr[i]��ǰ���arr[0...i-1]������������һ�����ʵ�λ��
					if(arr[j]<arr[j-1]) { //���arr[j]С��ǰһ���������в������
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

