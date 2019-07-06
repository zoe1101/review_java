package ����;

import java.util.Arrays;
import java.util.Comparator;

/*
��һ������ʱ�䰲�ŵ����飬ÿ������ʱ�䶼�������ʼ�ͽ�����ʱ�� [[s1,e1],[s2,e2],...] (si < ei)��
�����ж�һ�����Ƿ��ܹ��μ��������ȫ�����顣

����: 
[[0,30],[5,10],[15,20]]

���: false
 */
public class ������ {
	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals,new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		});
		for (int i = 1; i < intervals.length; i++) {
			//��ǰ���鿪ʼʱ������һ������Ľ���ʱ����ڳ�ͻ
			if (intervals[i][0]>intervals[i-1][1]) { 
				return false;
			}
		}
		return true;
	}

}
