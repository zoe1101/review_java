package ����;

/*
����һ��δ������������飬�ҳ�����û�г��ֵ���С����������

����: [3,4,-1,1]
���: 2
 */
//ʱ�临�Ӷ�ӦΪO(n),����ֻ��ʹ�ó�������Ŀռ䡣
//�Ѷ�: hard
//������ĵ�i��λ��Ӧ�ô��ֵi + 1
//����һ������number�����ǽ����������nums�е�number - 1��λ��  [1,2,3,4,5,...]
public class ȱʧ�ĵ�һ������ {
	
    public static int firstMissingPositive(int[] nums) {
    	for(int i=0;i<nums.length;i++) {
    	   while(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]) {
    		   int temp=nums[i];
    		   nums[i]=nums[temp-1];
    		   nums[temp-1]= temp;
    	    }
    	}
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
    	return nums.length+1;
        
    }

	public static void main(String[] args) {
		int[] nums= {3,4,-1,1};
		System.out.print(firstMissingPositive(nums));
	}

}
