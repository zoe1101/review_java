package �����㷨;

import java.util.Scanner;

import javax.net.ssl.StandardConstants;
// ָ�뽻����
public class �������� {
	public static void main(String[] args) {
		int[] arr=new int[] {1,3,4,3,5,8,7,4,1};
		QuickSort(arr, 0, arr.length-1);
		printArray(arr);

	}
	
	// ��ӡ��������Ԫ��
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println("");
	}
	public static void QuickSort(int[] arr,int strat,int end){
        int low,high,standard;
        if(strat<end) {
	        //��¼������±�
	        low=strat;
	        high=end;
	      
	        standard = arr[strat]; //��׼Ԫ��
	 
	        while (low<high) {
	            //�ȿ��ұߣ���������ݼ�
	            while (standard<=arr[high]&&low<high) {
	                high--;
	            }
	            arr[low]=arr[high];//���ұߵ����������
	            //�ٿ���ߣ��������ҵ���
	            while (standard>=arr[low]&&low<high) {
	                low++;
	            }
	            
	            arr[high]=arr[low];//����ߵ��������ұ�
	 
	        }
	         arr[low]=standard; //�ѻ�׼Ԫ�ظ��������ڵ�Ԫ��
	        //��������С�ڻ�׼������
	        QuickSort(arr, strat, high);
	        //�������д��ڻ�׼������
	        QuickSort(arr, high+1, end);
        }
    }

  
}
