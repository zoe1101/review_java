package ������Ŀ;
//���Ҽл��������˵��м�
public class �ж�һ�����Ƿ��ǻ����� {
	public static boolean isPalindrome(int n) {
		if (n==Integer.MIN_VALUE) {
			return false;
		}
		n=Math.abs(n);
		int help=1;
		while (n/help>=10) { //ʹ��help��nλ����ͬ
			help*=10;
		}
		while (n!=0) {
			if (n/help != n%10) { //���λ���������λ
				return false;
			}
			n=(n%help)/10;
			help/=100; //һ���Ի�����λ�����һλ���ұ�һλ
		}
		return true;
	}

}
