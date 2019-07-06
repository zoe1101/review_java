package ����;

import java.util.HashMap;

/*
 */
public class �͵���k��������鳤�� {
	//����1������һ�����飬ֵȫ���������뷵���ۼӺ�Ϊ����ֵk��������鳤�ȡ�
	public static int getMaxLength1(int[] arr, int k) {
		if (arr==null || arr.length==0 || k<=0) {
			return 0;
		}
		int left=0;
		int right=0;
		int sum=arr[0];
		int maxlen=0;
		while (right<arr.length) {
			if (sum==k) {
				maxlen=Math.max(maxlen, right-left+1);
				sum-=arr[left++];
			}else if (sum<k) {
				sum+=arr[right++];
				if (right==arr.length) {
					break;
				}
			}else {
				sum-=arr[left++];
			}
			
		}
		return maxlen;
	}
	//����2������һ�����飬ֵ����Ϊ��������0���뷵���ۼӺ�Ϊ����ֵk��������鳤�ȡ�
	public static int getMaxLength2(int[] arr, int k) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>(); //�ۼӺ�K��С���ֵ��±�λ��
		map.put(0, -1);
		int maxlen=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			//iλ�õĺ�Ϊsum���ҵ���Ϊsum-k��λ�ã�����λ����������ܵõ���Ϊk�ĳ���
			if (map.containsKey(sum-k)) {
				maxlen=Math.max(maxlen, i-map.get(sum-k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxlen;
	}
}
