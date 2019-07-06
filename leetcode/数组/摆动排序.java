package ����;

import java.util.Arrays;

/*
����һ��û����������飬�뽫ԭ����͵��������������������� 
nums[0] <= nums[1] >= nums[2] <= nums[3]��.

����
��������Ϊ nums = [3, 5, 2, 1, 6, 4] һ���������Ϊ [1, 6, 2, 5, 3, 4]

 */
public class �ڶ����� {
	/*
	 * �ȴ�С���������ڽ���Ԫ�ؽ��棬
	 * ��ÿ�ΰѵ��������͵ڶ�����������λ�ã���������͵��ĸ���������λ�ã��Դ�����ֱ������ĩβ
	 */
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		if (nums.length<2) {
			return ;
		}
		for (int i = 2; i < nums.length; i+=2) {
			swap(nums,i-1,i);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
