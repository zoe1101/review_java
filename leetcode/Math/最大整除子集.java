package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
����һ�������ظ�����������ɵļ��ϣ��ҳ��������������Ӽ����Ӽ�������һ�� (Si��Sj) ��Ҫ���㣺
Si % Sj = 0 �� Sj % Si = 0��

����ж��Ŀ���Ӽ������������κ�һ�����ɡ�

ʾ�� 1:
����: [1,2,3]
���: [1,2] (��Ȼ, [1,3] Ҳ��ȷ)

ʾ�� 2:
����: [1,2,4,8]
���: [1,2,4,8]

 */
public class ��������Ӽ� {
	/*
�ȶ���������dp[i]��ʾnums[0 ... i]����������Ӽ��ĳ���
 ���ƹ�ϵʽ�� dp[i] = dp[j] + 1 , if nums[i] % nums[j] == 0;
 �߽���������ʼֵdp[i] = 1;(ÿ��������Ϳ��Թ���һ�����Ӽ�)
	 */
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	if (nums.length==0) {
    		return res;
		}
    	int[] dp = new int[nums.length];
    	Arrays.fill(dp, 1);
        Arrays.sort(nums); //����
        for(int i = 1 ; i < nums.length ; i ++){
            for(int j = i - 1 ; j >= 0 ; j --){
                if(nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int maxLen = dp[0];
        for(int i = 1; i < dp.length; i ++){
            maxLen = maxLen > dp[i] ? maxLen : dp[i];
        }

        /**
         	* ���ֵ�ڿ��ұߵ�λ�ã���˿��Դ�length - 1����ʼ����
         */
        for(int i = dp.length - 1 ; i >= 0 ; i --){
            if(maxLen == dp[i]){
                if(res.size() == 0){
                    res.add(nums[i]);
                    maxLen --;
                }else{
                    if(res.get(res.size() - 1) % nums[i] == 0){
                        res.add(nums[i]);
                        maxLen--;
                    }
                }
            }
        }
        Collections.reverse(res);
        return res;
    	
    }
}
