package ��Ѷ;

import java.util.Scanner;

/*
����һ���ַ���s������Դ���ɾ��һЩ�ַ���ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ�
�����Ҫɾ�����ַ�������

��������: 
abcda
google
 
�������: ����ÿ�����ݣ����һ������������������Ҫɾ�����ַ�������
2
2
 */   
//��̬�滮
public class ������� {
	public static int LCS(String str1,String str2) {
		int len=str1.length();
		int[][] dp=new int[len+1][len+1];
		 for (int i=0;i<len+1;i++)
	         dp[i][0]=dp[0][i]=0;
		 for(int i=1;i<len+1;i++) {
			 for(int j=1;j<len+1;j++) {
				 if(str1.charAt(i-1)==str2.charAt(j-1)) { //�뷴�ַ����Ƚϣ���һ����ͬ�ַ��ļ�1�Σ����Һ��϶Խǵ��ۼ���һ��
					 dp[i][j]=dp[i-1][j-1]+1;
				 }else if(dp[i][j-1]>dp[i-1][j]) {//�뷴�ַ����Ƚ��в�ͬ�ַ�ʱ�����������������Ƚ�ȡ�ϴ�ֵ
					 dp[i][j]=dp[i][j-1];
				 }else {
					 dp[i][j]=dp[i-1][j];
				 }
			 }
		 }
		 return dp[len][len];  //�����������ۼƵ��������Ƶ��������¸�

	}
		

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str=scanner.nextLine();
			String strrev=new StringBuilder(str).reverse().toString();
			System.out.println(str.length() - LCS(str, strrev));
		}
		

	}

}
