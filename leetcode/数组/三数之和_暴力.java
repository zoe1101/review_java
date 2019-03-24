//medium-015

package ����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ����֮��_���� {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int len=nums.length;
		if (len<3) {
			System.out.println("���鳤��С��3");
			return result;
			} //���鳤��С��3
			
		Arrays.sort(nums);  // �ȶ������������Ȼ������˫ָ���������֮�͡�O(n*n)
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) break;
			if(i>0 && nums[i]==nums[i-1]) continue; // �Ե�һ��Ԫ��ȥ��(ȥ�ص�Ŀ���Ƿ�ֹ�����ظ���Ԫ����.)
			int j=nums.length-1;
			int target=0-nums[i];
			int k=i+1;
			while(k<j)
				if(nums[k]+nums[j]==target) {
					List<Integer> item=Arrays.asList(nums[i],nums[k],nums[j]);
					result.add(item);
					while(k<j && nums[k]==nums[k+1]) k++; // �Եڶ���Ԫ��ȥ�ش���
					while(k<j && nums[j]==nums[j-1]) j--;
					k++;j--;
						}
				else if (nums[k]+nums[j]<target)
					k++;
				else
					j--;
		}
		return result;
	}
   public static void main(String[] args) {
        ����֮��_���� solution = new ����֮��_����();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}


