package �ݹ��붯̬�滮;

public class ������Ӵ����� {
	public static String lcst1(String str1,String str2) {
		if (str1==null || str2==null ||str1.length()==0 || str2.length()==0) {
			return "";
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//dp[i][j]:��str1[i]��str2[j]���ɹ����Ӵ����һ���ַ�ʱ�������Ӵ��ĳ���
		int[][] dp=new int[chs1.length][chs2.length];
		for (int i = 0; i < chs1.length; i++) {
			if (chs1[i]==chs2[0]) {
				dp[i][0]=1;
			}
		}
		for (int i = 1; i < chs2.length; i++) {
			if (chs1[0]==chs2[i]) {
				dp[0][i]=1;
			}
		}
		for (int i = 1; i < chs1.length; i++) {
			for (int j = i; j < chs2.length; j++) {
				if (chs1[i]==chs2[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
			}
		}
		
		int end=0; //�����ַ������һ���ַ���Ӧstr1��λ��
		int max=0; //��󹫹��ַ�����¼
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (dp[i][j]>max) {
					end=i;
					max=dp[i][j];
				}
			}
		}
		return str1.substring(end-max+1,end+1);
	}
	//�򻯵Ķ�̬�滮
	public static String lcst2(String str1,String str2)  {
		if (str1==null || str2==null ||str1.length()==0 || str2.length()==0) {
			return "";
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		int row=0; //б�߿�ʼλ�õ���
		int col=chs2.length-1; //б�߿�ʼλ�õ���
		int max=0; //��¼��󳤶�
		int end=0; //��󳤶ȸ���ʱ����¼�Ӵ��Ľ���λ��
		while (row<chs1.length) { //б�ߴ����Ϸ���ʼ
			int i=row;
			int j=col;
			int len=0;
			while (i<chs1.length && j<chs2.length) {
				if (chs1[i]==chs2[j]) {
					len++;
				}else {
					len=0;
				}
				if (len>max) { //��¼���ֵ������λ��
					end=i;
					max=len;
				}
				i++;
				j++;
			}
			if (col>0) { //б�߿�ʼλ�õ����������ƶ�
				col--;
			}else {  //���ƶ��������,�������ƶ�
				row++;
			}
		}
		return str1.substring(end-max+1,end+1);
	}
	public static void main(String[] args) {
		String str1 = "ABC1234567DEFG";
		String str2 = "HIJKL1234567MNOP";
		System.out.println(lcst1(str1, str2));
		System.out.println(lcst2(str1, str2));

	}
}
