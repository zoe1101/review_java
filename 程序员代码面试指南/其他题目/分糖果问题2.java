package ������Ŀ;
/*
 *һȺ��������Ϸ���������������Ϸ�÷������ǹ���Ҫ�����£� 
����1��ÿ�����Ӳ��ܵ÷ֶ��٣�����ֵ�1���ǹ� 
����2�������������ڵĺ���֮�䣬�÷ֽ϶�ĺ��ӱ������һЩ�ǹ�
	    3�������������ڵĺ���֮������÷���ͬ���ǹ���������ͬ

����һ������arr����÷����飬����������Ҫ�����ǹ��� 
���磺arr = [1,2,2]���ǹ�����[1,2,2]����������Ҫ�����������٣����Է���5.
 */
public class ���ǹ�����2 {
	public static int candy(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int index=nextMinIndex(arr,0); 
		int[] data=rightCandsAndBase(arr, 0, index++);
		int res=data[0];
		
		int lbase=1; //���µ���ʼֵ
		int same=1;
		int next=0;
		while (index!=arr.length) {
			if (arr[index]>arr[index-1]) {
				res+=++lbase;
				same=1;
				index++;
			}else if (arr[index]<arr[index-1]) {
				next=nextMinIndex(arr, index-1);
				data=rightCandsAndBase(arr, index-1, next++);
				if (data[1]<=lbase) {
					res+=data[0]-data[1];
				}else {
					res+=-lbase*same+data[0]-data[1]+data[1]*same;
				}
				lbase=1;
				index=next;
				same=1;
			}else {
				res+=lbase;
				same=1;
				index++;
			}
		}
		return res;
	}

	private static int nextMinIndex(int[] arr, int start) {
		for (int i = start; i < arr.length-1; i++) {
			if (arr[i]<arr[i+1]) { 
				return i;
			}
		}
		return arr.length-1;
	}
	
	private static int[] rightCandsAndBase(int[] arr, int left, int right) {
		int base=1;
		int cands=1;
		for (int i = right-1; i >=left; i--) {
			if (arr[i]==arr[i+1]) {
				cands+=base;
			}else {
				cands+=++base;
			}
		}
		return new int[] {cands,base};
	}
}
