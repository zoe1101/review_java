package �ַ���;

public class ����߱���1�Ķ������ַ������� {
	public static int getNum1(int n) {
		if (n<1) {
			return 0;
		}
		return process(1,n); 
	}
//��0~i-1λ���ϵ��ַ��Ѿ�ȷ��������Ҫ���ҵ�i-1λ��Ϊ��1��ʱ�������i~N-1λ�����оٳ������ַ���Ҫ����ַ�����
	public static int process(int i,int n) {
		if (i==n-1) { //��n-2λΪ1�������n-1λ������1��0������
			return 2;
		}
		if (i==n) { //�ַ����������ˣ�����û�п�����ϵĿ����ˣ�ֻ��0~n-1���ַ�ʽ
			return 1;
		}
		//i<n-1ʱ����i-1λΪ1�����iλ������1��0
		//��iλ��1ʱ����Ӧprocess(i+1, n)
		//��iλ��0ʱ����i+1λ��Ϊ1����Ӧprocess(i+2, n)
		return process(i+1, n)+process(i+2, n);
	}
	//����2��ֱ�ӹ�ʽ����
	//������쳲��������У���1��Ϊ1���ڶ���Ϊ2��������Ϊf(n)=f(n-1)+f(n-2)
	public static int getNum2(int n) {
		if (n<1) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		int pre=1; //��ǰ���ǰ����
		int cur=1; //��ǰ�Ҳ�ǵ�ǰ��ǰһ��
		int tmp=0;
		for(int i=2;i<=n;i++) {
			tmp=cur;
			cur+=pre;
			pre=tmp;
		}
		return cur;
	}
	//����2�Ż�
	public static int getNum3(int n) {
		

	}

}
