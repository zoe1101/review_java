package Math;
/*
�������������������� dividend �ͳ��� divisor�������������Ҫ��ʹ�ó˷��������� mod �������
���ر����� dividend ���Գ��� divisor �õ����̡�

ʾ�� 1:

����: dividend = 10, divisor = 3
���: 3
 */
//����λ����
public class ������� {
    public int divide(int dividend, int divisor) {
        if (divisor==0) {
			return 0;
		}
        if (dividend==Integer.MIN_VALUE && divisor==-1) {
			return Integer.MAX_VALUE;
		}
        boolean negative=(dividend^divisor)<0; //������������Ƿ��������
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int res=0;
        for (int i = 31; i >=0; i--) {
			if ((t>>i)>=d) { //�ҳ��㹻�����2^n*divisor
				res+=1<<i;//���������2^n
				t-=d<<i;//����������ȥ2^n*divisor
				
			}
		}
        return negative ? -res : res;//��������ȡ��
    }
}
