package �ַ���;
/*
����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��

����: "babad"
���: "bab"
ע��: "aba" Ҳ��һ����Ч�𰸡�
 */
public class ������Ӵ� {
	
	//ʹ��Manacher�㷨
	/**
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s==null ||s.length()==0) {
			return "";
		}
		String charArr=manacherstring(s);
		int[] pArr=new int[charArr.length()];  //��¼��ÿ��Ԫ��Ϊ���ĵ������İ뾶
		int pR=0;  //�ѱ��������ַ������Ļ��İ뾶, �������Ӵ����ұ߽�
		int index=0; //���һ�θ���pRʱ���������ĵ�λ��, �������Ӵ�������
		int maxlen=0; //��¼��Ļ����Ӵ�����
		int resCenter = 0; 
		for(int i=1;i<charArr.length()-1;i++) {
			pArr[i]=pR>i?Math.min(pArr[2*index-i], pR-i):1;
			while (i+pArr[i]<charArr.length()-1&& i-pArr[i]>=0) {
				if(charArr.charAt(i+pArr[i])==charArr.charAt(i-pArr[i])) {
					pArr[i]++;
				}else {
					break;
				}
			}
			if(i+pArr[i]>pR) { //����¼�������Ҳ�˵����pR,�����pR��index
				pR=i+pArr[i];
				index=i;
			}
			if(maxlen<pArr[i]) {
				maxlen=pArr[i];
				resCenter=i;
			}
		}
		System.out.println(index+" "+maxlen);
		return s.substring((resCenter-maxlen)/2,(resCenter+maxlen)/2-1);
	}
	
	//����Manacher����
	public static String manacherstring(String str) {
		StringBuilder res = new StringBuilder("$#");
		char[] charArr=str.toCharArray();
		for(int i=0;i<charArr.length;i++) {//ͳһ��չ�������ż����������
			res.append(charArr[i]);
			res.append('#');
		}
		res.append('@');
		return res.toString();
		
	}
	
	//��̬�滮
    public static String longestPalindrome1(String s) {
        int len=s.length();
        if(len<=1) {
        	return s;
        }
        int start=0; //��¼�������Ӵ�����ʼλ��
        int maxlen=1; //�����ַ����ĳ���
        boolean dp[][]=new boolean[len][len];
        for(int i=0;i<len;i++) { //���ĶԽ���Ϊtrue����Ϊ���Լ����Լ�
        	dp[i][i]=true;
        }
        
//        ��Ϊ���������
//        1��������ĸ�����ִ���Ȼ�����Ա߸���������ĸ���ж��Ƿ�Ϊ����
//        2��������ĸ�����ִ���Ȼ�����Ա߸���������ĸ���ж��Ƿ�Ϊ����
      //2�ĳ���
        for(int i=0;i<len-1;i++) {
        	if(s.charAt(i)==s.charAt(i+1)) {
        		dp[i][i+1]=true;
        		start=i;
        		maxlen=2;
        	}
        }
        //3�ĳ��Ⱥ͸��೤��
        for(int i=2;i<len;i++) { // ö���Ӵ��ĳ���
        	for(int j=0;j<len-i;j++) { // ö���Ӵ���ʼλ��
        		if(s.charAt(j)==s.charAt(j+i) && dp[j+1][i+j-1]==true) {
        			if(i>maxlen-1) {//��������ֵ���ٸ�����ʼλ�ú���󳤶�
        				start=j;  
        				maxlen=i+1;
        			}
        			//���ܴ󲻴����Ƕ�Ҫȥ����dp���飬�ø�����һ���ǻ��ĵ�
        			dp[i][j]=true;
        		}
        	}
        }
        return s.substring(start,start+maxlen);
        
    }

	public static void main(String[] args) {
		String string="abbada";
		System.out.println(longestPalindrome(string));
	}

}
