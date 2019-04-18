package ����;
/*
 ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 ����: [-2,1,-3,4,-1,2,1,-5,4],
���: 6
����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 */
public class �������� {
	
	public static int maxSubArray(int[] nums) {
        int cursum=0;
        int res=nums[0];
        for(int i=0;i<nums.length;i++) {
        	if(cursum>0) {
        		cursum+=nums[i];
        	}else {
        		cursum=nums[i];
        	}
        	res=Math.max(cursum, res);
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

}
