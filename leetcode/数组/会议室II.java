package ����;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
��һ������ʱ�䰲�ŵ����飬ÿ������ʱ�䶼�������ʼ�ͽ�����ʱ�� [[s1,e1],[s2,e2],...] (si < ei)��
�������������Ҫ���ٸ������ҡ�

����: 
[[0,30],[5,10],[15,20]]
���: 2
 */
public class ������II {
	/*
	 ʹ�����ȶ����㷨, �������ȶ���, �����ѿ��ķ���, �Ƚ�ʱ��ΰ��տ�ʼʱ������, ����ʱ���, 
	 ���û�ж���ķ���, ���������ļӵ�������, 
	 ����ж���ķ�����Ŀǰ�������ʼ֮�����ϸ��������ֹʱ��֮��, ���¶���.
	 */
	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0) return 0; 
		Arrays.sort(intervals,new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		});
		
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		for (int i = 0; i < intervals.length; i++) {
			//��ǰ���鿪ʼʱ����֮ǰ����Ľ���ʱ�䲻���ڳ�ͻ
			if (i>0 && !queue.isEmpty() && intervals[i][0]>=queue.peek()) { 
				queue.poll();
			}
			queue.add(intervals[i][1]);
		}
		return queue.size();
	}
}
