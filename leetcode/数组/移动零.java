package ����;
/*
����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:

����: [0,1,0,3,12]
���: [1,3,12,0,0]

 */
public class �ƶ��� {
	//1
    public void moveZeroes(int[] nums) {
        if (nums==null || nums.length==0) {
        	return ;
		}
        int zeroNum=0;
        for (int num:nums) {
			if (num==0) {
				zeroNum++;
			}
		}
        int[] newnums=new int[nums.length+zeroNum];
        int index=nums.length+zeroNum-1;
        int index1=nums.length-1;
        for (int i = nums.length-1; i >=0 ; i--) {
			if (nums[i]==0) {
				newnums[index--]=nums[i];
			}else {
				newnums[index1--]=nums[i];
			}
		}
        for (int i = zeroNum; i < newnums.length; i++) {
			nums[i-zeroNum]=newnums[i];
		}
    }
    //2
    public void moveZeroes1(int[] nums) {
        if (nums==null || nums.length==0) {
        	return ;
		}
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
