package �ݹ��붯̬�滮;

public class ��С�༭���� {
	/**
	 * 
	 * @param str1���ַ���1
	 * @param str2���ַ���2
	 * @param ic��һ���ַ��Ĳ������
	 * @param dc��һ���ַ���ɾ������
	 * @param rc��һ���ַ����滻����
	 * @return
	 */
	public static int minCost1(String str1,String str2,int ic,int dc,int rc) {
		if (str1==null || str2==null) {
			return 0;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//Ŀ�꣺str1���str2
		//d[i][j]Ϊ��str1��1~iλ��str2��1~jλ��Ϊ��ͬʱ�Ĳ�������
		int[][] dp=new int[chs1.length+1][chs2.length+1];
		
		for (int i = 1; i < chs1.length+1; i++) { //str1��ɿ��ַ�����ɾ��str1������Ԫ��
			dp[i][0]=dc*i;
		}
		
		for (int i = 1; i < chs2.length+1; i++) {//���ַ������str1����str1������Ԫ�ؽ��в���
			dp[0][i]=ic*i;
		}
		for (int i = 1; i < chs1.length+1; i++) {
			for (int j = 1; j <chs2.length+1; j++) {
				 //dp[i][j]��Ӧ����str1[i-1]��str2[j-1]
				if (chs1[i-1]==chs2[j-1]) { //str1[i-1]��str2[j-1]���
					dp[i][j]=dp[i-1][j-1];
				}else {//str1[i-1]��str2[j-1]����ȣ��ͽ����滻
					dp[i][j]=dp[i-1][j-1]+rc;
				}
				//�Ӳ����������룬ɾ�����滻��ѡһ����С��
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+ic);
				dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+dc);
			}
		}
		return dp[chs1.length][chs2.length];
	}
	
	//�Ż���̬�滮�����ٿռ临�Ӷ�
	public static int minCost2(String str1,String str2,int ic,int dc,int rc) {
		if (str1==null || str2==null) {
			return 0;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//Ŀ�����ɳ����
		char[] longs=chs1.length>=chs2.length?chs1:chs2; //str1��str2�еĽϳ���
		char[] shorts=longs==chs1?chs2:chs1;//str1��str2�еĽ϶���
		
		if (chs1.length<chs2.length) { //str1����str2���������ɾ���Ĵ���ֵ����
			int tmp=ic;
			ic=dc;
			dc=tmp;
		}
		// dp[j] = dp[i][j]:str1��1��iΪ���str2��1:jλ����Ĵ���
		int[] dp=new int[shorts.length+1]; 
		
		for (int i = 1; i < dp.length; i++) { //���ַ�����str2[0:i]����Ĵ��ۣ��������
			dp[i]=ic*i;
		}
		for (int i = 1; i < longs.length+1; i++) {
			int pre=dp[0]; //���Ͻǵ�ֵ
			dp[0]=dc*i; //str1[0:i]�����ַ�������Ĵ��ۣ�ɾ������
			for (int j = 1; j < shorts.length+1; j++) {
				int tmp=dp[j];
				if (longs[i-1]==shorts[j-1]) {
					dp[j]=pre;
				}else {
					dp[j]=pre+rc; //str1[i-1]�滻
				}
				dp[j]=Math.min(dp[j], dp[j-1]+ic); //����
				dp[j]=Math.min(dp[j], tmp+dc); //ɾ��
				pre=tmp;
			}
		}
		return dp[shorts.length];
	}

}
