package src;
/*
��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�����������
 */

//����˼·: �����Ͻǿ�ʼ����
public class ��ά�����еĲ��� {
    public static boolean Find(int target, int [][] array) {
    	if(array.length==0 || array[0].length==0 || array==null) {
    		return false;
    	}
    	int m=0,n=array[0].length-1;
    	while(m<array.length && n>=0) {
    		if(array[m][n]==target) { //���Ͻ�Ԫ�ص���Ŀ��ֵ
    			return true;
    		}else if(array[m][n]>target) { //���Ͻ�>key,ɾ��һ�У������
    			n--; 
    		}else { //ɾ��������У����������
    			m++;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
	    int[][] arr= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
	    System.out.println(Find(7,arr));

	}
    
}
