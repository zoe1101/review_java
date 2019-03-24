package 数组;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 三数之和_1 {
    public int threeSum(int[] nums) {
    	int target=0;
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 这个不用去重，直接找到最小值即可。
        Arrays.sort(nums); // 仍然需要先排序
        int minSum = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int curSum = nums[k] + nums[i] + nums[j];
                if (Math.abs(curSum - target) < Math.abs(minSum - target)) {
                    minSum = curSum;
                }
                if (curSum > target) {
                    j--;
                }else if (curSum == target) {
                    return curSum;
                }else{
                    i++;
                }
            }
        }
        return minSum;
    }
public static void main(String[] args) {
    三数之和_1 solution = new 三数之和_1();
    System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
}
}
