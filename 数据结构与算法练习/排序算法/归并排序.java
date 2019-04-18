package 排序算法;

import java.util.Scanner;

public class 归并排序 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Scanner stdinScanner = new Scanner(System.in);
		int n= stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		MergeSort(arr, 0, arr.length-1);
		printArray(arr);

	}
	
	// 打印所有数组元素
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println("");
	}
	public static void MergeSort(int[] arr,int left,int right) {
		if(left<right) {
			int mid=(left+right)/2;
			MergeSort(arr,left,mid);//左边归并排序，使得左子序列有序
			MergeSort(arr,mid+1,right);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right);//合并两个子序列
		}
	}
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//ps：也可以从开始就申请一个与原数组大小相同的数组，因为重复new数组会频繁申请内存
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid&&j<=right){
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[k++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[k++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }
    }

}
