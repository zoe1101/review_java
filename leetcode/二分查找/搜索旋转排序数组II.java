package ���ֲ���;

/*
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��
��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��


����: nums = [2,5,6,0,0,1,2], target = 0
���: true
 */
public class ������ת��������II {
    public static boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right) {
        	int mid=left+(right-left)/2;
        	if(nums[mid]==target) {
        		return true;
        	} 
        	 //3 3 3
        	if(nums[mid]==nums[left] && nums[mid]==nums[right]) {
        		++left;
        		--right;
        	}
        	//3 5 1   �������
        	else if(nums[mid]>=nums[left]){ 
        		if(target<nums[mid] & target>=nums[left]) {//Ŀ��ֵ�����
        			right=mid-1;
        		}else {
        			left=mid+1;
        		}
        	}
        	// 5 1 3 �Ҳ�����  
        	else{
        		if(target>nums[mid] && target<=nums[right]) {
        			left=mid+1; 
        		}
        		else { //Ŀ��ֵ�����
        			right=mid-1;
        		}
        	}
    	}
        return false;
    }
    
	public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(search(arr, 7));

	}
}
