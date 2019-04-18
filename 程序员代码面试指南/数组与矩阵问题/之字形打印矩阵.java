package �������������;

public class ֮���δ�ӡ���� {
	public static void solution(int[][] matrix) {
		int tr=0,tc=0,dr=0,dc=0;
		int endr=matrix.length-1;
		int endc=matrix[0].length-1;
		boolean fromUp=false;  //�Ƿ��Ǵ�����������,�����ж���ӡ����
		while (tr<=endr) {
			printLevel(matrix, tr, tc, dr, dc, fromUp);
			tr=tc==endc?tr+1:tr; //
			tc=tc==endc?tc:tc+1;
			dc=dr==endr?dc+1:dc;
			dr=dr==endr?dr:dr+1;
			fromUp=!fromUp;
		}
		System.out.println();
		
	}
	public static void printLevel(int[][] matrix,int tr,int tc,int dr,int dc,boolean fromUp) {
		if(fromUp) {//�����������·����ӡ
			while(tr<=dr) {
				System.out.print(matrix[tr++][tc--]+" ");
			}
		}else {//�����������Ϸ����ӡ
			while(dr>=tr) {
				System.out.print(matrix[dr--][dc++]+" ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		solution(matrix);

	}

}
