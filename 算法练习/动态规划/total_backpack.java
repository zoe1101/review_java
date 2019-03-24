package ��̬�滮;

import java.util.Scanner;

//��ȫ����
/*
��N����Ʒ��һ������ΪV�ı�����ÿ����Ʒ�������޼����á�
��i����Ʒ��������w[i]����ֵ��v[i]��
��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�������ܺͲ����������������Ҽ�ֵ�ܺ����
*/
public class total_backpack {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n=inScanner.nextInt();
		int[] w=new int[n];
		int[] v=new int[n];
		for (int i=0;i<n;i++) {
			w[i] = inScanner.nextInt();
		}
		for (int i=0;i<n;i++) {
			v[i] = inScanner.nextInt();
		}
		int C=inScanner.nextInt();
		findMAX1(w, v, C);
		findMAX2(w, v, C);
		
	}
	public static int[] findMAX1(int[] w,int[] v,int C) {
		int[] dp=new int[C+1];
		
		for(int i=1;i<=w.length;i++) {
			for(int j=1;j<=C;j++) {
				int m = j / w[i-1];	//����ܷ��£�Ҫ�����ܷż���
				for(int k=0;k<=m;k++ ) {
					//Ȼ��ż������������������һ�¿��ĸ���ֵ���
					if(dp[j-k*w[i-1]]+k*v[i-1]>dp[j]) {
						dp[j]=dp[j-k*w[i-1]]+k*v[i-1];
					}
				}
			}
		}
		System.out.println("���dp����");
		for(int j=0;j<dp.length;j++) {
				System.out.print(dp[j]+" ");}
		System.out.println();
		System.out.println("����ֵΪ��"+dp[dp.length-1]);
		return dp;
	}
	public static int[][] findMAX2(int[] w,int[] v,int C) {
		int[][] dp=new int[w.length+1][C+1];
		
		for(int i=1;i<=w.length;i++) {
			for(int j=1;j<=C;j++) {
				int m = j / w[i-1];	//����ܷ��£�Ҫ�����ܷż���
				for(int k=0;k<=m;k++ ) {
					//Ȼ��ż������������������һ�¿��ĸ���ֵ���
					if(dp[i-1][j-k*w[i-1]]+k*v[i-1]>dp[i][j]) {
						dp[i][j]=dp[i-1][j-k*w[i-1]]+k*v[i-1];
					}
				}
			}
		}
		System.out.println("���dp����");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("����ֵΪ��"+dp[dp.length-1][dp[0].length-1]);
		return dp;
	}

}
