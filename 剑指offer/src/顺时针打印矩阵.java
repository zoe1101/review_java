package src;

import java.util.ArrayList;

/*
����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡����磺����������¾��� 
1�� 2�� 3�� 4 
5�� 6�� 7�� 8 
9�� 10��11��12 
13��14��15��16 
�����δ�ӡ������1��2��3��4��8��12��16��15��14��13��9��5��6��7��11��10.
 */
//1.�������֣����ǿ���ͨ��ѭ����ÿһ�δ�ӡ�����е�һ��Ȧ�����⵽�ڣ��� 
//2.����������ѭ��������������������������������rows��������columns��
//��ӡ��һȦ�����Ͻǵ�������(0,0),�ڶ�Ȧ�����Ͻǵ�������(1,1),�������ơ�
//����ע�⵽�����Ͻǵ��������������������ͬ�ģ����ǿ����ھ�����ѡȡ���Ͻ�Ϊ(start,start)��һȦ��Ϊ���Ƿ�����Ŀ�ꡣ 
//3.�����ǣ�columns > startX �� 2 ���� rows > startY �� 2

public class ˳ʱ���ӡ���� {
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
	       ArrayList<Integer> list=new ArrayList<Integer>();
	       int rows=matrix.length;
	       int cols=matrix[0].length;
	       if(matrix==null ||cols<=0 ||rows<=0) {
	    	   return null;
	       }
	       int start=0;
	       while (rows>start*2 && cols>start*2 ) {
	    	   printMatrixInCircle(list,matrix,rows,cols,start);
	    	   start++;	
	       }
	       return list;
    }
	public static void printMatrixInCircle(ArrayList<Integer> list,int[][] matrix,
			int rows,int cols,int start) {
		int endY=cols-start-1;//�н���λ��
		int endX=rows-start-1; //�н���λ��
		
		for(int i=start;i<=endY;i++) { //�������Ҵ�ӡ����
			list.add(matrix[start][i]);
		}
		if(start<=endY)
			for(int i=start+1;i<=endX;i++) { //���ϵ��´�ӡ����
				list.add(matrix[i][endY]);
		}
		
		if(start<endX &&start<endY) {
			for(int i=endY-1;i>=start;i--) {//���������ӡ����
				list.add(matrix[endX][i]);
			}
		}
		if(start<endY && start<endX-1) {
			for(int i=endX-1;i>start;i--) {//�������ϴ�ӡ����
				list.add(matrix[i][start]);
			}
		}
	}
	
	public static void main(String[] args) {
	    int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; //���ж���
	    int[][] matrix2 = {{1,2,3,4}}; //���ж���
	    int[][] matrix3 = {{1},{5},{9}}; //���е���
	    int[][] matrix4 = {{1}}; //��Ԫ��
	    int[][] matrix5 = {{}}; //�վ���
	    int[][] matrix6 = null; //null
	    System.out.println(printMatrix(matrix1));
	    System.out.println(printMatrix(matrix2));
	    System.out.println(printMatrix(matrix3));

	}

}
