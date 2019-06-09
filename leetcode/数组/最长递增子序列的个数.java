package ����;

import java.util.Arrays;

/*
����һ��δ������������飬�ҵ�����������еĸ�����

ʾ�� 1:

����: [1,3,5,4,7]
���: 2
����: ����������������У��ֱ��� [1, 3, 4, 7] ��[1, 3, 5, 7]��
ʾ�� 2:

����: [2,2,2,2,2]
���: 5
����: ����������еĳ�����1�����Ҵ���5�������еĳ���Ϊ1��������5��

 */
public class ����������еĸ��� {
    public int findNumberOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
			return 0;
		} 
        int[] dp=new int[nums.length]; // ��¼�Ե�i��Ԫ�ؽ�β��LIS
        int[] combination = new int[nums.length];//��¼�Ե�i��Ԫ�ؽ�βLIS������
        Arrays.fill(dp, 1);
        Arrays.fill(combination, 1);
        int max=1;
        int res=0;
        for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j <i; j++) {
				if (nums[i]>nums[j]) {//���jλ����ֵ��iλС����ɼ���iλ��LIS�Ƚ϶���
					if (dp[j]+1 > dp[i]) {//���+1���ڵ�ǰLIS �����������
						dp[i]=dp[j]+1;
						combination[i]=combination[j];
					}else if (dp[j]+1 == dp[i]) {//���+1���ڵ�ǰLIS ��˵���ҵ��������
						combination[i] += combination[j];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
        for (int i = 0; i < nums.length; i++)
            if (dp[i] == max) res += combination[i];

        return res;
    }
    
}
