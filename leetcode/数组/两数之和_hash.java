package ����;
import java.util.HashMap;

/// One-Pass Hash Table
/// Time Complexity: O(n)
/// Space Complexity: O(n)

public class ����֮��_hash {
    public int[] twoSum(int[] nums, int target) {
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
    printArr((new ����֮��_hash()).twoSum(nums, target));
}
}