package ����;

import java.util.Arrays;

/*
����һ���������飬���������ҳ�����������ɵ����˻������������˻���

����: [1,2,3,4]
���: 24
 */
//����˼·���ȴ�С�����������˻���nums[0]*nums[1]*nums[n-1]��nums[n-3]*nums[n-2]*nums[n-1]��ȡ�ϴ��ߡ�
public class �����������˻� {
	public static int maximumProduct(int[] nums) {
		int n=nums.length;
        if(n<3) {
        	return 0;
        }
        if(n==3) {
        	return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        return (Math.max(nums[0]*nums[1]*nums[n-1],nums[n-3]*nums[n-2]*nums[n-1]));
    }
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		System.out.println(maximumProduct(nums));

	}

}
