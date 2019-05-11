package src;
/*
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ���
 * �ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� 
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
 * ���ʸû������ܹ��ﵽ���ٸ����ӣ�
 */

//���ݷ�
/*
ʹ��һ�����������¼�Ƿ��Ѿ������ø��ӡ�
�����˴�(0,0)��ʼ�ƶ�������׼������(i,j)�ĸ���ʱ��ͨ������������λ���жϻ������Ƿ��ܹ����롣
����������ܽ���(i,j)�ĸ��ӣ��������ж����Ƿ��ܽ����ĸ����ڵĸ���(i,j-1),(i,j+1),(i-1,j),(i+1,j)��
 */
public class �����˵��˶���Χ {
    public int movingCount(int threshold, int rows, int cols)
    {
    	if (rows<=0 ||cols<=0 || threshold<0) {
			return 0;
		}
    	boolean[] visited=new boolean[rows*cols]; //��¼�����еĸ��ӵķ������
    	return MovingCount(threshold, rows, cols, 0, 0, visited);
    }
//    ���Ի�ĵ�Ԫ�����
    public static int MovingCount(int threshold, int rows, int cols,int i, int j,boolean[] visited) {
		int count=0;
		int index=i*cols+j;
		if (canWalkInto(threshold, rows, cols, i, j, visited)) {
			visited[index]=true;
			count=1+MovingCount(threshold, rows, cols, i-1, j, visited)
				   +MovingCount(threshold, rows, cols, i+1, j, visited)
				   +MovingCount(threshold, rows, cols, i, j-1, visited)
				   +MovingCount(threshold, rows, cols, i, j+1, visited);
		}
		return count;
	}
    //�жϵ�ǰλ���Ƿ�����
    public static boolean  canWalkInto(int threshold, int rows, int cols,int i, int j,boolean[] visited) {
    	int index=i*cols+j;
		if (i>=0 && i<rows && j>=0 && j<cols && getSumOfDigits(i)+getSumOfDigits(j)<=threshold && !visited[index]) {
			return true;
		}else {
			return false;
		}
	}
    //����һ�����ֵ���λ�ͣ�13->1+3=4
    public static int getSumOfDigits(int number){
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }

}
