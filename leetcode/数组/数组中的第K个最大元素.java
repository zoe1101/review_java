package ����;

import java.util.PriorityQueue;

/**
��δ������������ҵ��� k ������Ԫ�ء�
��ע�⣬����Ҫ�ҵ������������ĵ� k������Ԫ�أ������ǵ� k����ͬ��Ԫ�ء�

ʾ�� 1:

����: [3,2,1,5,6,4] �� k = 2
���: 5
 * @author zoe
 *
 */

//������
public class �����еĵ�K�����Ԫ�� {
    public int findKthLargest(int[] nums, int k) {
    	 PriorityQueue<Integer> queue = new PriorityQueue<>();
    	 for (int num:nums) {
			queue.add(num);
			if (queue.size()>k) {
				queue.poll();
			}
		}
    	 return queue.peek();
    }
}
