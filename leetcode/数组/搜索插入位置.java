package ����;
/*
����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�

����: [1,3,5,6], 2
���: 1
 */

public class ��������λ�� {
	
	public static int searchInsert(int[] nums, int target) {
		int i=0;  //����˳������λ��
		for(int j=0;j<nums.length;j++) {
			if(nums[i]>=target) {//һ����ǰԪ�ز���С��Ŀ��ֵ �ͷ��ص�ǰԪ�ص��±�
				break;
			}
			i++;
		}
		return i;
	}
	
	//���ַ�  ��ʱ!!!!
	public static int searchInsert1(int[] nums, int target) {
		if(nums.length==0) {
			return 0;
		}
		int low=0;
		int high=nums.length;
        while (low<high) {
        	int mid=(high-low)/2;
        	if(nums[mid]>target) {//��ǰ�벿��
        		high=mid;
        	}else if(nums[mid]<target) {//�ں�벿��
        		low=mid;
        	}else //�м�ֵ����Ŀ��ֵ
        		return mid;
		}
        return low;
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
