package �������������;

import java.util.LinkedList;
import java.util.Queue;

//���ÿ�����ȱ���
public class �����ͨ·ֵ {
	public static int minPathValue(int[][] m) {
		if (m==null || m.length==0 || m[0].length==0 || m[0][0]!=1
			|| m[m.length-1][m[0].length-1]!=1) {
			return 0;
		}
		
		int row=m.length;
		int col=m[0].length;
		int[][] map=new int[row][col]; //map[i][i]:��(0,0)�ߵ�(i,j)�����·��
		map[0][0]=1;
		Queue<Integer> rowQueue=new LinkedList<Integer>(); //�洢�߹��ĺ�����
		Queue<Integer> colQueue=new LinkedList<Integer>(); //�洢�߹���������
		rowQueue.add(0);
		colQueue.add(0);
		int r=0;
		int c=0;
		while (!rowQueue.isEmpty()) {
			r=rowQueue.poll();
			c=colQueue.poll();
			if (r==row-1 && c==col-1) { //�������½�
				return map[r][c];
			}
			walkTo(map[r][c], r-1, c, m, map, rowQueue, colQueue); //������
			walkTo(map[r][c], r+1, c, m, map, rowQueue, colQueue); //������
			walkTo(map[r][c], r, c-1, m, map, rowQueue, colQueue); //������
			walkTo(map[r][c], r, c+1, m, map, rowQueue, colQueue); //������
		}
		return 0;
	}
	public static void walkTo(int pre,int toR,int toC,int[][] m,
			int[][] map,Queue<Integer> rQ,Queue<Integer> cQ) {
		if (toR<0 || toR==m.length ||toC<0 || toC==m[0].length
				|| m[toR][toC]!=1 || map[toR][toC]!=0) {
			return ;
		}
		map[toR][toC]=pre+1;
		rQ.add(toR);
		cQ.add(toC);
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1 } };
		System.out.println(minPathValue(matrix));

	}
}
