package ���ֲ���;
/*
���ǰѷ����������Ե����� A ����ɽ����
A.length >= 3
���� 0 < i < A.length - 1 ʹ��A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
����һ��ȷ��Ϊɽ�������飬�����κ����� A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] �� i ��ֵ��

���룺[0,2,1,0]
�����1
 */
public class ɽ������ķ嶥���� {
    public static int peakIndexInMountainArray(int[] A) {
    	  int left=0,right=A.length-1; 
          while(left+1<right) {
          	int mid=(left+right)/2;
          	if(A[mid]<A[mid+1]) { //A[mid+1]>A[mid],��ô�嶥��Ȼ��mid+1��A.length��(�Ҳ�)
          		left=mid+1;
          	}else {
          		right=mid;
          	}
          }
          return (left==A.length-1|| A[left]>A[left+1])?left:right;
    }
	public static void main(String[] args) {
	    int[] arr = {0,2,1,0};
	    System.out.println(peakIndexInMountainArray(arr));

	}

}
