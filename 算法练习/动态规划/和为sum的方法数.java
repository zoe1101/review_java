package ��̬�滮;

import java.util.Scanner;

import org.omg.PortableInterceptor.Interceptor;

/*
����������8�ֲ�ͬ��ֵ��Ӳ�ң�1��2��5��10��20��50��100��200��������ЩӲ����Ϲ���һ����������ֵn��
����n=200������n=200����ôһ�ֿ��ܵ���Ϸ�ʽΪ 200 =2*100.
���ܹ��ж����ֿ��ܵ���Ϸ�ʽ����֤nС�ڵ���100000��
*/

public class ��Ϊsum�ķ����� {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int[] coins = { 1, 5, 10, 20, 50, 100, 200 };
		while(inScanner.hasNext()) {
			int n=inScanner.nextInt();
			System.out.println(coin_counts1(coins,n));
			System.out.println(coin_counts2(coins,n));
		}

	}
	
//	��Ϊһά����
	public static int coin_counts1(int[] coins,int n) { 
		System.out.print("��̬�滮��һά���:");
		int[] dp = new int[100001];
		dp[0] = 1;
		for (int i = 0; i < 7; ++i) {
			for (int j = coins[i]; j <= n; ++j) {
				dp[j] = dp[j] + dp[j - coins[i]];  //�����i��Ӳ�ҺͲ������i��Ӳ�ҵķ����ܺ�
			}
		}
		return dp[n];
	}

// ��̬�滮ԭʼ���
    public static int coin_counts2(int[] coins,int n){
    	 System.out.print("��̬�滮ԭʼ��ά���:");
	     int[][] dp= new int[coins.length+1][n+1];//length+1��ʾ�������κα��֡�ֻʹ��1��ֻʹ��1 2 ֻʹ��1 2 3......�ȵȣ���length+1���������n+1��ʾ�ܼ�0��1.....��nԪ��n+1����� 
	     for(int i = 0;i<=coins.length;i++) {
	    	 dp[i][0] = 1;
	     }
	     for(int i = 1 ;i<=coins.length;i++){//��Ϊd[0][sum]��0������i��1��ʼ
	         for(int sum = 1;sum<=n;sum++){//����d[i][0]==1������sum��1��ʼ
	             for(int k=0;k<=sum/coins[i-1];k++){//���磬ʹ����ֵΪ1ʱ����Ӧ��coins[]�±���i-1���߼��Ϻ�ʵ���ϲ���һ�µ�
	            	 dp[i][sum] +=dp[i-1][sum-k*coins[i-1]]; //�����i��Ӳ�ҺͲ������i��Ӳ�ҵķ����ܺ�
	             }                
	         }
	     }
	     return dp[coins.length][n];
      }

}
