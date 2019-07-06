package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
����һ������ļ��ϣ���ϲ������ص������䡣

ʾ�� 1:

����: [[1,3],[2,6],[8,10],[15,18]]
���: [[1,6],[8,10],[15,18]]
����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].

 */
public class �ϲ����� {
	/*
	 �Ȱ������鿪ʼλ�ô�С��������Ȼ������ж��������ڵĽڵ������Ƿ��н�����
	 ���н�����ȡ�������Сֵ��Ϊ�µĽڵ�
	 */
    public int[][] merge(int[][] intervals) {
    	if(intervals==null || intervals.length<= 1) {
    		return intervals;
    	}
    	Arrays.sort(intervals,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		} );
    	
    	List<int[]> list=new ArrayList<int[]>();
    	int i=0;
    	while (i<intervals.length) {
			int left=intervals[i][0];
			int right=intervals[i][1];
			//��ǰ����Ľ���λ�ú���һ��������ص���
			while(i<intervals.length-1 && right>=intervals[i+1][0]){ 
				right = Math.max(right,intervals[i+1][1]); //���½���λ��
                i++;
            }
			list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
