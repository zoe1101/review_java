package �����㷨;

import java.util.ArrayList;
import java.util.Arrays;

public class �������� {
	public static int[] radixSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return arr;
		// 1.������������λ����
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int maxDigit = 0; //���ֵ��λ��
		while (max != 0) {
			max /= 10;
			maxDigit++;
		}
		
		//10��Ͱ,��i��Ͱ��ŵ�ǰλΪi����
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();                   
		for (int i = 0; i < 10; i++) {//i��λ������ÿ��λ���Ϲ���һ������
			bucketList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < maxDigit; i++) {
			for (int j = 0; j < arr.length; j++) {
				int num = arr[j] % (int)(Math.pow(10, i + 1)) / (int)(Math.pow(10, i)); //��ǰλ������
				bucketList.get(num).add(arr[j]); //�����ӦͰ
			}
			//�γ��µ�arr����
			int index = 0;
			for (int j = 0; j < bucketList.size(); j++) { //Ͱ����
				for (int k = 0; k < bucketList.get(j).size(); k++) { //Ͱ�ڱ���
					arr[index++] = bucketList.get(j).get(k);
				}
				bucketList.get(j).clear();  //������������飬���ں�������洢
			}
		}
		return arr;
	}
	
	public static void main(String[] args)
	{
		int[] arrays = new int[] { 5, 3, 6, 2, 1, 19, 4, 8, 7 };
		System.out.println("δ��������飺" + Arrays.toString(arrays));
		radixSort(arrays);
		System.out.println("���������飺" + Arrays.toString(arrays));

	}

}
