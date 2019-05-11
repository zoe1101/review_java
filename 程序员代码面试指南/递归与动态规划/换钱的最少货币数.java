package �ݹ��붯̬�滮;

public class ��Ǯ�����ٻ����� {
	// �����ݹ�
	public static int minCoins1(int[] arr,int aim) {
		if(arr==null || arr.length==0 ||aim<0) {
			return -1;
		}
		return process(arr, 0, aim);
	}
	// ������
	/**
	 * 
	 * @param arr
	 * @param i :��ǰ���ǵ���ֵarr[i]��Ǯ
	 * @param rest :ʣ����Ҫ�����Ǯ
	 * @return  ����-1��ʾ�Ҳ��������صĲ���-1ʱ�����ص����һص�Ǯ������
	 */
	public static int process(int[] arr,int i,int rest) {
		//�Ѿ�û����ֵ���Կ�����
		if(i==arr.length) {
			return rest==0?0:-1;
		}
		//������������ʼΪ-1��������Ч��
		int res=-1;
		for(int k=0;k*arr[i]<rest;k++) {
			int next=process(arr, i+1, rest-k*arr[i]);
			if(next!=-1) {
				res=res==-1?next+k:Math.min(res, next+k);
			}
		}
		return res;
	}
	/**
	 * ��̬�滮��
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int minCoins2(int[] arr,int aim) {
		if(arr==null || arr.length==0 ||aim<0) {
			return -1;
		}
		int n=arr.length;
		int[][] dp=new int[n+1][aim+1];
		for(int i=1;i<=aim;i++) {
			dp[n][i]=-1;
		}
		for(int i=n-1;i>=0;i--) { //�������ϼ���ÿһ��
			for(int rest=0;rest<=aim;rest++) { //ÿһ�д�����
				dp[i][rest]=-1; //��ʼʱ������dp[i][rest]��ֵ��Ч
				if(dp[i+1][rest]!=-1) { //����dp[i+1][rest]ֵ��Чʱ
					dp[i][rest]=dp[i+1][rest];//�����ó������ֵdp[i+1][rest]
				}
				//��ߵ�λ�ò�Խ������Ч
				if(rest-arr[i]>=0 && dp[i][rest-arr[i]]!=-1) {
					if(dp[i][rest]==-1) {//֮ǰ�������ֵdp[i+1][rest]����Ч�ģ�����dp[i][rest]ֵδ���ı�
						dp[i][rest]=dp[i][rest-arr[i]]+1; //��Ϊ��ߵ�ֵ
					}else { //��ߵ�ֵ�������ֵ����Чʱ����Ҫ����ѡһ����С��
						dp[i][rest]=Math.min(dp[i][rest], dp[i][rest-arr[i]]+1);
					}
				}
			}
		}
		return dp[0][aim];
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
