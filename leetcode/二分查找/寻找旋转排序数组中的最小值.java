package ���ֲ���;
/*
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
���ҳ�������С��Ԫ�ء�
����Լ��������в������ظ�Ԫ�ء�

����: [3,4,5,1,2]
���: 1
 */
public class Ѱ����ת���������е���Сֵ {
    public static int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        if(nums[left]<nums[right] || nums.length == 1) { //ת���鱾����������
        	return nums[0];
        }
        while (left<right) {
        	int mid=left+(right-left)/2;
        	if(nums[mid]>nums[right]) { //��Сֵ���Ҳ�  4 7 3
        		left=mid+1;
        	}else {
        		right=mid;//��������Ϊ�˱��������nums[mid]���Ԫ��
        	}
		}
        return nums[left];
    }
    
	public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));

	}
}
