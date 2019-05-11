package src;

import java.util.HashMap;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ����:
 * ����һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * @author zoe
 *
 */
public class �����г��ִ�������һ������� {
	/**
	 * �������飬��¼���������ֵ�ֵ�ͳ��ֵĴ���������һ�����ֺͼ�¼��ֵһ�£��������1�����������1��
	 * һ��������Ϊ0���򱣴���һ�����֣�ͬʱ��������Ϊ1��
	 * �������Ҫ�ҵ����ֿ϶������һ�ν�������Ϊ1��Ӧ���Ǹ����֣�ʱ�临�Ӷ�ΪO(n)
	 * @param array
	 * @return
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null ||array.length==0) {
        	return 0;
        }
        int result = array[0];
        int count=1;
        for(int i=1;i<array.length;i++) {
        	if(count==0) {
        		result=array[i];
        		count=1;
        	}else if(array[i]==result) {
				count++;
			}else {
				count--;
			}
        }
        if(checkMoreThanHalf(array,result))
            return result;
        else
            return 0;
    }  
    
    //�ж��Ƿ������е������г���������
	public static boolean checkMoreThanHalf(int[] array,int result){
	    boolean flag = false;
	    int number = 0;
	    for(int i = 0;i<array.length;i++){
	        if(array[i]==result)
	            number++;
	        else
	            continue;
	    }
	    if(number*2>array.length)
	        flag = true;
	    return flag;
	}

}
