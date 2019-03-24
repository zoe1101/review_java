package �����㷨;

import java.util.Scanner;

public class �鲢���� {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		Scanner stdinScanner = new Scanner(System.in);
		int n= stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		MergeSort(arr, 0, arr.length-1);
		printArray(arr);

	}
	
	// ��ӡ��������Ԫ��
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println("");
	}
	public static void MergeSort(int[] arr,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			MergeSort(arr,left,mid);//��߹鲢����ʹ��������������
			MergeSort(arr,mid+1,right);//�ұ߹鲢����ʹ��������������
            merge(arr,left,mid,right);//�ϲ�����������
		}
	}
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//ps��Ҳ���Դӿ�ʼ������һ����ԭ�����С��ͬ�����飬��Ϊ�ظ�new�����Ƶ�������ڴ�
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){//�����ʣ��Ԫ������temp��
            temp[k++] = arr[i++];
        }
        while(j<=right){//��������ʣ��Ԫ������temp��
            temp[k++] = arr[j++];
        }
        //��temp�е�Ԫ��ȫ��������ԭ������
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }

}
