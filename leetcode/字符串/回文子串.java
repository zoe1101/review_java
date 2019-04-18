package �ַ���;

import javax.naming.InitialContext;

/*
����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ��Ϊ�ǲ�ͬ���Ӵ���

����: "aaa"
���: 6
˵��: 6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa".
 */
public class �����Ӵ� {
    public static int countSubstrings(String s) {
    	int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;//ͳ�ƻ����Ӵ���
        for(int i=0;i<n;i++) {  // �����ַ���Ϊ����
        	dp[i][i]=true;
        }
        // two character
        // б�ű��� [0,1] -> [1,2] -> ...
        for(int i=0;i<n-1;i++) { // �����ַ�����ͬ���ǻ���
        	if(s.charAt(i)==s.charAt(i+1)) {
        	dp[i][i+1]=true;
        	}
        }
        // others
        // ��ʼdp,  ���Ӵ� = �ַ� + ���½ǵ��Ӵ� + �ַ�
        // ֻ�����½��ǻ���,ͬʱ������ӵ��ַ���ͬʱ,���ǻ���
        for(int i=2;i<n;i++) {
        	for(int j=0;j<n-i;j++) {
        		if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]==true) {
        			dp[j][j+i]=true;
        		}
        	}
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(dp[i][j]==true) {
        			count++;
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		String string="abbada";
		System.out.println(countSubstrings(string));

	}

}
