package �������������;

public class �߽綼��1����������δ�С {
	public static int getMaxSize(int[][] m) {
		int row=m.length;
		int col=m[0].length;
		int[][] right=new int[row][col]; //right[i][j]����(i,j)����������������1�ĸ���
		int[][] down=new int[row][col]; //down[i][j]����(i,j)����������������1�ĸ���
		setBorderMap(m, right, down); //����ĳһ��λ�����Һ�����ʱ1�������ֵĸ���
		for (int size =Math.min(row, col); size>0; size--) { //�Ӵ�С�����Ƿ���ڱ߳�Ϊsize��������
			if (hasSizeOfBorder(size, right, down)) { //���ھͷ���size
				return size;
			}
		}
		return 0;
		
	}
	
	public static void setBorderMap(int[][] m,int[][] right,int[][] down) {
		int row=m.length;
		int col=m[0].length;
//		�Ӿ�������½ǽ��м���
		//���½ǵ�Ԫ��
		if (m[row-1][col-1]==1) {
			right[row-1][col-1]=1;
			down[row-1][col-1]=1;
		}
		//���һ��
		for (int i = row-2; i >=0; i--) { 
			if (m[i][col-1]==1) {
				right[i][col-1]=1;
				down[i][col-1]=down[i+1][col-1]+1;
			}
		}
		//���һ��
		for (int i = col-2; i>=0; i--) { 
			if (m[row-1][i]==1) {
				down[row-1][i]=1;
				right[row-1][i]=right[row-1][i+1]+1;
			}
		}
		//����λ��
		for (int i = row-2; i >=0; i--) {
			for (int j = col-2; j >=0; j--) {
				if (m[i][j]==1) {
					right[i][j]=right[i][j+1]+1;
					down[i][j]=down[i+1][j]+1;
				}
			}
		}
	}
	public static boolean hasSizeOfBorder(int size,int[][] right,int[][] down) {
		//��(i,j)Ϊ���
		//right.length-size+1:��sizeΪ�߳����£����ϣ��ж��ٸ�λ����Ҫ����
		//right[0].length-size+1:��sizeΪ�߳����ң����ϣ��ж��ٸ�λ����Ҫ����
		for (int i = 0; i < right.length-size+1; i++) { 
			for (int j = 0; j < right[0].length-size+1; j++) {
				//����Ƿ���Թ���������
				if (right[i][j]>=size && down[i][j]>=size//���Ͻ�(i,j)λ�����Һ���������Ҫ��
					&& right[i+size-1][j]>=size //���½�(i+size-1,j)λ����������Ҫ��
					&& down[i][j+size-1]>=size)  //���Ͻ�(i,j+size-1)λ����������Ҫ��
				{
					return true;
				}
			}
		}
		return false;
	}
	public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
		int[][] res = new int[rowSize][colSize];
		for (int i = 0; i != rowSize; i++) {
			for (int j = 0; j != colSize; j++) {
				res[i][j] = (int) (Math.random() * 2);
			}
		}
		return res;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = generateRandom01Matrix(7, 8);
		printMatrix(matrix);
		System.out.println(getMaxSize(matrix));
	}

}
