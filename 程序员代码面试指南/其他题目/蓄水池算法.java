package ������Ŀ;

public class ��ˮ���㷨 {
	public int[]  getKnumsRand(int k,int max) {
		if (max<1 || k<1) {
			return null;
		}
		int[] res=new int[Math.min(k, max)];
		for (int i = 0; i < res.length; i++) { //��ǰk����ֱ�ӷŽ�������
			res[i]=i+1;
		}
		for (int i = k+1; i <=max; i++) {
			if (rand(i)<=k) { //rand(i)�����ѡ��i,��i��Ҫ�������
				res[rand(k)-1]=i; //�Ӵ���������滻һ������
			}
		}
		return res;
	}
	public static int rand(int max) {
		return (int) (Math.random()*max)+1; //��[1��max]�����ѡһ����
	}

}
