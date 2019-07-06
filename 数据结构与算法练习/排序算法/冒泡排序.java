package �����㷨;

import java.util.Arrays;

//N������Ҫ������ɣ��ܹ�����N-1������ÿi�˵��������Ϊ(N-i)�Σ����Կ�����˫��ѭ����䣬
//������ѭ�������ˣ��ڲ����ÿһ�˵�ѭ��������
public class ð������ {
	public static void bubbleSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		for (int i = 0; i < arr.length-1; i++) { //��Ҫ����N-1��
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	//�Ա��������ڼ����㷨�Ƿ���ȷ
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	//�����������
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//(int)((maxSize + 1) * Math.random())�� [0,maxSize]���������һ��ֵ��Ϊ���鳤��
		int[] arr=new int[(int)((maxSize + 1) * Math.random())]; 
		for (int i = 0; i < arr.length; i++) {
			//�����������[-maxValue,maxValue]��ֵ
			arr[i]=(int) ((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
		}
		return arr;
	}
	
	//���鿽��
	public static int[] copyArray(int[] arr) {
		if (arr==null) {
			return null;
		}
		int[] res=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i]=arr[i];
		}
		return res;
	}
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1==null && arr2!=null) || (arr1!=null &&arr2==null)) {
			return false;
		}
		if (arr1==null && arr2==null) {
			return true;
		}
		if (arr1.length!=arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// ��ӡ����Ԫ��
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int testTime = 500000; //���Դ���
		int maxSize = 100; //������󳤶�
		int maxValue = 100; //Ԫ�����ֵ
		boolean succeed = true;  //��־����Ƿ���ȷ
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed?"�㷨��ȷ!":"�㷨�д�!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
	


}
