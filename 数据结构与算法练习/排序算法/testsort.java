package �����㷨;

import java.util.Arrays;

public class testsort {
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=1;j<arr.length-i;j++){
				if(arr[j]<arr[j-1]){
					int temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
					}
				}
			System.out.println("��i��:"+Arrays.toString(arr));
			}
		System.out.println(Arrays.toString(arr));
	}	

	public static void main(String[] args) {
		int[] arr=new int[] {1,8,4,7,2,5};
		bubbleSort(arr);
	}

}

