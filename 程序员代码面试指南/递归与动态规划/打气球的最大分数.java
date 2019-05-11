package �ݹ��붯̬�滮;

public class ������������� {
	/**�����ݹ�
	 * ��arr[L..R]�ϵ���������
	 * ����arr[L-1]��arr[R+1]�ƶ�û�б���
	 * @param arr
	 * @param L
	 * @param R
	 * @return
	 */
	public static int process(int[] arr, int L,int R) {
		if(L==R) {//ֻ��һ������ֱ�Ӵ�
			return arr[L-1]*arr[L]*arr[R+1];
		}
		//��ȡ����arr[L]������arr[R]�÷ֵĽϴ���
		int max=Math.max(
				arr[L-1]*arr[L]*arr[R+1]+process(arr, L+1, R), //����arr[L]
				arr[L-1]*arr[R]*arr[R+1]+process(arr, L, R-1));  //����arr[R]
		//Ȼ��Ƚ����򱬵�i�������뵱ǰmaxֵ��ȡ�ϴ���Ϊ�µ�max
		for(int i=L+1;i<R;i++) {
			//���򱬵�i��������Ҫ��ȫ����i������ұߵ�����
			max=Math.max(arr[L-1]*arr[i]*arr[R+1]+process(arr, L, i-1)+process(arr, i+1, R), max);
		}
		return max;
	}
	
	public static int maxScores1(int[] arr) {
		if(arr==null ||arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return arr[0];
		}
		int N=arr.length;
		int[] help=new int[N+2]; //��������,��arr�Ļ���������β��1
		help[0]=1;
		help[N+1]=1;
		for(int i=0;i<N;i++) {
			help[i+1]=arr[i];
		}
		return process(help, 1, N); //ֻ�����Ч������
	}
/**
 * ��̬�滮��
 * @param arr
 * @return
 */
	public static int maxScores2(int[] arr) {
		if(arr==null ||arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return arr[0];
		}
		int N=arr.length;
		int[] help=new int[N+2]; //��������,��arr�Ļ���������β��1
		help[0]=1;
		help[N+1]=1;
		for(int i=0;i<N;i++) {
			help[i+1]=arr[i];
		}
		int[][] dp=new int[N+2][N+2];
		for(int i=1;i<=N;i++) {
			dp[i][i]=help[i-1]*help[i]*help[i+1];
		}
		for(int L=N; L>=1;L--) {
			for(int R=L+1;R<=N;R++) {
				int finalL=help[L-1]*help[L]*help[R+1]+dp[L+1][R]; //����arr[L]�ķ���
				int finalR=help[L-1]*help[R]*help[R+1]+dp[L][R-1]; //����arr[R]�ķ���
				dp[L][R]=Math.max(finalL, finalR);
				for(int i=L+1;i<R;i++) {
					dp[L][R]=Math.max(dp[L][R], help[L-1]*help[i]*help[R+1]+dp[L][i-1]+dp[i+1][R]);
				}
			}
		}
		return dp[1][N];
	}
	public static void main(String[] args) {
		int[] arr= {3,2,5};
		
		System.out.println(maxScores1(arr));
		System.out.println(maxScores2(arr));

	}

}
