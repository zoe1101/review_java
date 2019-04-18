package ��̬�滮;
/*
����������һ��������Ϸ����Ϸ�������£�
�Ҵ� 1 �� n ֮��ѡ��һ�����֣���������ѡ���ĸ����֡�
ÿ����´��ˣ��Ҷ�������㣬��ѡ�����ֱ���Ĵ��˻���С�ˡ�
Ȼ��������������� x ���Ҳ´��˵�ʱ������Ҫ֧�����Ϊ x ���ֽ�ֱ����µ���ѡ�����֣������Ӯ���������Ϸ��
���� n �� 1��������������Ҫӵ�ж����ֽ����ȷ������Ӯ�������Ϸ��

n = 10, ��ѡ����8.
��һ��: �����ѡ���������5���һ�����㣬�ҵ����ָ���һЩ��Ȼ������Ҫ֧��5�顣
�ڶ���: �����7���Ҹ����㣬�ҵ����ָ���һЩ����֧��7�顣
������: �����9���Ҹ����㣬�ҵ����ָ�СһЩ����֧��9�顣
��Ϸ������8 ������ѡ�����֡�
������Ҫ֧�� 5 + 7 + 9 = 21 ��Ǯ��
 */
public class �����ִ�СII {
    public static int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1]; 
        //dp[i][j]��ʾ������i��j֮���������һ������������Ҫ���ѵ�Ǯ��
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>=0;j--){
                if(j==i-1){
                    dp[j][i] = j;
                    continue;
                }
                int globalMin = Integer.MAX_VALUE;
                for(int k=j+1;k<i;k++){
                    int localMax= k+ Math.max(dp[j][k - 1], dp[k + 1][i]);
                    globalMin=Math.min(localMax,globalMin);
                }
                dp[j][i]=globalMin;

            }
        }
        return dp[1][n];
    }
    
	public static void main(String[] args) {
	    int n=10;
	    System.out.println(getMoneyAmount(n));
	}
}
