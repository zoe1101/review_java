package �����㷨;

import java.util.Scanner;

public class һά���鵹�� {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	Scanner stdinScanner=new Scanner(System.in);
			
			int n=stdinScanner.nextInt();
			
			int[] arr=new int[n];
			//���������
			for(int i=0;i<arr.length;i++) { 
				arr[i]=stdinScanner.nextInt();
			}
			
			printArray(arr);
			
			System.out.println("\n");
			arr = reverse(arr);
			
			printArray(arr);
			
	
	}
	
	// ��ӡ��������Ԫ��
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}
	 public static int[] reverse(int[] arr){
	        int[] result = new int[arr.length];
	        for (int i = 0,j=result.length-1; i < arr.length; i++,j--) {
	            result[j] = arr[i];
	        }
	        return result;
	    }

}
