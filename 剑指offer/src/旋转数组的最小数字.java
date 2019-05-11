package src;
/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 *  NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * @author zoe
 *
 */
public class ��ת�������С���� {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) {
        	return 0;
        }
        int left=0;
        int right=array.length-1;
    	if(left==right) {
    		return array[left];
    	}
    	while (left<right) {
			int mid=(left+right)/2;
			
			if(array[mid]>array[right]) { //3,4,5,1,2    ��С����һ����mid���ұ�
				left=mid+1;
			}else if (array[mid]<array[right]) {//1,2,3,4,5   ��С����һ����mid�����
				right=mid;
			}else { //array[mid]==array[right]  ���� [1,0,1,1,1] ����[1,1,1,0,1]
//				��ʱ��С���ֲ����ж���mid��� �����ұ�,��ʱֻ��һ��һ���� �� 
				right=right-1;
			}
		}
    	return array[left];
    }

}
