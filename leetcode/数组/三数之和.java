package ����;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣
ע�⣺���в����԰����ظ�����Ԫ��

����, �������� nums = [-1, 0, 1, 2, -1, -4]��
����Ҫ�����Ԫ�鼯��Ϊ��
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
//�Ѷȣ�meduim
class ����֮�� {
	//һ���ϣ��
    public int hash1(int[] nums) {
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
    //������
    public List<List<Integer>> violence(int[] nums) {
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
    ����֮�� solution = new ����֮��();
    System.out.println(solution.hash1(new int[]{-1, 0, 1, 2, -1, -4}));
}
}
