package 其他题目;

import java.util.Arrays;
import java.util.HashSet;

import javax.swing.border.EtchedBorder;

public class 正数数组的最小不可组成和 {
	//暴力法
	public static int unformedSum1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 1;
		}
		HashSet<Integer> set=new HashSet<Integer>(); //存储子集和
		process(arr, 0, 0, set);
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min=Math.min(min, arr[i]);
		}
		for (int i = min+1; i !=Integer.MIN_VALUE; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 0;
	}

	public static void process(int[] arr,int i, int sum,HashSet<Integer> set) {
		if (i==arr.length) {
			set.add(sum);
			return;
		}
		process(arr, i+1, sum, set); //包含当前arr[i]
		process(arr, i+1, sum+arr[i], set); //不包含当前arr[i]
	}
	//动态规划实现
	public static int unformedSum2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 1;
		}
		int sum=0; //max
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			min=Math.min(min, arr[i]);
		}
		boolean[] dp=new boolean[sum+1]; //dp[j]:j可以为arr的子集和
		dp[0]=true; 
		for (int i = 0; i < arr.length; i++) {
			for (int j = sum; j>=arr[i]; j--) {
				dp[j]=dp[j-arr[i]]?true:dp[j];
			}
		}
		for (int i = min; i < dp.length; i++) {
			if (!dp[i]) {
				return i;
			}
		}
		return sum+1; //max+1
	}
	
	//假设已知arr中包含元素1
	public static int unformedSum3(int[] arr) {
		if (arr==null || arr.length==0) {
			return 1;
		}
		Arrays.sort(arr);
		int range=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>range+1) {
				return range+1;
			}else {
				range+=arr[i];
			}
		}
		return range+1; //max+1
	}

	public static void main(String[] args) {
		int[] arr= {1,4,3,2,5,7,3,8};
		System.out.println(unformedSum1(arr));
		System.out.println(unformedSum2(arr));
		System.out.println(unformedSum3(arr));
	}
}
