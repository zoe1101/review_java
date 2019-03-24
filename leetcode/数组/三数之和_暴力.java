//medium-015

package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和_暴力 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int len=nums.length;
		if (len<3) {
			System.out.println("数组长度小于3");
			return result;
			} //数组长度小于3
			
		Arrays.sort(nums);  // 先对数组进行排序，然后利用双指针进行两数之和。O(n*n)
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) break;
			if(i>0 && nums[i]==nums[i-1]) continue; // 对第一层元素去重(去重的目的是防止出现重复三元组结果.)
			int j=nums.length-1;
			int target=0-nums[i];
			int k=i+1;
			while(k<j)
				if(nums[k]+nums[j]==target) {
					List<Integer> item=Arrays.asList(nums[i],nums[k],nums[j]);
					result.add(item);
					while(k<j && nums[k]==nums[k+1]) k++; // 对第二层元素去重处理
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
        三数之和_暴力 solution = new 三数之和_暴力();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}


