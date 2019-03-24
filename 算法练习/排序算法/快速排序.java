package 排序算法;

import java.util.Scanner;
// 指针交换法
public class 快速排序 {
	public static void main(String[] args) {
		
		Scanner stdinScanner = new Scanner(System.in);
		int n= stdinScanner.nextInt();//输入元素个数
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
//		printArray(arr);
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
	public static void QuickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
 
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
         arr[low] = arr[i];
         arr[i] = temp;
        //递归调用左半数组
        QuickSort(arr, low, j-1);
        //递归调用右半数组
        QuickSort(arr, j+1, high);
    }

  
}
