package �����㷨;

import java.util.Scanner;
//ѡ�����򣺣���ð��������죬���д������٣�

public class ѡ������ {

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
	

	// ��ӡ��������Ԫ��
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
		
//	    ��С����
		public static int[] SmalltoBig(int[] arr) {
			for(int i=0;i<arr.length-1;i++) {  //iΪ���������е�ĩβ
				for (int j=i+1;j<arr.length;j++) { //jΪδ��������
					if(arr[j]<arr[i]) {  //�ҳ�δ���������е���Сֵ
						
						//Ԫ�ؽ���λ�ã��ŵ����������е�ĩβ���ò������п��ܰ��ȶ��Դ��ң�����ѡ�������ǲ��ȶ��������㷨
						int temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
			}
			return arr;
			
		}
		
//	    �Ӵ�С
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
