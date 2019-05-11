package ͼ;
/*
��һ��С������� 1 �� N ����� N ���ˡ����Գƣ���Щ������һ����С���ϵ����ܷ��١�
���С��ķ�����Ĵ��ڣ���ô��
С��ķ��ٲ������κ��ˡ�
ÿ���ˣ�����С�򷨹��⣩������С��ķ��١�
ֻ��һ����ͬʱ�������� 1 ������ 2 ��
�������� trust�������������ζ� trust[i] = [a, b] ��ɣ���ʾ���Ϊ a �������α��Ϊ b ���ˡ�
���С��������ܷ��ٲ��ҿ���ȷ��������ݣ��뷵�ظ÷��ٵı�ǡ����򣬷��� -1��

���룺N = 3, trust = [[1,3],[2,3]]
�����3
 */

public class �ҵ�С��ķ��� {
    public static int findJudge(int N, int[][] trust) {
        int[][] degree=new int[N][2]; //��¼ÿ���˵���Ⱥͳ���
        for(int[] person:trust) {
        	int out=person[0]; //����
        	int in=person[1];  //���
        	degree[out-1][0]++;
        	degree[in-1][1]++;
        }
        for(int i=0;i<N;i++) {
        	if(degree[i][0]==0 && degree[i][1]==N-1) { //����Ϊ0�����ΪN-1�ľ��Ƿ���
        		return i+1;
        	}
        }
        return -1;
    }

	public static void main(String[] args) {

	}

}
