package ��̬�滮;

//01��������,  ��ֵ���
//ʱ��Ϳռ临�ӶȾ�ΪO(N*V)
public class zero_one_backpack {

	public static void main(String[] args) {
	    int[] v= {0 , 2 , 5 , 3 , 10 , 4};  //��Ʒ��ֵ
	    int[] w= {0 , 1 , 3 , 2 , 6 , 2}; //��������
	    int C = 12; //��������
	    int[][] dp=FindMax2(v,w,C);
	    FindMax1(v, w, C);
	    FindWhat(dp,w);
	}
	
	public static int[][] FindMax2(int[] v,int[] w,int C) {
		int[][] dp =new int[w.length+1][C+1] ;
		//���
		for(int i=1;i<=w.length;i++) {
	    	for(int j=1;j<=C;j++) {
	    		if(j<w[i-1])   //�������������Է��µ� i ����Ʒ��ֻ��ѡ����
	    			dp[i][j]=dp[i-1][j];
				else {//�����������Է��µ� i ����Ʒ��Ҫ�����������Ʒ�Ƿ��ܻ�ȡ����ļ�ֵ��
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
				}		
	    	}
		}
		System.out.println("���dp����");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("����ֵΪ��"+dp[dp.length-1][dp[0].length-1]);
    	return dp;
	}
	
	public static int[] FindMax1(int[] v,int[] w,int C) {
		int[] dp =new int[C+1] ;
		//���
		for(int i=1;i<=w.length;i++) {
	    	for(int j=C;j>=w[i-1];--j) {
	    		dp[j]=Math.max(dp[j], dp[j-w[i-1]]+v[i-1]);
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
	////���Ž����
	public static void FindWhat(int[][] dp,int[] w) {  
		int n=dp.length;  //������n����Ʒ
		int c=dp[0].length-1;  //����������
		int[] x=new int[n];
	
	    for(int i=n-1;i>1;i--)
	    {
	        if(dp[i][c]==dp[i-1][c]) //��i����Ʒδȡ
	            x[i]=0;
	        else
	        {
	            x[i]=1;
	            c-=w[i-1];
	        }
	    }
	    x[1]=(dp[1][c]>0)?1:0;
	    
	    System.out.println("���Ž�");
	    for(int i=1;i<n;i++) {
	    	System.out.print(x[i]+" ");
	    }
	}
}
