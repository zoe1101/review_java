package ����;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
����һ�� m x n �ľ������е�ֵ��Ϊ�������������ά�߶�ͼÿ����Ԫ�ĸ߶ȣ�
�����ͼ����״����ܽӶ����������ˮ��

˵��:
m �� n ����С��110��������ÿһ����λ�ĸ߶ȶ�����0 ��С�� 20000��

�������� 3x6 �ĸ߶�ͼ:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

���� 4��
 */
public class ����ˮII {
	public class Node{
        int x; //x������
        int y; //y������
        int h; //�߶�
        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
	/*
	 ÿ��Ӧ����ѡȡ�߽���С�ĸ߶ȣ����������ȶ�����������Χ�߽磨С���ѣ���
	 �����Ƿ��ʹ���һ����֮��Ҫ�����������ڲ���������������Ҫ����һ�����λ�ã�
	Ϊ�˷�ֹ�ٴη����Ѿ����ʹ��ĵ㻹��Ҫ��һ�����������ÿ����ķ���״̬��
	*/
    public int trapRainWater(int[][] heightMap) {
    	if (heightMap.length<3|| heightMap[0].length<3) {
			return 0;
		}
    	PriorityQueue<Node> queue=new PriorityQueue<Node>(new Comparator<Node>() {
    		@Override
    		public int compare(Node o1,Node o2) {
				return o1.h-o2.h;
			}
		});
    	int row=heightMap.length;
    	int col=heightMap[0].length;
    	int[][] visited = new int[row][col];
//    	����������еı�ԵԪ�ذ���Ԫ�ش�С�������ȼ������У���x���꣬y���꣬�߶ȣ�
		 for (int i = 0; i < row; i++) {
			 queue.offer(new Node(i, 0,heightMap[i][0]));
			 visited[i][0]=1;
			 queue.offer(new Node(i, col-1, heightMap[i][col-1]));
			 visited[i][col-1]=1; //�����ʹ���Ԫ�ر��
		 }
	   	 for (int j = 1; j < col; j++) {
    		 queue.offer(new Node(0, j,heightMap[0][j]));
    		 visited[0][j]=1;
    		 queue.offer(new Node(row-1, j, heightMap[row-1][j]));
    		 visited[row-1][j]=1;
    	 }
	   	 //�������
	   	 /*
	   	  {1,0} :����
	   	  {0,-1}:����
	   	  {0,1}:����
	   	  {-1,0}:����
	   	  */
	   	final int[][] dir = {{1,0},{0,-1},{0,1},{-1,0} };
	   	int res = 0; //��ˮ��
	   	while (!queue.isEmpty()) {
			Node curNode=queue.poll();
			int x=curNode.x;
			int y=curNode.y;
			int h=curNode.h;
			//������Χ��Ԫ�أ����й������
			for (int[] ints:dir) {
				int dx = x + ints[0];
                int dy = y + ints[1];
                if(dx <0 ||dx >= row || dy<0||dy>=col || visited[dx][dy]==1)
                    continue;
                //����Ա��б������͵Ļ��͵Ļ�ľ����ô����ǰλ���ܻ�ˮ
                if(h> heightMap[dx][dy]){
                    res+=h-heightMap[dx][dy];
                    heightMap[dx][dy] = h ;
                }
              
                queue.add(new Node(dx,dy,heightMap[dx][dy]));//������һ����ľ ���������������
                visited[dx][dy] =1;//���
			}
		}
	   	return res;
    }
}
