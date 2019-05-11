package src;
/*
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� 
 * ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 * 
 *  a b c e 
 *  s f c s 
 *  a d e e 
 */
public class �����е�·�� {
	//��Ҫһ�����������¼
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {   if(matrix==null || matrix.length==0 || str==null || str.length==0 || 
    	   matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
        	return false ;
    	}
    	boolean[] flag=new boolean[matrix.length];
    	int len=0;
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, rows, cols, str, i, j, flag, len)) {
					return true;
				}
			}
		}
    	return false;
    }
    
    public static boolean  hasPathCore(char[] matrix, int rows, int cols, char[] str,
    								   int i, int j, boolean[] visited, int len) {
    	boolean flag=false;

        int index = i * cols + j;
    	if (i>=0 && i<rows && j>=0 && j<cols && !visited[index] && matrix[index]==str[len]) {
			len++;
			visited[index]=true;
			if (len==str.length) {
				return true;
			}
			flag=hasPathCore(matrix, rows, cols, str, i-1, j, visited, len)||  //����
				 hasPathCore(matrix, rows, cols, str, i+1, j, visited, len)||  //����
				 hasPathCore(matrix, rows, cols, str, i, j-1, visited, len) || //����
				 hasPathCore(matrix, rows, cols, str, i, j+1, visited, len);   //����
			if (!flag) { //����Ե�ǰ·���߲�ͨ������ݵ�ǰһ��λ�ý������ߣ�ͬʱ��ǵ�ǰλ���Ѿ��߹���
				len--;
				visited[index]=false;
			}
    	}
		return flag;
	}
}
