package �����㷨;

public class ���ֲ��� {
//	�����Ķ��ֲ��ң��ǵݹ�
	public static int bisearch1(int[] arr,int target) {
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
			if(target==arr[mid]) {
				return mid;
			}else if(target<arr[mid]) { //��mid�����
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return -1;
	}
//	�����Ķ��ֲ��ң��ݹ�
	public static int bisearch2(int[] arr,int left,int right,int target) {

		while(left<=right) {
			int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
			if(target==arr[mid]) {
				return mid;
			}else if(target<arr[mid]) { //��mid�����
				return bisearch2(arr, left, mid-1, target);
			}else {
				return bisearch2(arr, mid+1, right, target);
			}
		}
		return -1;
	}
	
/*
����Ŀ��ֵ�������߽�/     ������Ŀ��ֵ��ȵĵ�һ��λ��/    ���ҵ�һ����С��Ŀ��ֵ����λ��
 */
	public static int binarySearchLowerBound(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
			if(target<=arr[mid]) { //��mid�����
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(left<arr.length && arr[left]==target) {
			return left;
		}
		return -1;
	}

	
/*
����Ŀ��ֵ������ұ߽�/        ������Ŀ��ֵ��ȵ����һ��λ��/           �������һ��������Ŀ��ֵ����λ��
 */
	public static int binarySearchUpperBound(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
			if(target>=arr[mid]) { //��mid���ұ�
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		if(right>0 && arr[right]==target) {
			return right;
		}
		return -1;
	}
	
	/*
	 �������һ��С��Ŀ��ֵ����/���ұ�Ŀ��ֵС������ӽ�Ŀ��ֵ����

	 */
	public static int binarySearchLastLow(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
			if(target<=arr[mid]) { //��mid�����
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(right>=0) {
			return right;
		}
		return -1;
	}

	/*
	 ���ҵ�һ������Ŀ��ֵ����   /   ���ұ�Ŀ��ֵ������ӽ�Ŀ��ֵ����

	 */
	public static int binarySearchLastHigh(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
			if(target<=arr[mid]) { //��mid�����
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(left<=arr.length) {
			return left;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {1,3,3,5,7,7,7,7,8,14,14};
		int target=7;
		System.out.println(bisearch1(arr, target));
		System.out.println(bisearch2(arr, 0, arr.length-1, target));
		
		System.out.println(binarySearchLowerBound(arr, target));
		System.out.println(binarySearchUpperBound(arr, target));
	}

}
