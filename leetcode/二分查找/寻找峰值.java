package ���ֲ���;

/*
��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�
����һ���������� nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������
������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�
����Լ��� nums[-1] = nums[n] = -�ޡ�

����: nums = [1,2,3,1]
���: 2
����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
 */
public class Ѱ�ҷ�ֵ {
    public static int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right) {
        	int mid=(left+right)/2;
        	if(nums[mid]<nums[mid+1]) { //mid�Ҳ���ڷ�ֵ
        		left=mid+1;
        	}else {
        		right=mid;
        	}
        }
        return right;
    }
	public static void main(String[] args) {
	    int[] arr = {1,2,3,1};
	    System.out.println(findPeakElement(arr));

	}

}
