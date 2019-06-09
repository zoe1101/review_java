package ��̬�滮;
/**
������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��
����Զ�һ�����ʽ����������ֲ�����
����һ���ַ�
ɾ��һ���ַ�
�滻һ���ַ�

ʾ�� 1:
����: word1 = "horse", word2 = "ros"
���: 3
����: 
horse -> rorse (�� 'h' �滻Ϊ 'r')
rorse -> rose (ɾ�� 'r')
rose -> ros (ɾ�� 'e')
 * @author zoe
 *
 */
public class �༭���� {
    public int minDistance(String word1, String word2) {
    	if ((word1==null && word2==null) || (word1.length()==0 && word2.length()==0)) {
			return 0;
		}
        int m=word1.length();
        int n=word2.length();
        //dp[i][j] ������С�����������裩���� word1[0..i-1]ת��Ϊ word2[0..j-1].
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <=m; i++) {
			dp[i][0]=i;
		}
        for (int j = 1; j <=n; j++) {
			dp[0][j]=j;
		}
        for (int i = 1; i <=m; i++) {
			for (int j = 1; j <=n; j++) {
				if (word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
				}
			}
		}
        return dp[m][n];
    }
}
