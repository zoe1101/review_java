package ������Ŀ;

public class ���ڽ׳˵����� {
	//��Ҫ��0���͵���2*5����ô��Ҫ�ҳ�1��num����������2,5�ĸ�����2���5��
	//����ֻҪ�ҵ��ܱ�5���������ĸ����Ϳ�����
	public static int zeroNum1(int num) {
		if (num<0) { //ֻ����Ǹ���
			return 0;
		}
		int res=0;
		int cur=0;
		for (int i = 5; i <= num; i=i+5) {
			cur=i;
			while (cur%5==0) {
				res++;
				cur/=5;
			}
		}
		return res;
	}
	//�Ľ�
	public static int zeroNum2(int num) {
		if (num<0) { //ֻ����Ǹ���
			return 0;
		}
		int res=0;
		while (num!=0) {
			res+=num/5;
			num/=5;
		}
		return res;
		
	}

}
