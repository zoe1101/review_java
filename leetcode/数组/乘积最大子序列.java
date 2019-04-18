package ����;

import javax.xml.crypto.Data;

/*
����һ���������� nums ���ҳ�һ�������г˻��������������У����������ٰ���һ��������

����: [2,3,-2,4]
���: 6
����: ������ [2,3] �����˻� 6��
 */
//�˻�������������Ҳ�и�����0����ȻֻҪ��һ�������������ڸ����Ĵ��ڣ�������¼���˻���ҲҪ��¼��С�˻���
//����˼�룺��̬�滮
public class �˻���������� {
	public static int maxProduct(int[] nums) {
		if(nums.length==0||nums==null) {
			return 0;
		}
		int max;
		int[] maxend=new int[nums.length] ; //��¼���˻�
		int[] minend=new int[nums.length] ; //��¼��С�˻�
		maxend[0]=nums[0];
		minend[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
        	maxend[i]=Math.max(Math.max(maxend[i-1]*nums[i],minend[i-1]*nums[i]),nums[i]);
        	minend[i]=Math.min(Math.min(maxend[i-1]*nums[i],minend[i-1]*nums[i]),nums[i]);
        }
        max=maxend[0];
        for(int i=0;i<nums.length;i++){
        	if(maxend[i]>max) {
        		max=maxend[i];
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		int[] nums= {2,3,-2,4};
		System.out.println(maxProduct(nums));

	}

}
