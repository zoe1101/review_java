package ����;

import org.omg.CORBA.portable.RemarshalException;

/*
 *����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ�
 *�����Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 */
//������˫ָ�뷨
//һ����¼remove������������һ��Ԫ��λ�ã�һ�����������������飬�ж��������ǱȽϸ�Ԫ�غ�target��ֵ��
//�������ȾͰ���copy����һ��pointer.
//�Ѷȣ�easy
/*
 ʱ�临�Ӷȣ�O(n)�� ��������ĳ����� n����ô i �� j �ֱ������� n ����
�ռ临�Ӷȣ�O(1)��
 */
public class ɾ�����������е��ظ��� {
	public static int removeDuplicates(int[] nums) {
		if(nums.length==0) return 0;
		int i=1; //���ڼ�¼remove������������һ��Ԫ��λ��
		for(int j=1;j<nums.length;j++) {
			if(nums[i-1]!=nums[j]) {
				nums[i]=nums[j];
				i++;
			}
		}
		return i;
    }

	public static void main(String[] args) {
		int[] nums= {1,2,2,3,3,4,4,5};
		System.out.println(removeDuplicates(nums));
	}

}
