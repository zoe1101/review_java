package �ݹ��붯̬�滮;

import java.util.HashMap;

public class ��������������� {
	public static int longestConsecutive(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int max=1;
		//arr[i]���ڵ���������еĳ���
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) { //arr[i]û�г��ֹ�
				map.put(arr[i], 1);
				if (map.containsKey(arr[i]-1)) { //arr[i]-1���ֹ�����Ҫ���кϲ�
					max=Math.max(max, merge(map, arr[i]-1,arr[i]));
				}
				if (map.containsKey(arr[i]+1)) { //arr[i]+1���ֹ�����Ҫ���кϲ�
					max=Math.max(max, merge(map,arr[i], arr[i]+1));
				}
			}
		}
		return max;
	}
	public static int merge(HashMap<Integer, Integer> map,int less,int more) {
		int left=less-map.get(less)+1; //�ϲ�ʱ����С�����е���Сֵ
		int right=more+map.get(more)-1; //�ϲ�ʱ���ϴ������е����ֵ
		int len=right-left+1; //�ϲ�������г���
		map.put(left, len);
		map.put(right,len);
		return len;
	}

}
