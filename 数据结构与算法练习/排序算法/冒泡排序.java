package �����㷨;

import java.util.Scanner;

//N������Ҫ������ɣ��ܹ�����N-1������ÿi�˵��������Ϊ(N-i)�Σ����Կ�����˫��ѭ����䣬������ѭ�������ˣ��ڲ����ÿһ�˵�ѭ��������
public class ð������ {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner stdinScanner=new Scanner(System.in);
		int n=stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		for(int i=0;i<arr.length-1;i++) { //���ѭ��������������
			for(int j=0;j<arr.length-i-1;j++) {  //�ڲ�ѭ������ÿһ��������ٴ�
				// ��С��ֵ������ǰ��
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			 System.out.print("��"+(i+1)+"����������");//�о�ÿ�����������
			 printArray(arr);
		}
		System.out.println("������������");
		printArray(arr);

	}
	

	// ��ӡ��������Ԫ��
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
}
