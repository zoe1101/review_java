package ����;

//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
//����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
//
//ʾ����
//���� nums = [2, 7, 11, 15], target = 9
//��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//���Է��� [0, 1]
public class ����֮��_������ {
	public int[] twoSum(int[] nums, int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
	throw new IllegalArgumentException("No two sum solution");
}

private static void printArr(int[] nums){
    for(int num: nums)
        System.out.print(num + " "); //����������Ԫ��
    System.out.println();  //println("test")�൱��print("test\n")����һ�������ַ���, println �����Ĳ�����ʾ������ڣ����ڽ�β���ϻ��з����������궨λ����һ�еĿ�ʼ��
}

public static void main(String[] args) {
    int[] nums = {0, 4, 3, 0};
    int target = 3;
    printArr((new ����֮��_������()).twoSum(nums, target));
}
}