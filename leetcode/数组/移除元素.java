package ����;
/*
����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
//�Ѷȣ�easy
//������˫ָ��
public class �Ƴ�Ԫ�� {
	
	public static int removeElement(int[] nums, int val) {
		if(nums.length==0) {//������
			return 0;
		}
		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=val) {
				nums[i]=nums[j];
				i++;
			}
		}
        return i;
    }

	public static void main(String[] args) {
		int[] nums={3,2,2,3};
		int val=3;
		System.out.println(removeElement(nums,val));

	}

}
