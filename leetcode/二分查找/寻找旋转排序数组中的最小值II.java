package ���ֲ���;
/*
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
���ҳ�������С��Ԫ�ء�
ע�������п��ܴ����ظ���Ԫ�ء�

����: [2,2,2,0,1]
���: 0
 */
public class Ѱ����ת���������е���СֵII {
public static int findMin(int[] nums) {
	int left=0,right=nums.length-1;
    if(nums[left]<nums[right] || nums.length == 1) { //ת���鱾����������
    	return nums[0];
    }
    while(left<right) {
    	int mid=(left+right)/2;
    	if(nums[mid]>nums[right]) {//��С�����Ҳ�  5 2
    		left=mid+1;
    	}else if(nums[mid]<nums[right]) {// 2 5
    		right=mid;
    	}else { //�����ظ�Ԫ�����ʱ ,  2 2
			right--;
		}
    }
    return nums[left];
    }
	public static void main(String[] args) {
	    int[] arr = {4,5,6,7,0,0,1,1,2};
	    System.out.println(findMin(arr));
	}

}
