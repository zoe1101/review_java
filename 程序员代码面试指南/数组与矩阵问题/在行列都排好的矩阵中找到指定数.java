package �������������;

public class �����ж��źõľ������ҵ�ָ���� {
	//������������Ҳ����
	public static boolean isContains(int[][] matrix,int k) {
		//�����Ͻǿ�ʼ����
		int row=0;
		int col=matrix[0].length-1;
		while (row<matrix.length && col>=0) {
			if (matrix[row][col]==k) { //�ҵ���
				return true;
			}else if (matrix[row][col]>k) { //��matrix[row][col]��ǰһ�м�����
				col--;
			}else { //k����matrix[row][col]����matrix[row][col]����һ�м�����
				row++;
			}
		}
		return false;
	}

}
