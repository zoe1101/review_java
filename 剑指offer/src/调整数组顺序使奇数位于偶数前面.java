package src;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author zoe
 *
 */

public class 调整数组顺序使奇数位于偶数前面 {
	/**
	 * 复杂度：O(n^2)
	 * @param array
	 * @return
	 */

	//类似冒泡排序,前偶后奇就交换
	public static int[] reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++) {
        	for(int j=array.length-1;j>i;j--) { //从后往前交换，不然会出错
        		if(array[j]%2==1 && array[j-1]%2==0) { 
        			int tmp=array[j];
        			array[j]=array[j-1];
        			array[j-1]=tmp;
        		}
        	}
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        arr = reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
