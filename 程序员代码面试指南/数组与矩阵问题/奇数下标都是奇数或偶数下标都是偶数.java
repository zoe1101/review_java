package �������������;

public class �����±궼��������ż���±궼��ż�� {
	public static void modify(int[] arr) {
		if (arr==null || arr.length<2) { //�������
			return ;
		}
		int even=0; //ż���±�
		int odd=1; //�����±�
		int end=arr.length-1; //���һ��Ԫ�ص��±�
		while (even<=end && odd<=end) {
			if ((arr[end]&1)==0) { //���һ��Ԫ����ż��
				swap(arr, even, end);
				even+=2;
			}else {
				swap(arr, odd, end);
				odd+=2;
			}
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

}
