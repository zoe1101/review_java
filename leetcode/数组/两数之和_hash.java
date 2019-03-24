package 数组;
import java.util.HashMap;

/// One-Pass Hash Table
/// Time Complexity: O(n)
/// Space Complexity: O(n)

public class 两数之和_hash {
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> record = new HashMap<Integer, Integer>(); //定义一个存放整数的哈希表
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if (record.containsKey(complement)) //判断哈希表是否含有元素complement，有则返回true，否则返回false。
            {
                return new int[] {i,record.get(complement)};  //record.get(complement):获取在哈希表中键值为complement对应的值，即原来数组中值对应的下标。
            }
            
            record.put(nums[i], i);      ////将数组值和对应的下标存放于哈希表中。
        }
        throw new IllegalArgumentException("No two sum solution");
    }

private static void printArr(int[] nums){
    for(int num: nums)
        System.out.print(num + " "); //逐个输出数组元素
    System.out.println();  //println("test")相当于print("test\n")就是一般的输出字符串, println 将它的参数显示在命令窗口，并在结尾加上换行符，将输出光标定位在下一行的开始。
}

public static void main(String[] args) {
    int[] nums = {0, 4, 3, 0};
    int target = 3;
    printArr((new 两数之和_hash()).twoSum(nums, target));
}
}