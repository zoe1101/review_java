package �ݹ��붯̬�滮;
/*
 * ��n x n�������Ϸ��ñ˴˲��ܹ�����n���ʺ󣬱˴�֮���������¹���
 * �����������Ӳ�ͬ�У���ͬ�У����Ҳ���һ��б���ϡ�
 */
public class N�ʺ����� {
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int solution1(int n) {
		if(n<1) return 0;
		int[] record=new int[n]; //��¼��i�еĻʹ����ڵ�λ�ã�����һ��
		return process1(0, record, n);
	}
	/**
	 * 
	 * @param i :�ڵ�i�з��ûʺ�
	 */
	public static int process1(int i,int[] record,int n) {
		if(i==n) {
			return 1;
		}
		int res=0;
		for(int j=0;j<n;j++) {
			if(isVaild(record, i, j)) {
				record[i]=j;
				res+=process1(i+1, record, n);
			}
		}
		return res;
	}
	/**
	 * �ж��Ƿ�����ڵ�i�еĵ�j�з��ûʺ�
	 */
	public static boolean isVaild(int[] record,int i,int j) {
		for(int k=0;k<i;k++) {
			if(j==record[k] || Math.abs(record[k]-j) == Math.abs(i-k) ) {
				return false;
			}
		}
		return true;
	}
	/**
	 * �ݹ�+λ���㣬����λ������м���
	 * @param n
	 * @return
	 */
	public static int solution2(int n) { 
		//����λ�������������int�ͱ���������ֻ����1��32���ʺ�����
		if(n<1 || n>32) return 0;
		int upperLim=n==32?-1:(1<<n)-1; //��ǰ����Щλ�ÿ��ԷŻʺ�1������Է���
		return process2(upperLim, 0, 0,0);
	}
	/**
	 * λ�ڸ����ϵĳ�ͻλ����colLim��leftDiaLim��rightDiaLim�е�1����ʾ��
	 * �������������������õ��������еĽ�λ��ȡ����͵õ����п��Էŵ�λ�ã���pos����ʾ����
	 * ��������������
	 * @param upperLim://��ǰ����Щλ�ÿ��ԷŻʺ�1������Է��ã�0��������
	 * @param colLim:ǰ������У���Щ���Ѿ������˻ʺ�1�����Ѿ����ã�0����û��
	 * @param leftDiaLim:��Ϊ���Ѿ����õ����лʺ�Ķ����·�б�ߵ�Ӱ�죬���µ�ǰ�в��ܷ��ûʺ�1�����ܷ���
	 * @param rightDiaLim:��Ϊ���Ѿ����õ����лʺ�Ķ����·�б�ߵ�Ӱ�죬���µ�ǰ�в��ܷ��ûʺ�1�����ܷ���
	 * @return
	 */
	public static int process2(int upperLim,int colLim,int leftDiaLim,int rightDiaLim) {
		if(colLim==upperLim) { //����ݹ鵽ĳ��ʱ����colLim=upperlim��˵��n���ʺ�ȫ�Ž�ȥ�ˣ��ҵ��Ľ�ĸ�����һ��
			return 1;
		}
		int pos=0; //��ǰ�п��Էŵ�λ��
		int mostRightOne=0;
		pos=upperLim&(~(colLim |leftDiaLim | rightDiaLim));
		int res=0;

		while (pos!=0) {//0 -- �ʺ�û�еط��ɷţ�����
//			  pos & -pos
//			ȡ���ټ� 1 ���ǲ��룬and ���� �븺�������ǰ�λ�Ͳ��������㡣
			mostRightOne=pos & (~pos+1);//ȡ�����ұߵ��Ǹ�1������pos�ͱ�ʾ���е�ĳ�����Էŵ�λ�ã�������pos���Ƴ����ݹ���øù��̡�
//			pos�д洢�����еĿɷ�λ�ã�Ϊ��������н⣬����������пɷŵ�λ�ã���ÿ�߹�һ�������Ҫɾ����������ͳ���ѭ������
			pos=pos-mostRightOne;
//			  (leftDiaLim | mostRightOne)<< 1 ����Ϊ��leftDiaLim��ɵ�ռλ����һ��Ҫ����һ�£�
//			 (rightDiaLim | mostRightOne)>> 1 ����Ϊ��rightDiaLim��ɵ�ռλ����һ��Ҫ����һ�¡�
			res+=process2(upperLim, colLim|mostRightOne, (leftDiaLim|mostRightOne)<<1, (rightDiaLim|mostRightOne)>>1);
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 8;

		long start = System.currentTimeMillis();
		System.out.println(solution1(n));
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

		start = System.currentTimeMillis();
		System.out.println(solution2(n));
		end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

	}

}
