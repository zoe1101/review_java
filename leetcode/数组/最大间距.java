package ����;

import java.util.Arrays;

/*
����һ����������飬�ҳ�����������֮������Ԫ��֮�����Ĳ�ֵ��
�������Ԫ�ظ���С�� 2���򷵻� 0��


����: [3,6,9,1]
���: 3
����: ������������ [1,3,6,9], ��������Ԫ�� (3,6) �� (6,9) ֮�䶼��������ֵ 3��

����Լ�������������Ԫ�ض��ǷǸ�����������ֵ�� 32 λ�з���������Χ�ڡ�
�볢��������ʱ�临�ӶȺͿռ临�Ӷȵ������½�������⡣
 */
public class ����� {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if (nums.length<2) {
			return 0;
		}
        int max=0;
        for (int i = 1; i < nums.length; i++) {
			if (nums[i]-nums[i-1]>max) {
				max=nums[i]-nums[i-1];
			}
		}
        return max;
    }
}
