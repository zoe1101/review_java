package �ݹ��붯̬�滮;
/*
����һ������m, �����Ͻǿ�ʼÿ��ֻ�����һ���������,��󵽴����½ǵ�λ��,·�������е������ۼ���������·����,
�������е�·������С��·����.
 */

//��̬�滮����
public class �������С·���� {
	public static int minPathSum1(int[][] m) {
		if(m==null || m.length==0 ||m[0]==null ||m[0].length==0) return 0;
		int row=m.length;
		int col=m[0].length;
		int[][] dp=new int[row][col];
		dp[0][0]=m[0][0];
		for(int i=1;i<row;i++) {
			dp[i][0]=dp[i-1][0]+m[i][0];
		}
		for(int j=1;j<col;j++) {
			dp[0][j]=dp[0][j-1]+m[0][j];
		}
//		O(row*col)
		for(int i=1;i<row;i++) { 
			for(int j=1;j<col;j++) {
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		}
		return dp[row-1][col-1];
	}
	
	public static int minPathSum2(int[][] m) {
		if(m==null || m.length==0 ||m[0]==null ||m[0].length==0) return 0;
		int row=m.length;
		int col=m[0].length;
		int more=Math.max(row,col); //�����������Ľϴ���
		int less=Math.min(row, col); //�����������Ľ�С��
		boolean rowmore=more==row; //�����Ƿ���ڵ�������
		int[] dp=new int[less];
		dp[0]=m[0][0];
		for(int i=1;i<less;i++) {
			dp[i]=dp[i-1]+(rowmore?m[0][i]:m[i][0]);
		}
		
		for(int i=1;i<more;i++) {
			dp[0]=dp[0]+(rowmore?m[i][0]:m[0][i]); //����һ��Ļ����Ͻ��и���
			for(int j=1;j<less;j++) {
				dp[i]=Math.min(dp[j-1], m[0][i])+(rowmore?m[i][j]:m[j][i]);
			}
		}
		return dp[less-1];
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
