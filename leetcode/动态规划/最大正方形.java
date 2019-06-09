package ��̬�滮;
/*
��һ���� 0 �� 1 ��ɵĶ�ά�����ڣ��ҵ�ֻ���� 1 ����������Σ��������������

ʾ��:

����: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

���: 4

 */
public class ��������� {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0 ||matrix[0]==null || matrix.length==0) {
			return 0;
		}
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row+1][col+1];//dp[i][j]:�Ե�i�е�j��Ϊ���½����ܹ��ɵ���������α߳�
        int max=0;
        for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i-1][j-1]=='1') {
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
					max = Math.max(max, dp[i][j]); 
				}
			}
		}
        return max*max;
    }
}
