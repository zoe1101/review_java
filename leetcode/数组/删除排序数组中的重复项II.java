package ����;

import javax.swing.plaf.SliderUI;

import ��̬�滮.multi_backpack;

/*
 ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ�
 �����Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 */
//�Ѷȣ�meduim
public class ɾ�����������е��ظ���II {
	public static int removeDuplicates(int[] nums) {
		if(nums.length==0) return 0;
		int i=1; //��¼remove������������һ��Ԫ��λ��
		int count=0;//��¼�ظ�����
		for(int j=1;j<nums.length;j++) { //������������
			if(nums[i-1]==nums[j]) {
				count++;
				if(count>=2) continue;
			}else {
				count=0;
			}
			nums[i]=nums[j];
			i++;
		}
		return i;
	    }

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(nums));
	}

}
