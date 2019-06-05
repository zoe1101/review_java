package �������������;

import java.util.Arrays;
import java.util.HashSet;

//����������:һ���������������Ԫ�صĲ�ľ���ֵΪ1,�����������Ӧ�������ε���1��
//����1
public class ��Ŀ�����������ĳ��� {
	public static int getLIL1(int[] arr) {
		if (arr==null ||arr.length==0) {
			return 0;
		}
		int len=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (isIntegrated(arr, i, j)) {
					len=Math.max(len, j-i+1);
				}
			}
		}
		return len;
		
	}
	//�ж�arr[i:j]�Ƿ��ǿ���������
	public static boolean isIntegrated(int[] arr,int left,int right) {
		int[] newArr=Arrays.copyOfRange(arr, left, right+1);//��ԭ�����и���һ��
		Arrays.sort(newArr); //����
		for (int i = 1; i < newArr.length; i++) {
			if (newArr[i]-newArr[i-1]!=1) {
				return false;
			}
		}
		return true;
	}
	
	//����2��
	public static int getLIL2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int len=0; //����������ĳ���
		int max=0; //������������
		int min=0; //��������С����
		HashSet<Integer> set=new HashSet<Integer>(); //�ж��Ƿ����ظ�Ԫ��
		for (int i = 0; i < arr.length; i++) {
			max=Integer.MIN_VALUE;
			max=Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) { //��arr[i:j]�����ж�
				if (set.contains(arr[j])) { //�����ظ�Ԫ�أ�����ѭ��
					break;
				}
				set.add(arr[j]);
				max=Math.max(max, arr[j]);
				min=Math.min(min, arr[j]);
				if (max-min==j-i) { //���arr[i:j]��Ŀǰ���������飬������󳤶��жϸ���
					//ֻҪ���ֵ��ȥ��Сֵ��1������������ĳ��Ⱦ�����Ҫ��
					len=Math.max(len, j-i+1);
				}
			}
			set.clear();
		}
		return len;
	}
	

}
