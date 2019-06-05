package �ݹ��붯̬�滮;

public class �ַ����Ľ������ {
	public static boolean isCross1(String str1,String str2,String aim) {
		if (str1==null ||str2==null ||aim==null) {
			return false;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		char[] chaim=aim.toCharArray();
		if (chaim.length!=chs1.length+chs2.length) {
			return false;
		}
		//dp[i][j]:aim[0..i+j-1]�ܷ�str1[0..i-1]��str2[0..j-1]�������
		boolean[][] dp=new boolean[chs1.length+1][chs2.length+1];
		dp[0][0]=true;
		 //��һ�У�dp[i][0]:aim[0..i-1]�ܷ�ֻ��str1[0..i-1]�������
		for (int i = 1; i < chs1.length+1; i++) {
			if (chs1[i-1]!=chaim[i-1]) {//һ�����򣬺���Ͷ�������
				break;
			}
			dp[i][0]=true;
		}
		////��һ��,dp[0][j]:aim[0..j-1]�ܷ�ֻ��str2[0..j-1]�������
		for (int i = 1; i < chs2.length+1; i++) { 
			if (chs2[i-1]!=chaim[i-1]) {//һ�����򣬺���Ͷ�������
				break;
			}
			dp[0][i]=true;
		}
		for (int i = 0; i < chs1.length+1; i++) {
			for (int j = 0; j < chs2.length+1; j++) {
				if ((chs1[i-1]==chaim[i+j-1] &&dp[i-1][j]) ||
					(chs2[j-1]==chaim[i+j-1]&& dp[i][j-1])) {
					dp[i][j]=true;
				}
			}
		}
		return dp[chs1.length][chs2.length];
	}
	//�Ż���̬�滮��ѹ���ռ�
	public static boolean isCross2(String str1,String str2,String aim) {
		if (str1==null ||str2==null ||aim==null) {
			return false;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		char[] chaim=aim.toCharArray();
		if (chaim.length!=chs1.length+chs2.length) {
			return false;
		}
		//���Ƚ�С����Ϊ���ַ������ϳ�����Ϊ���ַ���
		char[] longs=chs1.length>chs2.length?chs1:chs2;
		char[] shorts=longs.length==chs1.length?chs2:chs1;
		boolean[] dp=new boolean[shorts.length+1];
		dp[0]=true;
		for (int i = 1; i < shorts.length+1; i++) {
			if (shorts[i-1]!=chaim[i-1]) {
				break;
			}
			dp[i]=true;
		}
		for (int i = 1; i < longs.length+1; i++) {
			dp[0]= dp[0] && longs[i-1]==chaim[i-1];
			for (int j = 1; j < shorts.length+1; j++) {
				if ((longs[i-1]==chaim[i+j-1] && dp[j]) ||
					(shorts[j-1]==chaim[+j-1] && dp[j-1])){
					dp[j]=true;
				}else {
					dp[j]=false;
				}
			}
		}
		return dp[shorts.length];
	}


}
