package �����㷨;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����

˵�����⼯���ܰ����ظ����Ӽ���

ʾ��:

����: [1,2,2]
���:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class �Ӽ�II {
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        reback(nums, result, new ArrayList<>(), 0);
        return result;
	 }

    // �����㷨
    public static void reback(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        if (start == nums.length + 1) {
            return;
        }
        result.add(new ArrayList<>(temp));
        int lastUsed = Integer.MIN_VALUE;
        for (int i = start, length = nums.length; i < length; i++) {
            if (nums[i] != lastUsed) {
                temp.add(nums[i]);
                reback(nums, result, temp, i + 1);
                temp.remove(temp.size() - 1);
                lastUsed = nums[i];
            }
        }
    }
}
