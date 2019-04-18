package ��̬�滮;
import java.util.Scanner;
//���ر���
/*
��N����Ʒ��һ������ΪV�ı�����
��i����Ʒ�����n[i]����Ʒ���ã�ÿ���ĺķ���w[i]����ֵ��v[i]��
��⽫��Щ��Ʒװ�뱳����ʹ�úķѺͲ������������������ܼ�ֵ���
*/

public class multi_backpack {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int N=inScanner.nextInt();
		int[] n=new int[N];
		int[] w=new int[N];
		int[] v=new int[N];
		for (int i=0;i<N;i++) { //������Ʒ�ĸ��� 
			n[i] = inScanner.nextInt();
		}
		for (int i=0;i<N;i++) { //������Ʒ������
			w[i] = inScanner.nextInt();
		}
		for (int i=0;i<N;i++) {  //������Ʒ�ļ�ֵ 
			v[i] = inScanner.nextInt();
		}
		int C=inScanner.nextInt();
		
		findMax(n, w, v, C);
		findMax1(n, w, v, C);
	}
	
//	ת����01����������ѭ����
//	���ر��������ص�˼����ǽ����е���Ʒ(����ͬ��ͬһ��)������ͬ�����࣬����01��������⡣
//	��Ҳ���Կ�����ȫ�����ı��Σ��� i ����Ʒ����ȡ0����ȡ1������ȡn[i]����
	public static int[] findMax(int[] n,int[] w,int[] v,int C) {
		int[] dp=new int[C+1];
		for(int i=0;i<n.length;i++) {//����ÿһ����Ʒ 
			for(int j=0;j<n[i];j++) {//������Ʒ������
				for(int k=C;k>=w[j];k--) {//����01���������� 
					 //ȡ01���������dp[k]��dp[k-w[i]]+v[i]�����ֵ
					dp[k]=Math.max(dp[k], dp[k-w[j]]+v[j]);
				}
				
			}
		}
		System.out.println("���dp����");
		for(int i=0;i<dp.length;i++) {	
			System.out.print(dp[i]+" ");
			}
		System.out.println();
		System.out.println("����ֵΪ��"+dp[dp.length-1]);
		return dp;
	}
	

//	�������Ż���
	public static int[] findMax1(int[] n,int[] w,int[] v,int C) {
		int[] dp=new int[C+1];
		for(int i=0;i<n.length;i++) { //����ÿһ����Ʒ 
			if(w[i]*n[i]>=C) {
		   //���ͬһ����Ʒ�����������ڱ������������,��ת������ȫ����
				CompleteBag(w[i],v[i],dp,C);
			}
			else { //���01���� 
				int curnum=n[i];
				for(int k=1;k<=curnum;) { //�������Ż�
					bag01(w[i]*k,v[i]*k,dp,C);
					curnum-=k;
					k*=2;
				}
				bag01(w[i]*(n[i]-curnum+1),v[i]*(n[i]-curnum+1),dp,C);
			}
		}
		System.out.println("���dp����");
		for(int i=0;i<dp.length;i++) {	
			System.out.print(dp[i]+" ");
			}
		System.out.println();
		System.out.println("����ֵΪ��"+dp[dp.length-1]);
		return dp;
	}

	public static void bag01(int heft,int worth,int[] dp,int C)  //01���� 
	{   //heftΪ��ǰ��Ʒ������,worthΪ��ǰ��Ʒ�ļ�ֵ 
		for(int i=C;i>=heft;i--)
		{
			if(dp[i]>dp[i-heft]+worth)
			   dp[i]=dp[i];
			else dp[i]=dp[i-heft]+worth;
		}
	}
	public static void CompleteBag(int heft,int worth,int[] dp,int C)  //��ȫ���� 
	{   //heftΪ��ǰ��Ʒ������,worthΪ��ǰ��Ʒ�ļ�ֵ 
		for(int i=heft;i<=C;i++)
		{
			if(dp[i]>dp[i-heft]+worth)    
			   dp[i]=dp[i];
			else dp[i]=dp[i-heft]+worth;
		}
	}

}
