package λ����;

public class �����Ķ����Ʊ�����ж��ٸ�1 {
	public static int countOne1(int n) {
		int res=0;
		while (n!=0) {
			res+=n&1; //������λ�Ƿ�Ϊ1
			n>>>=1; //n=n>>>1,n�߼�����1λ
		}
		return res;
	}
	
	public static int countOne2(int n) {
		int res=0;
		while (n!=0) {
			n&=(n-1); //ÿ�ζ����Ժ��Ե�bitλ��Ϊ0�Ĳ���
			res++;
		}
		return res;
	}
	public static int countOne3(int n) {
		int res=0;
		while (n!=0) {
			n-=n&(~n+1); //ÿ�ο��Ժ��Ե�bitλ���ұߵ�Ϊ1
			res++;
		}
		return res;
	}
	//ƽ���㷨
	public static int countOne4(int n) {
		n=(n&0x55555555)+((n>>>1)&0x55555555);
		n=(n&0x33333333)+((n>>>2)&0x33333333);
		n=(n&0x0f0f0f0f)+((n>>>4)&0x0f0f0f0f);
		n=(n&0x00ff00ff)+((n>>>8)&0x00ff00ff);
		n=(n&0x0000ffff)+((n>>>16)&0x0000ffff);
		return n;

	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
