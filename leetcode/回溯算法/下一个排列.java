package �����㷨;
/*
ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
�����������һ����������У��������������г���С�����У����������У���
����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1

 */
public class ��һ������ {
	//�Ӻ���������飬�ҳ��Ҳ�ȵ�ǰ�ڵ������ݣ��������ǣ�������ǰ�ڵ��Ҳ�����
    public void nextPermutation(int[] nums) {
    	boolean ifreverse = false;
		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (ifreverse)
				break;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					k = i;
					ifreverse = true;
					break;
				}
			}
		}

		if (!ifreverse) {
			for (int i = 0; i < nums.length/2; i++) {
				int temp = nums[i];
				nums[i] = nums[nums.length-1-i];
				nums[nums.length-1-i] = temp;
			}
		} else {
			// ��k�����������
			for (int i = k + 1; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] > nums[j]) {
						int tmp = nums[i];
						nums[i] = nums[j];
						nums[j] = tmp;
					}
				}
			}
		}
    }
}
