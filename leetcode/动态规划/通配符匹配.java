package ��̬�滮;
/*
����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣
'?' ����ƥ���κε����ַ���
'*' ����ƥ�������ַ������������ַ�������
�����ַ�����ȫƥ�����ƥ��ɹ���

˵��:
s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� ? �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����

 */

//��̬�滮
public class ͨ���ƥ�� {
    public boolean isMatch(String s, String p) {
        if ((s==null && p==null) || (s.length()==0 && p.length()==0)) {
			return true;
		}
        char[] str=s.toCharArray();
        char[] exp=p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][exp.length + 1];
        dp[0][0]=true;
     // ��ʼ��ʼ�����,���ƥ��Ĵ�s�ǿյĵĻ���ֻ��ģʽ��*����ƥ��
        for (int i = 0; i < exp.length; i++) {
			if (dp[0][i] && exp[i]=='*') {
				dp[0][i+1]=true;
			}
		}
        
        for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < exp.length; j++) {
				if (exp[j]=='*') {
					dp[i+1][j+1]=dp[i][j+1] || dp[i+1][j];
				}else if (exp[j]=='?' || exp[j]==str[i]) {
					dp[i+1][j+1]=dp[i][j];
				}
			}
		}
        return dp[str.length][exp.length];
    }
}
