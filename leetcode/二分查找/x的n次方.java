package ���ֲ���;
/*
ʵ�� pow(x, n) �������� x �� n ���ݺ�����

����: 2.00000, 10
���: 1024.00000
 */
//����˼��: �۰����
public class x��n�η� {
	
//��������
//	��i��ʼ��Ϊn��Ȼ��i�Ƿ���2�ı������ǵĻ�x�����Լ�������res����x��iÿ��ѭ����Сһ�룬ֱ��Ϊ0ֹͣѭ����
//	���n�����������Ϊ���������䵹��
    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
//    �ݹ��۰����
    public static double myPow2(double x, int n) {
    	if(n==0) return 1;
    	double half=myPow2(x, n/2);
    	if(n%2==0)  return half*half;
    	if(n>0)	return half*half*x;
    	return half*half/x;
    }
	public static void main(String[] args) {
	    double x=2.0;
	    int n=10;
	    System.out.println(myPow2(x,n));
	}

}
