package �����㷨;

import java.util.Scanner;
// ָ�뽻����
public class �������� {
	public static void main(String[] args) {
		
		Scanner stdinScanner = new Scanner(System.in);
		int n= stdinScanner.nextInt();//����Ԫ�ظ���
		int[] arr=new int[n];
		for (int i=0;i<arr.length;i++) {
			arr[i]=stdinScanner.nextInt();
		}
//		printArray(arr);
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
	public static void QuickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp���ǻ�׼λ
        temp = arr[low];
 
        while (i<j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //�ٿ���ߣ��������ҵ���
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //������������򽻻�
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
 
        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
         arr[low] = arr[i];
         arr[i] = temp;
        //�ݹ�����������
        QuickSort(arr, low, j-1);
        //�ݹ�����Ұ�����
        QuickSort(arr, j+1, high);
    }

  
}
