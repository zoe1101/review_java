package vivo���������ǰ��;

import java.util.HashSet;
import java.util.Set;
//A��B�������飬Ҫ�����A�д��ڶ�B�в����ڵ�Ԫ�ء�
public class Main1 {
	public static void Solution(int[] A,int[] B) {
		if (B==null || B.length==0) {
			for (int i:A) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < B.length; i++) {
			if (!set.contains(B[i])) {
				set.add(B[i]);
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (!set.contains(A[i])) {
				System.out.print(A[i]+" ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A= {1,3,5,6,9,7,5,7,8};
		int[] B= {1,3,5,7};
		Solution(A, B);
	}

}
