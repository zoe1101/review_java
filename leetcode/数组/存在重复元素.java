package ����;

import java.util.HashSet;

/*
����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
����κ�ֵ�������г����������Σ��������� true�����������ÿ��Ԫ�ض�����ͬ���򷵻� false��


����: [1,2,3,1]
���: true

 */
public class �����ظ�Ԫ�� {
    public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length<2) {
			return false;
		}
        HashSet<Integer> set =new HashSet<Integer>();
        for (int num:nums) {
			if (set.contains(num)) {
				return true;
			}else {
				set.add(num);
			}
		}
        return false;
    }
}
