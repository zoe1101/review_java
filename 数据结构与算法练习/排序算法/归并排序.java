package �����㷨;

import java.util.Scanner;

public class �鲢���� {
	public static void mergeSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
		mergeSort(arr,0,arr.length-1);

	}
    private static void mergeSort(int[] arr, int left, int right) {
		if (left<right) {
			int mid=(left+right)>>1;
		mergeSort(arr,left,mid); //��߹鲢����
		mergeSort(arr,mid+1,right); //�ұ߹鲢����
		merge(arr, left, mid, right); //�����Һ������õ���������
		}
	}
    //�ϲ�������������Ϊһ����������
	private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; //��������
        int i = left;
        int j = mid+1;
        int index = 0;
        while(i<=mid && j<=right){ //�������ж���Ϊ�յ������
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while(i<=mid){//�����ʣ��Ԫ������temp��
            temp[index++] = arr[i++];
        }
        while(j<=right){//��������ʣ��Ԫ������temp��
            temp[index++] = arr[j++];
        }
        //��temp�е�Ԫ��ȫ��������ԭ������
        for (int k = 0; k < temp.length; k++) {
            arr[k + left] = temp[k]; //��left��ʼ��left������ź��˵�
        }
    }
	
}
