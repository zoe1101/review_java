package �ݹ��붯̬�滮;
/*
 * ��һͷĸţ����ÿ����һͷСĸţ��ÿͷСĸţ3������Ҳ����ÿ��һͷСĸţ������ʵ���ڵ�n���ʱ�򣬹��ж���ͷĸţ��
 * ��һ����һͷ�����ĸţ
 */
public class 쳲���������_n���ţ������ {
//	������
	public static int solution1(int n) {
		if(n<1) return 0;
		if(n==1 || n==2 || n==3) {
			return n;
		}
		return solution1(n-1)+solution1(n-3);
	}
//�ȼ����ÿһ���ĸţ�������õ�n����ĸţ����
	public static int solution2(int n) {
		if(n<1) return 0;
		if(n==1 || n==2 || n==3) {
			return n;
		}
		int res=3;
		int pre=2;
		int prepre=1;
		int tmp1=0;
		int tmp2=0;
		for(int i=4;i<=n;i++) {
			tmp1=res;
			tmp2=pre;
			res=res+prepre;
			pre=tmp1;
			prepre=tmp2;
		}
		return res;
	}
	
	public static int solution3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}
//	m��p�η�
	public static int[][] matrixPower(int[][] matrix,int p) {
		int[][] res=new int[matrix.length][matrix[0].length];
		//�Ȱѽ��������Ϊ��λ����
		for(int i=0;i<matrix.length;i++) {
			res[i][i]=1;
		}
		int[][] temp=matrix;
		for(;p!=0;p>>=1) {
			if((p&1)!=0) {
				res=multMatrix(res, temp);
			}
			temp=multMatrix(temp, temp);
		}
		return res;
	}
	
	public static int[][] multMatrix(int[][] m1,int[][] m2) {
		int[][] res=new int[m1.length][m2[0].length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;i<m2[0].length;j++) {
				for(int k=0;k<m2.length;k++) {
					res[i][j]+=m1[i][k]*m2[k][j];
				}
			}
		}
		return res;
	}


	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
