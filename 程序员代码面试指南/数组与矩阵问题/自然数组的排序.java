package �������������;

public class ��Ȼ��������� {
	//����1:�������Ż�ֵ��˼��
	public static void sort1(int[] arr) {
		int tmp=0;
		int next=0;
		for (int i = 0; i < arr.length; i++) {
			tmp=arr[i];
			while (arr[i]!=i+1) { //��ǰλ�õ�ֵ����
				next=arr[tmp-1]; //��¼arr[tmp-1]λ�õ�ֵ
				arr[tmp-1]=tmp;  //����ǰλ�õ�ֵӦ����arr[tmp-1]λ�õ�ֵ
				tmp=next;
			}
			
		}
	}
	//����2�����ý���˼��
	public static void sort2(int[] arr) {
		int tmp=0;
		for (int i = 0; i < arr.length; i++) {
			while (arr[i]!=i+1) {
				tmp=arr[arr[i]-1];
				arr[arr[i]-1]=arr[i];
				arr[i]=tmp;
			}
		}
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 8, 2, 1, 6, 9, 3, 7, 5, 4 };
		sort1(arr);
		printArray(arr);
		System.out.println("================");
		arr = new int[] { 8, 2, 1, 6, 9, 3, 7, 5, 4 };
		sort2(arr);
		printArray(arr);

	}

}
