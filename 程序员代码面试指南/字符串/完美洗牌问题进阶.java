package �ַ���;

import java.util.Arrays;
import �ַ���.����ϴ������;
public class ����ϴ��������� {
	public static void wiggleSort(int[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		Arrays.sort(arr);
		if((arr.length&1)==0) { //����
			����ϴ������.shuffle(arr, 1, arr.length-1);
		}else { //ż��
			����ϴ������.shuffle(arr, 0, arr.length-1);
			for(int i=0;i<arr.length;i+=2) {
				int tmp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
