package ����;
/*
����һ��δ��������������飬�ҵ���������ĵĵ������С�

ʾ�� 1:

����: [1,3,5,4,7]
���: 3
����: ��������������� [1,3,5], ����Ϊ3��
���� [1,3,5,7] Ҳ�������������, �������������ģ���Ϊ5��7��ԭ�����ﱻ4������ 

 */
public class ������������� {
    public int findLengthOfLCIS(int[] nums) {
    	if (nums==null ||nums.length==0) {
			return 0;
		}
    	int cur=1;
    	int res=1;
        for (int i = 1; i < nums.length; i++) {
			if (nums[i]>nums[i-1]) {
				cur++;
				res=Math.max(cur, res);
			}else {
				cur=1;
			}
		}
        return res;
    }
}
