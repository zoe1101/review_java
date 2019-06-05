package �������������;

import java.util.Arrays;

public class ������δ���ֵ���С������ {
	public static int missNum1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 1;
		}
		Arrays.sort(arr);
		if(arr[arr.length-1]<1) {
			return 1;
		}
		int res=1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==res) {
				res++;
			}
		}
		return res;
	}
	public static int missNum2(int[] arr) {
		int l=0; //��ʾ[1,l]��Χ�����Ѿ����ֹ��ˣ���ʼ��Ϊ0����ʾ��û������������
		int r=arr.length; //��ʾ����������������£����ܰ���[1,r]��Χ����
		//��ʼ��Ϊarr.length����ʾ��û�п�ʼ���������������[1,N]�е���������
		
		while (l<r) {
			if (arr[l]==l+1) { 
				l++;
			}else if (arr[l]<=l || arr[l]>r || arr[arr[l]-1]==arr[l]) {
				arr[l]=arr[--r];
			}else {
				swap(arr, l, arr[l]-1);
			}
		}
		return l+1;
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = { -1, 0, 2, 1, 3, 5 };
		System.out.println(missNum1(arr));
		System.out.println(missNum2(arr));

	}
}
