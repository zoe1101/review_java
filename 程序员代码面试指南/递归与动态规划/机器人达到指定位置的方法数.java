package �ݹ��붯̬�滮;

public class �����˴ﵽָ��λ�õķ����� {
	/**
	 * �����ݹ�
	 * @param N:N��λ��
	 * @param M: �����˵�ǰ���ڵ�λ��
	 * @param rest:��ʣrest��Ҫ��
	 * @param P:��������Ҫ�ﵽ��Ŀ��λ��
	 * @return
	 */
	public static int walk(int N,int cur,int rest,int P) {
		if(rest==0) { //û��ʣ�ಽ���ˣ���ǰλ��cur��������λ��
			return cur==P?1:0;//������λ����P�ϣ���˵��֮ǰ���ƶ�����Ч��
		}
		if(cur==1) {//��ǰ��1λ�ã�ֻ����2����
			return walk(N, 2, rest-1, P);
		}
		if (cur==N) {//��ǰ��Nλ�ã�ֻ����N-1����
			return walk(N, N-1, rest-1, P);
		}
		//���м�λ��
		return walk(N, cur+1, rest-1, P)+walk(N, cur-1, rest-1, P);
	}
	/**
	 * 
	 * @param N:N��λ��
	 * @param M: ���������ڵ���ʼλ��
	 * @param K:��Ҫ��K��
	 * @param P:��������Ҫ�ﵽ��Ŀ��λ��
	 * @return
	 */
	public static int solution1(int N,int M,int K,int P) {
		if(N<2 || K<1 || M<1 || M>N || P<1  || P>N) {
			return 0;
		}
		
		return walk(N, M, K, P);
	}
	/**
	 * ��̬�滮
	 * @param N
	 * @param M
	 * @param K
	 * @param P
	 * @return
	 */
	public static int solution2(int N,int M,int K,int P) {
		if(N<2 || K<1 || M<1 || M>N || P<1  || P>N) {
			return 0;
		}
		int[][] dp=new int[K+1][N+1];
		dp[0][P]=1;
		for(int i=1;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				if(j==1) {
					dp[i][j]=dp[i-1][2];
				}else if(j==N) {
					dp[i][j]=dp[i-1][N-1];
				}else {
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
				}
			}
		}
		return dp[K][M];
	}
	/**
	 * ��̬�滮+�ռ�ѹ��
	 * @param N
	 * @param M
	 * @param K
	 * @param P
	 * @return
	 */
	public static int solution3(int N,int M,int K,int P) {
		if(N<2 || K<1 || M<1 || M>N || P<1  || P>N) {
			return 0;
		}
		int[] dp=new int[N+1];
		dp[P]=1;
		for(int i=1;i<=K;i++) {
			int leftUP=dp[1]; //���Ͻǵ�ֵ
			for(int j=1;j<=N;j++) {
				int temp=dp[j];
				if(j==1) {
					dp[j]=dp[j+1];
				}else if(j==N) {
					dp[j]=leftUP;
				}else {
					dp[j]=leftUP+dp[j+1];
				}
				leftUP=temp;
			}
		}
		return dp[M];
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
