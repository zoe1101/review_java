package ������Ŀ;

public class ���ǹ����� {
	/*
	 *һȺ��������Ϸ���������������Ϸ�÷������ǹ���Ҫ�����£� 
����1��ÿ�����Ӳ��ܵ÷ֶ��٣�����ֵ�1���ǹ� 
����2�������������ڵĺ���֮�䣬�÷ֽ϶�ĺ��ӱ������һЩ�ǹ�
	 */
	//�õ����������µ�˼�룬�����¶���ֵΪ�¶Ƚϸߵ�ֵ
	public static int candy1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int index=nextMinIndex(arr,0); 
		int res=rightCands(arr,0,index++);
		int lbase=1; //���µ���ʼֵ
		int next=0;
		int rcands=0;
		int rbase=0;
		while (index!=arr.length) {
			if (arr[index]>arr[index-1]) {
				res+=++lbase;
				index++;
			}else if (arr[index]<arr[index-1]) {
				next=nextMinIndex(arr, index-1);
				rcands=rightCands(arr, index-1, next++);
				rbase=next-index+1;
				res+=rcands+(rbase>lbase?-lbase:-rbase);
				lbase=1;
				index=next;
			}else {
				res+=1;
				lbase=1;
				index++;
			}
		}
		return res;
	}

	private static int nextMinIndex(int[] arr, int start) {
		for (int i = start; i < arr.length-1; i++) {
			if (arr[i]<=arr[i+1]) { 
				return i;
			}
		}
		return arr.length-1;
	}
	
	private static int rightCands(int[] arr, int left, int right) {
		int n=right-left+1;
		return n+n*(n-1)/2;
	}
	
}
