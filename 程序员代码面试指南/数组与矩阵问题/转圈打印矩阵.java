package �������������;

public class תȦ��ӡ���� {
	public static void solution(int[][] matrix) {
		int tr=0,tc=0; //����ָ�����Ͻ�(tr,tc)
		int dr=matrix.length-1,dc=matrix[0].length-1; //����ָ�����½�(dr,dc)
		while (tr<=dr && tc<=dc) {
			printEdge(matrix, tr++, tc++, dr--, dc--);
		}
	}
	
	public static void printEdge(int[][] matrix,int tr,int tc,int dr,int dc) {
		if(tr==dr) {//����ֻ��һ��
			for(int i=tc;i<=dc;i++) {
				System.out.print(matrix[tr][i]+" ");
			}
		}else if(tc==dc) { //����ֻ��һ��
			for(int i=tr;i<=dr;i++) {
				System.out.print(matrix[i][tc]+" ");
			}
		}else {//һ�����
			for(int i=tc;i<dc;i++) { //��ӡ����
				System.out.print(matrix[tr][i]+" ");
			}
			
			for(int i=tr;i<dr;i++) { //��ӡ����
				System.out.print(matrix[i][dc]+" ");
			}
			
			for(int i=dc;i>tc;i--) { //��ӡ����
				System.out.print(matrix[dr][i]+" ");
			}
			
			for(int i=dr;i>tr;i--) { //��ӡ����
				System.out.print(matrix[i][tc]+" ");
			}
		}
	}
		

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		solution(matrix);
	}
}
