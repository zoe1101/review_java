package ̰���㷨;
/*
����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�

����: [2,3,1,1,4]
���: 2
����: �������һ��λ�õ���С��Ծ���� 2��
           ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
 */
public class ��Ծ��ϷII {
    public static int jump(int[] nums) {
    	if(nums.length<=1) {
    		return 0;
    	}
    	int cur_reach=0;//��ǰ����λ��
    	int nextreach=nums[0]; //��һ�κ󵽴��λ��
    	int step=0; //��Ծ����
    	for(int i=0;i<nums.length;i++) {
    		nextreach=Math.max(nextreach, i+nums[i]);
    		if(nextreach>=nums.length-1) return step+1;
    		if(i==cur_reach) { //�ϴ���Ծ�󵽴��λ�ã�����ǰ����λ��
    			step++;
    			cur_reach=nextreach;
    		}	
    	}
    	return step;
        
    }

	public static void main(String[] args) {
		int[] nums= {2,3,1,1,4};
		System.out.print(jump(nums));

	}

}
