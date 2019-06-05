package ����;
import java.util.Arrays;

/**
����һ��δ������������飬�ҳ���������еĳ��ȡ�
Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)��

ʾ��:
����: [100, 4, 200, 1, 3, 2]
���: 4
����: ����������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
 * @author zoe
 *
 */
public class ��������� {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        Arrays.sort(nums);
        int max=1,count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                count++;
            }else if(nums[i]!=nums[i-1]){
                count=1;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
