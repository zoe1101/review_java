package ̰���㷨;
/*
����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
�ж����Ƿ��ܹ��������һ��λ�á�

����: [2,3,1,1,4]
���: true
����: ��λ�� 0 �� 1 �� 1 ��, Ȼ���� 3 ���������һ��λ�á�
 */
public class ��Ծ��Ϸ {
    public static boolean canJump(int[] nums) {
        if(nums[0]==0){
        	if(nums.length==1) return true;
        	else if (nums.length>1) return false;
        }
        int n=nums.length;
        int temp=1;//��¼�������һ��Ԫ��, ��Ҫ��Ծ�Ĳ���
        for(int i=n-2;i>=0;i--) { //�Ӻ���ǰ����
        	if(nums[i]>=temp) { //���Ե��ﵱǰ�����һ��Ԫ�أ���ضϺ�ߵ�Ԫ�ء�
        		temp=1;
        		continue;
        	}else { //������ǰ
        		temp++;
        	}
        }
        //�����ʣ�µ�Ԫ�ش���1����������ж�Ϊ�١�
        return (temp==1)?true:false;
    }

	public static void main(String[] args) {
		int[] nums= {2,3,1,1,4};
		System.out.print(canJump(nums));

	}

}
