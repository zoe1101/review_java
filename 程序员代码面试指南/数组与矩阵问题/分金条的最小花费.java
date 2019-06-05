package �������������;

import java.util.PriorityQueue;

//�������������⣬���Ȩ·����С
public class �ֽ�������С���� {
	public static int getMinSplitCost(int[] arr) {
		if (arr==null || arr.length<2) {
			return 0;
		}
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) { //����Ԫ�����
			minHeap.add(arr[i]);
		}
		int res=0;
		while (minHeap.size()!=1) {
			int sum=minHeap.poll()+minHeap.poll(); //����������С��Ԫ��
			res+=sum;
			minHeap.add(sum);
		}
		return res;
	}
}
