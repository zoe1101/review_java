package �ݹ��붯̬�滮;

import ��.MaxHeap;

public class �ų�һ���ߵ�ֽ�Ʋ������� {
	//�����ݹ�
	public static int win1(int[] arr) {
		if (arr==null || arr.length==0) {
		return 0;
		}
		return Math.max(f(arr, 0,arr.length-1),s(arr,0,arr.length-1));
	}
	//���arr[i..j]�����������������ã����������ܻ�õķ���f(i,j)
	public static int f(int[] arr,int i,int j) {
		if (i==j) { //ֻ��һ����arr[i]
			return arr[i];
		}
		//����������arr[i]��arr[j]
		return Math.max(arr[i]+s(arr, i+1, j), arr[j]+s(arr, i, j-1));
	}
	//���arr[i..j]�������������˺��ã����������ܻ�õķ�����s(i,j)
	public static int s(int[] arr,int i,int j) {
		if (i==j) {
			return 0;
		}
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}
	public static int win2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
			}
		int len=arr.length;
		int[][] f=new int[len][len];
		int[][] s=new int[len][len];
		for (int j = 0; j < len; j++) {
			f[j][j]=arr[j];
			for (int i = j-1; i >=0; i--) {
				f[i][j]=Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j]=Math.min(f[i-1][j],f[i][j-1]);
			}
		}
		return Math.max(f[0][len-1], s[0][len-1]);
	}
	

}
