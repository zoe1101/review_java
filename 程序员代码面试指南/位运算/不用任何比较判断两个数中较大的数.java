package λ����;

public class �����καȽ��ж��������нϴ���� {
	public static int getMax1(int a,int b) {
		int c=a-b; //�����������
		int scA=sign(c);
		int scB=flip(scA);
		return a*scA+b*scB;
		
	}
	//�����������ж���������0����1����������0
	public static int sign(int n) {
		return  flip((n>>31)&1);
	}
	//�������������ȡ������������0����������1
	public static int flip(int n) {
		return n^1;//����: 1���1����0
	}
	
	//���getMax1�е��������
	public static int getMax2(int a,int b) {
		int c=a-b;
		int sa=sign(a);
		int sb=sign(b);
		int sc=sign(c);
		int difSab=sa^sb; //a��b�ķ��Ų�ͬ��Ϊ1
		int sameSab=flip(difSab); //difSabΪ1����Ϊ0
		//difSab��sameSab�Ƿ���
		int returnA=difSab*sa+sameSab*sc;
		int returnB=flip(returnA);
		return a*returnA+b*returnB;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
