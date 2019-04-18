package 排序算法;

import java.util.Scanner;

//N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数。
public class 冒泡排序 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner stdinScanner=new Scanner(System.in);
		int n=stdinScanner.nextInt();
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
		printArray(arr);
		for(int i=0;i<arr.length-1;i++) { //外层循环控制排序趟数
			for(int j=0;j<arr.length-i-1;j++) {  //内层循环控制每一趟排序多少次
				// 把小的值交换到前面
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			 System.out.print("第"+(i+1)+"次排序结果：");//列举每次排序的数据
			 printArray(arr);
		}
		System.out.println("最终排序结果：");
		printArray(arr);

	}
	

	// 打印所有数组元素
		public static void printArray(int[] arr) {
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			System.out.println("");
		}
}
