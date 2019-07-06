package �����㷨;

import java.util.Arrays;

// ָ�뽻����
public class �������� {
	public static void quickSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		quickSort2(arr, 0, arr.length-1);
	}
	
	//ѡ������ߵ�Ԫ��Ϊ��׼Ԫ��
	public static void quickSort2(int[] arr,int start,int end){
        if(start<end) {
			int left=start; //��ָ��
			int right=end; //��ָ��
			int standard=arr[left]; //��׼Ԫ��
			while (left<right) {
				while (standard<=arr[right] && left<right) {//�ȿ��ұߣ���������ݼ�
					right--;
				}
				while (standard>=arr[left] && left<right) {//�ٿ���ߣ��������ҵ���
					left++;
				}
				if (left<right) {//������������򽻻�
					swap(arr, left, right);
				}
			}
//			printArray(arr);
			//��󽫻�׼Ԫ����arr[left]���� (��ʱleft=right)
	         arr[start] = arr[left];
	         arr[left] = standard;
			quickSort2(arr, start, right-1);
			quickSort2(arr, right+1, end);
		}
    }
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
  
}
