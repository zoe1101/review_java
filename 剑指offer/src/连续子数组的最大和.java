package src;
/**
 * �ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 * @author zoe
 *
 */
public class ��������������� {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0) {
        	return 0;
        }
        if(array.length==1) {
        	return array[0];
        }
        
        int currSum =0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
        	if(currSum<=0) {
        		currSum=array[i];
        	}else {
        		currSum+=array[i];
        	}
        	if(currSum>maxSum) {
        		maxSum=currSum;
        	}
        }
        return maxSum;
    }
}
