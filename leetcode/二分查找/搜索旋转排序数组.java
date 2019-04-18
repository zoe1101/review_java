package ���ֲ���;

import javax.sound.midi.Track;

/*
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
����Լ��������в������ظ���Ԫ�ء�
����㷨ʱ�临�Ӷȱ����� O(log n) ����

����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
 */
public class ������ת�������� {
    public static int search(int[] nums, int target) {
    	int left=0,right=nums.length-1;
    	while(left<=right) {
    		int mid=left+(right-left)/2;
    		if(nums[mid]==target) {
    			return mid;
    		}
    		// 1 3 5
    		if(nums[mid]>=nums[left]){ //�������
    			if(target<nums[mid] && target>=nums[left]) { //Ŀ��ֵ�����
    				right=mid-1;
    			}else {//Ŀ��ֵ���Ҳ�
    				left=mid+1;
    			}
    		}else {//�Ҳ�����     //5 1 3
    			if(target>nums[mid] &&target<=nums[right]) {////Ŀ��ֵ���Ҳ�
    				left=mid+1;
    			}else {
    				right=mid-1;
    			}
    		}
    	}
    	return -1; 
    }

	public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));

	}

}
