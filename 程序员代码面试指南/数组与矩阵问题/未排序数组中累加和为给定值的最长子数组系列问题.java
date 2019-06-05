package �������������;

import java.util.HashMap;

public class δ�����������ۼӺ�Ϊ����ֵ���������ϵ������ {
	//1�������а���������������0��Ҫ���ۼӺ�Ϊk
	//����sum-(sum-k)=kʵ��
	public static int maxLength1(int[] arr,int k) {
		if (arr==null ||arr.length==0) {
			return 0;
		}
		//��¼keyΪsum��һ�γ��ֵ�λ��j
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(0, -1); //��Ϊ0��һ�γ�����-1��λ��
		int len=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if (map.containsKey(sum-k)) {//����sum-(sum-k)=kʵ��
				len=Math.max(len, i-map.get(sum-k));
			}
			if (!map.containsKey(sum)) { //���map��key�в�����sumԪ��
				map.put(sum, i);
			}
		}
		return len;
	}
	
	//2�������а���������������0��Ҫ���������������͸����ĸ������
	public static int maxlength2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		//������1�滻��������-1�滻��Ȼ�����Ϊ0��������鳤��
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>0) {
				arr[i]=1;
			}
			if (arr[i]<0) {
				arr[i]=-1;
			}
		}
		return maxLength1(arr, 0);
	}
	//��ֻ��0��1�������У��ҵ�0��1������ȵ�������鳤��
	public static int maxlength3(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		//0��-1�滻��Ȼ�����Ϊ0��������鳤��
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==0) {
				arr[i]=-1;
			}
		}
		return maxLength1(arr, 0);
		
	}
	public static int[] generateArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 11) - 5;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = generateArray(20);
		printArray(arr);
		System.out.println(maxLength1(arr, 10));
		System.out.println(maxlength2(arr));
		System.out.println(maxlength3(arr));

	}

}
