package �ݹ��붯̬�滮;

public class 쳲��������� {
//	������,O(n^2)
	public static int solution1(int n) {
		if(n<1) return 0;
		if(n==1 ||n==2) return 1;
		return solution1(n-1)+solution1(n-2);
	}
//�ȼ����ÿһ�Ȼ��ֱ�ӷ��� O(n)
	public static int solution2(int n) {
		if(n<1) return 0;
		if(n==1 ||n==2) return 1;
		int res=1;
		int pre=1;
		int tmp=1;
		for(int i=2;i<=n;i++) {
			tmp=res;
			res=pre+tmp;
			pre=tmp;
		}
		return res;
	}
	
//���þ���˷���⣬ת��Ϊ�����n�η�����.  O(log2n)
	public static int solution3(int n) {
		if(n<1) return 0;
		if(n==1 ||n==2) return 1;
		int[][] base= {{1,1},{1,0}};
		int[][] res=matrixPower(base, n-2);
		return res[0][0]+res[1][0];
	}
//	�����n�η�
	public static int[][] matrixPower(int[][] matrix, int n) {
		int[][] res=new int[matrix.length][matrix[0].length];
		//�Ȱѽ��������Ϊ��λ����
		for(int i=0;i<matrix.length;i++) {
			res[i][i]=1;
		}
		int[][] temp=matrix;
		for(;n!=0;n>>=1) {
			if((n&1)!=0) {
				res=muliMatrix(res, temp);
			}
			temp=muliMatrix(temp, temp);
		}
		return res;
	}
	//����˷�
	public static int[][] muliMatrix(int[][] m1,int[][] m2) {
		int[][] res=new int[m1.length][m2[0].length];
		for(int i=0;i<m1.length;i++) { 
			for(int j=0;j<m2[0].length;j++) {
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
