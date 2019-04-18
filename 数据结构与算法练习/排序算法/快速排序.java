package 排序算法;

import java.util.Scanner;

import javax.net.ssl.StandardConstants;
// 指针交换法
public class 快速排序 {
	public static void main(String[] args) {
		int[] arr=new int[] {1,3,4,3,5,8,7,4,1};
		QuickSort(arr, 0, arr.length-1);
		printArray(arr);

	}
	
	// 打印所有数组元素
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println("");
	}
	public static void QuickSort(int[] arr,int strat,int end){
        int low,high,standard;
        if(strat<end) {
	        //记录排序的下标
	        low=strat;
	        high=end;
	      
	        standard = arr[strat]; //基准元素
	 
	        while (low<high) {
	            //先看右边，依次往左递减
	            while (standard<=arr[high]&&low<high) {
	                high--;
	            }
	            arr[low]=arr[high];//将右边的数赋给左边
	            //再看左边，依次往右递增
	            while (standard>=arr[low]&&low<high) {
	                low++;
	            }
	            
	            arr[high]=arr[low];//将左边的数赋给右边
	 
	        }
	         arr[low]=standard; //把基准元素赋给低所在的元素
	        //处理所有小于基准的数字
	        QuickSort(arr, strat, high);
	        //处理所有大于基准的数字
	        QuickSort(arr, high+1, end);
        }
    }

  
}
