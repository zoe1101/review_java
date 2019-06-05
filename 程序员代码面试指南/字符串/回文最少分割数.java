package �ַ���;

public class �������ٷָ��� {
	public static int minCut(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int len=chas.length;
		int[] dp=new int[len+1]; //dp[i]:str[i..len-1]�������ٷָ���
		dp[len]=-1;
		boolean[][] p=new boolean[len][len]; //p[i][j]��str[i..j]�Ƿ����
		for (int i = len-1; i >=0; i--) { //�����������
			dp[i]=Integer.MAX_VALUE;
			for (int j = i; j < len; j++) { //����str[i..j]�Ƿ����
				//j-i<2:str[i]��str[j]����
				//p[i+1][j-1]��str[i+1..j-1]�ǻ���
				if (chas[i]==chas[j] && (j-i<2 || p[i+1][j-1])) {
					p[i][j]=true;
					dp[i]=Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}

}
