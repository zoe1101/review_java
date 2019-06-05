package �ַ���;

public class ��������ַ�ʹ�ַ������嶼�ǻ����ַ��� {
	public static String getPalindrome1(String str) {
		if (str==null ||str.length()<2) {
			return str;
		}
		char[] chas=str.toCharArray();
		int[][] dp=new int[chas.length][chas.length];
		for (int j = 1; j < dp.length; j++) {
			dp[j-1][j]=chas[j-1]==chas[j]?0:1;
			for (int i = j-2; i >=0; i--) {
				if (chas[i]==chas[j]) { //i��jλ����ȣ�ֻ��Ҫ�����м�λ�õ�ֵ
					dp[i][j]=dp[i+1][j-1];
				}else {//i��jλ�ò���ȣ�������ʹ[i,j-1]��[i+1,j]��Ϊ���Ĵ���Ȼ����ȡ�����������ٵ���һ��
					dp[i][j]=Math.min(dp[i][j-1], dp[i+1][j])+1;
				}
			}
		}
		int newlen=chas.length+dp[0][chas.length-1];
		char[] res=new char[newlen];
		int i=0;
		int j=chas.length-1;
		int resl=0;
		int resr=newlen-1;
		while (i<=j) {
			if (chas[i]==chas[j]) {
				res[resl++]=chas[i++];
				res[resr--]=chas[j--];
			}else if (dp[i][j-1]<dp[i+1][j]) { //ѡ������ʹ[i,j-1]��Ϊ���Ĵ�������i��������chas[j]��ֵ
				res[resl++]=chas[j];
				res[resr--]=chas[j--];
			}else {//ѡ������ʹ[i+1,j]��Ϊ���Ĵ�������j���ұ����chas[i]��ֵ
				res[resl++]=chas[i];
				res[resr--]=chas[i++];
			}
		}
		return String.valueOf(res);
	}
	
	//���ײ��֣�����й���
	public static String getPalindrome2(String str,String strlps) {
		if (str==null ||str.equals("")) {
			return "";
		}
		char[] chas=str.toCharArray();
		char[] lps=strlps.toCharArray();
		char[] res=new char[chas.length*2-lps.length];
		int chasl=0;
		int chasr=chas.length-1;
		int lpsl=0;
		int lpsr=lps.length-1;
		int resl=0; //res�任����ʼλ��
		int resr=res.length-1; //res�任�Ľ���λ��
		int tmpl=0;  //��¼chas�����Ҫ�䶯����ʼλ��
		int tmpr=0;  //��¼chas�ұ���Ҫ�䶯�Ľ���λ��
		while (lpsl<=lpsr) {
			tmpl=chasl; 
			tmpr=chasr; 
			while (chas[chasl]!=lps[lpsl]) { //�ҵ����lps[lpsl]��chas�ж�Ӧ��λ��
				chasl++;
			}
			while (chas[chasr]!=lps[lpsr]) {//�ҵ��ұ�lps[lpsr]��chas�ж�Ӧ��λ��
				chasr--;
			}
			set(res, resl, resr, chas, tmpl, chasl, chasr, tmpr);
			resl+=chasl-tmpl+tmpr-chasr; 
			resr-=chasl-tmpl+tmpr-chasr; 
			//��lps[lps1]��lps[lpsr]��Ӧ�Ļ����ַ����룬lpsָ����λ
			res[resl++]=chas[chasl++]; 
			res[resr--]=chas[chasr--];
			lpsl++;
			lpsr--;
		}
		return String.valueOf(res);
		
	}
	/**
	 * 
	 * @param res
	 * @param resl
	 * @param resr
	 * @param chas
	 * @param ls:�����Ҫ�䶯����ʼλ��
	 * @param le�������Ҫ�䶯�Ľ���λ��
	 * @param rs���ұ���Ҫ�䶯����ʼλ��
	 * @param re���ұ���Ҫ�䶯�Ľ���λ��
	 */
	public static void set(char[] res,int resl,int resr,char[] chas,int ls,int le,int rs,int re) {
		for (int i = ls; i < le; i++) { //����������res����ߣ��ұ��������res���ұ�
			res[resl++]=chas[i];
			res[resr--]=chas[i];
		}
		for (int i = re; i> rs; i--) { //����������res����ߣ��ұ��������res���ұ�
			res[resl++]=chas[i];
			res[resr--]=chas[i];
			
		}
	}
	
	public static void main(String[] args) {
		String str = "AB1CD2EFG3H43IJK2L1MN";
		System.out.println(getPalindrome1(str));

		String strlps = "1234321";
		System.out.println(getPalindrome2(str, strlps));

	}
}
