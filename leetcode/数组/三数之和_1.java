package ����;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ����֮��_1 {
    public int threeSum(int[] nums) {
    	int target=0;
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // �������ȥ�أ�ֱ���ҵ���Сֵ���ɡ�
        Arrays.sort(nums); // ��Ȼ��Ҫ������
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
    ����֮��_1 solution = new ����֮��_1();
    System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
}
}
