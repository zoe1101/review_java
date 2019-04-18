package �ַ���;

import javax.naming.InitialContext;

import test.class_A;

/*
����һ���ַ���s���ҵ�������Ļ��������С����Լ���s����󳤶�Ϊ1000��

����:
"bbbab"
���:
4
 */
//�����п��Բ�����
//�������ַ��������ͷ��β��ͬ����ô���������������һ����ȥͷȥβ֮��Ĳ��ֵ�����������м���ͷ��β��
//���ͷ��β��ͬ����ô�����������������ȥͷ�Ĳ��ֵ�����������к�ȥβ�Ĳ��ֵ�����������еĽϳ�����һ����
public class ����������� {
	//��̬�滮��
    public static int longestPalindromeSubseq(String s) {
    	int n=s.length();
    	if(n<=1) {
    		return s.length();
    	}
    	
    	int[][] dp=new int[n][n];

    	for(int j=0;j<n;j++) {
    		dp[j][j]=1;//���Խ�����1
    		for(int i=j-1;i>=0;i--) {
    			if(s.charAt(i)==s.charAt(j)) {
    				dp[i][j]=dp[i+1][j-1]+2;
    			}else {
    				dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
    			}
    		}
    	}
    	return dp[0][n-1];
    }

    public static int longestPalindromeSubseq2(String s) {
    	int n=s.length();
    	if(n<=1) {
    		return s.length();
    	}
    	
    	int[][] dp=new int[n][n];

    	for(int i=n-1;i>=0;i--) {
    		dp[i][i]=1; 
    		for(int j=i+1;j<n;j++) {
    			if(s.charAt(i)==s.charAt(j)) {
    				dp[i][j]=dp[i+1][j-1]+2;
    			}else {
    				dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
    			}
    		}
    	}
    	return dp[0][n-1];
    }

	public static void main(String[] args) {
		String string="abbada";
		System.out.println(longestPalindromeSubseq2(string));

	}

}
