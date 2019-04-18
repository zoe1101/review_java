package ����;

import java.util.HashMap;

//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
//����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
//
//�Ѷȣ�easy
//ʾ����
//���� nums = [2, 7, 11, 15], target = 9
//��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//���Է��� [0, 1]
public class ����֮�� {
	//������
	public int[] violence(int[] nums, int target) {
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	//�����ϣ��
    public int[] hash2(int[] nums, int target) {
    	HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); //����һ����������Ĺ�ϣ��
    	for(int i=0;i<nums.length;i++){
    		record.put(nums[i],i); //������ֵ�Ͷ�Ӧ���±����ڹ�ϣ���С�
    	}
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if (record.containsKey(complement) && record.get(complement)!=i) //�жϹ�ϣ���Ƿ���Ԫ��complement�����򷵻�true�����򷵻�false��
            {
                return new int[] {i,record.get(complement)};  //record.get(complement):��ȡ�ڹ�ϣ���м�ֵΪcomplement��Ӧ��ֵ����ԭ��������ֵ��Ӧ���±ꡣ
            }
        }
                
        throw new IllegalArgumentException("No two sum solution");
    }
    
  /// һ���ϣ��
  /// Time Complexity: O(n)
  /// Space Complexity: O(n)
    public int[] hash1(int[] nums, int target) {
    	HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); //����һ����������Ĺ�ϣ��
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if (record.containsKey(complement)) //�жϹ�ϣ���Ƿ���Ԫ��complement�����򷵻�true�����򷵻�false��
            {
                return new int[] {i,record.get(complement)};  //record.get(complement):��ȡ�ڹ�ϣ���м�ֵΪcomplement��Ӧ��ֵ����ԭ��������ֵ��Ӧ���±ꡣ
            }
            
            record.put(nums[i], i);      ////������ֵ�Ͷ�Ӧ���±����ڹ�ϣ���С�
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
	    printArr((new ����֮��()).hash1(nums, target));
	}
}