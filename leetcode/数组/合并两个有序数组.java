package ����;

/*
�������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
 */
//�Ѷȣ�easy
/*
˵��:
��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
ʾ��:
����:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

���: [1,2,2,3,5,6]
 */

//�����A��B���ܳ���,���������к����Ԫ���ǿյ�,���ԴӺ���ǰ���ƣ�
//ʱ�临�Ӷ���O(M+N)
//�ռ临�Ӷ���O(1)
public class �ϲ������������� {
	//�鲢�����merge����
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1;
		int j=n-1;
		int index=m+n-1;
		//��β����ʼ����������Ḳ�� nums1 ��ֵ��
	    while (i>=0||j>=0) {
	    	 //ǰ�����ж�Ҫ����ǰ�棬��ֹ��ָ���쳣
			if(i<0) {//˵��nums1�Ѿ��������
				nums1[index--]=nums2[j--];//��nums2��䵽nums1֮��
				continue;
			}else if(j<0){//nums2�Ѿ�ȫ����䵽��nums1,ֱ������ѭ��������
				break;
			}
			//��������䵽�����index
			if(nums1[i]>nums2[j]) {//��ӦԪ�ؽ���
				nums1[index--]=nums1[i--];
			}else {
				nums1[index--]=nums2[j--];
			}
	    }
	     
	 }

	public static void main(String[] args) {
//		

	}

}
