package �ݹ��붯̬�滮;

public class ���ʽ�õ����������������� {
	//�����ʽ�Ƿ���Ч
	/*���ȱ���Ϊ����
	 * �±�Ϊż��ʱΪ0��1,�±��0��ʼ
	 * �±�Ϊ����ʱΪ��&������|����^��
	 */
	public static boolean isValid(char[] exp) {
		if((exp.length &1)==0) { //���ȶ��������λ��Ϊ1ʱΪż��������1��Ϊ0
			return false;
		}
		for (int i = 0; i < exp.length; i=i+2) {
			if (exp[i]!='1' &&  exp[i]!='0' ) {
				return false;
			}
		}
		for (int i = 1; i < exp.length; i=i+2) {
			if (exp[i]!='^' &&  exp[i]!='&' &&  exp[i]!='|' ) {
				return false;
			}
		}
		return true;
	}
	//�����ݹ�,��������ѱ��ʽ�ֳ������֣�Ȼ����������
//	ʱ�临�Ӷȣ�O(N!)
	public static int num1(String express,boolean desired) {
		if (express==null || express.length()==0) {
			return 0;
		}
		char[] exp=express.toCharArray();
		if (!isValid(exp)) {
			return 0;
		}
		return p(exp, desired, 0, exp.length-1);
	}
	public static int p(char[] exp,boolean desired,int left,int right) {
		if (left==right) {
			if (exp[left]=='1') {
				return desired?1:0;
			}else {
				return desired?0:1;
			}
		}
		int res=0;
		if (desired) { //�������Ϊtrue
			for (int i = left+1; i < right; i=i+2) {//���������
				switch (exp[i]) {
				case '&':
					res+=p(exp, true, left, i-1)*p(exp, true, i+1, right);
					break;
				case '|':
					res+=p(exp, true, left, i-1)*p(exp, true, i+1, right);
					res+=p(exp, true, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, false, left, i-1)*p(exp, true, i+1, right);
					break;
				case '^':
					res+=p(exp, true, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, false, left, i-1)*p(exp, true, i+1, right);
					break;
				default:
					break;
				}
			}
		}else {//�������Ϊfalse
			for (int i = left+1; i < right; i=i+2) {//���������
				switch (exp[i]) {
				case '&':
					res+=p(exp, false, left, i-1)*p(exp, true, i+1, right);
					res+=p(exp, true, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, false, left, i-1)*p(exp, false, i+1, right);
					break;
				case '|':
					res+=p(exp, false, left, i-1)*p(exp, false, i+1, right);
					break;
				case '^':
					res+=p(exp, false, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, true, left, i-1)*p(exp, true, i+1, right);
					break;
				default:
					break;
				}
			}
		}
		return res;
	}
//��̬�滮
	public static int num2(String express,boolean desired) {
		if (express==null || express.length()==0) {
			return 0;
		}
		char[] exp=express.toCharArray();
		if (!isValid(exp)) {
			return 0;
		}
		int len=exp.length;
		int[][] tr=new int[len][len];
		int[][] fa=new int[len][len];
		tr[0][0]=exp[0]=='1'?1:0;
		fa[0][0]=exp[0]=='0'?1:0;
		
	    //����j��i��������
		for (int i = 2; i < len; i=i+2) {
			tr[i][i]=exp[0]=='1'?1:0;
			fa[i][i]=exp[0]=='0'?1:0;
			for (int j = i-2; j >=0 ;j=j-2) {
				for (int k = j; k <i; k=k+2) { //���������
					if (exp[k+1]=='&') {
						tr[j][i]+=tr[j][k]*tr[k+2][i];
						fa[j][i]=fa[j][k]*fa[k+2][i]+fa[j][k]*tr[k+2][i]+tr[j][k]*fa[k+2][i];
					}else if (exp[k+1]=='|') {
						tr[j][i]=tr[j][k]*tr[k+2][i]+fa[j][k]*tr[k+2][i]+tr[j][k]*fa[k+2][i];
						fa[j][i]+=fa[j][k]*fa[k+2][i];
					}else if (exp[k+1]=='^') {//���
						tr[j][i]=fa[j][k]*tr[k+2][i]+tr[j][k]*fa[k+2][i];
						fa[j][i]+=tr[j][k]*tr[k+2][i]+fa[j][k]*fa[k+2][i];
					}
				}
			}
		}
		return desired?tr[0][len-1]:fa[0][len-1];
	}
	public static void main(String[] args) {
		String express = "1^0|0|1";
		boolean desired = true;
		System.out.println(num1(express, desired));
		System.out.println(num2(express, desired));

	}
}
