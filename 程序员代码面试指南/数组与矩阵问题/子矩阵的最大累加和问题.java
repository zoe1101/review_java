package �������������;

//��Ҫ�Ѿ���ת��Ϊ������⣬��������ͱ�����飬Ȼ��������������ⷽʽ��������
public class �Ӿ��������ۼӺ����� {
	public static int maxSum(int[][] m) {
		if (m==null || m.length==0 || m[0]==null || m[0].length==0) {
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int cur=0;
		int[] s=null; //��������ͱ�����飬�õ����ۼ�����
		for (int i = 0; i < m.length; i++) {
			s=new int[m[0].length]; //�洢��i��j�е��ۼӺ�
			for (int j = i; j < m.length; j++) { 
				cur=0;
				for (int k = 0; k < s.length; k++) {
					s[k]+=m[j][k];
					cur+=s[k];
					max=Math.max(max, cur);
					cur=cur<0?0:cur;
				}
			}
		}
		return max;
	}

}
