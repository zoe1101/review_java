package ������Ŀ;

public class ����leftMax��rightMax֮��ľ���ֵ {
	//������
	public static int maxABS1(int[] arr) {
		int res=Integer.MIN_VALUE;
		int leftMax=0;
		int rightMax=0;
		for (int i = 0; i < arr.length-1; i++) {
			leftMax=Integer.MIN_VALUE;
			for (int j = 0; j <=i; j++) { //ǰi����Ϊ��߲���
				leftMax=Math.max(arr[j], leftMax);
			}
			rightMax=Integer.MIN_VALUE;
			for (int j =i+1; j <arr.length; j++) { //��N-i����Ϊ�ұ߲���
				rightMax=Math.max(arr[j], rightMax);
			}
			res=Math.max(res, Math.abs(leftMax-rightMax));
		}
		return res;
	}
	//ʵ�ֱ���ͳ�Ʒ�
	public static int maxABS2(int[] arr) {
		int[] leftMaxArr=new int[arr.length];
		int[] rightMaxArr=new int[arr.length];
		leftMaxArr[0]=arr[0];
		rightMaxArr[arr.length-1]=arr[arr.length-1];
		for (int i = 1; i < arr.length; i++) {
			leftMaxArr[i]=Math.max(leftMaxArr[i-1], arr[i]);
		}
		
		for (int i = arr.length-2; i >= 0; i--) {
			rightMaxArr[i]=Math.max(rightMaxArr[i+1], arr[i]);
		}
		
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			max=Math.max(max, Math.abs(leftMaxArr[i]-rightMaxArr[i+1]));
		}
		return max;
	}

}
