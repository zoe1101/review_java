package ��̬�滮;import javax.lang.model.element.Element;

/*
 ����һ���ַ��� (s) ��һ���ַ�ģʽ (p)��ʵ��֧�� '.' �� '*' ��������ʽƥ�䡣

'.' ƥ�����ⵥ���ַ���
'*' ƥ���������ǰ���Ԫ�ء�
ƥ��Ӧ�ø��������ַ��� (s) �������ǲ����ַ�����

˵��:

s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����
 */
public class ������ʽƥ�� {
    public boolean isMatch(String s, String p) {
    	if (s==null || p==null) {
			return false;
		}
        char[] str=s.toCharArray();
        char[] exp=p.toCharArray();
        if (!isValid(str, exp)) {
			return false;
		}
        int slen=str.length;
        int plen=str.length;
        boolean[][] dp=new boolean[slen+1][plen+1];
        dp[slen][plen]=true;
        
        for (int j = plen-2; j>=0; j=j-2) {
			if (exp[j]!='*' && exp[j+1]=='*') {
				dp[slen][j]=true;
			}else {
				break;
			}
		}
        if (slen>0 && plen>0) {
			if (exp[plen-1]=='.' || str[slen-1]==exp[plen-1]) {
				dp[slen-1][plen-1]=true;
			}
		}
        
        for (int i = slen-1; i>=0; i--) {
			for (int j = plen-2; j >=0; j--) {
				if (exp[j+1]!='*') {
					dp[i][j]=(str[i]==exp[j] || exp[j]=='.') && dp[i+1][j+1];
				}else {
					int si=i;
					while (si!=slen && (str[si]==exp[j] || exp[j]=='.')) {
						if (dp[si][j+2]) {
							dp[i][j]=true;
							break;
						}
						si++;
					}
					if (dp[i][j]!=true) {
						dp[i][j]=dp[si][j+2];
					}
				}
			}
			
		}
        return dp[0][0];
    }
    public boolean isValid(char[] s,char[] p) {
    	for (int i = 0; i < s.length; i++) {
			if (s[i]<'a' && s[i]>'z') {
				return false;
			}
		}
    	for (int i = 0; i < p.length; i++) {
			if (s[i]<'a' && s[i]>'z' && s[i]!='.' && s[i]!='*') {
				return false;
			}
		}
    	return true;
	}
}
