package vivo���������ǰ��;

import java.util.Arrays;

//��n����Ʒ��ÿ����Ʒ��Ӧһ���ȶ�ֵ���ܽ��Ϊk��
//ÿ����Ʒֻ����һ�Σ���ι������ʹ��������Ʒ�����ȶ�ֵ��ߡ�

//01��������
public class Main3 {
	public static int Solution(int k,int[] cost,int[] hot) {
		if (k<0 || cost.length!=hot.length) {
			return 0;
		}
		int len=cost.length;
		int[][] dp=new int[len+1][k+1]; 
		//dp[i][j]:�ڻ������Ϊj������£�ǰi����Ʒ�����ϵ����ȶ�ֵ
		for (int i = 1; i <=len; i++) {
			for (int j = 1; j <=k; j++) {
				if (j<cost[i-1]) { //��������Ʒi
					dp[i][j]=dp[i-1][j];
				}else {//�����ò��õ�i����Ʒ��dp[i-1][j]Ϊ����
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cost[i-1]]+hot[i-1]);
				}
			}
		}
		System.out.println("��̬�滮��");
		for (int[] e:dp) {
			System.out.println(Arrays.toString(e));
		}
		System.out.print("���ȶ�ֵ���ֵ��");
		return dp[len][k];
		
	}
	public static void main(String[] args) {
		int[] cost = { 2 , 3 , 4 , 5 };			
		int[] hot= {3 , 4 , 5 , 6 };	
		int k = 8;
		System.out.println(Solution(k, cost, hot));
	}

}
