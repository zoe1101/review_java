package ����;
/*
����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
����㷨ʱ�临�Ӷȱ����� O(log n) ����
��������в�����Ŀ��ֵ������ [-1, -1]��

ʾ�� 1:
����: nums = [5,7,7,8,8,10], target = 8
���: [3,4]

ʾ�� 2:
����: nums = [5,7,7,8,8,10], target = 6
���: [-1,-1]
 */
public class �����������в���Ԫ�صĵ�һ�������һ��λ�� {
    public int[] searchRange(int[] nums, int target) {
    	if (nums==null || nums.length==0 || target<nums[0]) {
			return new int[]{-1,-1};
		}
    	int left=0;
    	int right=nums.length-1;
    	int flag = Integer.MIN_VALUE;
    	while (left<=right) {
			int mid=(left+right)>>1;
	    	if (nums[mid]>target) { //�����
				right=mid-1;
			}else if (nums[mid]<target) {//���ұ�
				left=mid+1;
			}else {
				flag=mid;
				break;
			}
		}
    	if (flag==Integer.MIN_VALUE) {//flagû��ˢ�£�֤��������target
    		return new int[]{-1,-1};
		}
    	int i=flag;
    	int j=flag;
    	for (; i>=0; i--) {
			if (nums[i]!=target) {
				break;
			}
		}
    	for (; j<nums.length; j++) {
			if (nums[j]!=target) {
				break;
			}
		}
    	return new int[] {i+1,j-1};
        
    }
}
