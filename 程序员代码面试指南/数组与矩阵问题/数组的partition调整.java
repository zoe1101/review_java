package �������������;

public class �����partition���� {
	public static void leftUnique(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		int u=0; //��߽�
		int i=1;//��߽���ұ�
		while (i<arr.length) { 
			if (arr[i]!=arr[u]) { //�Ұ벿�ֵ�arr[i]û�г�������벿�֣���Ӧ�ð�arr[i]������벿��
				swap(arr, ++u, i); //��arr[i]��arr[u+1]����λ�ã�������벿�ּ���arr[i]
			}
			i++;
		}
	}
	//��ֻ��0,1,2�������������
	public static void sort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		int maxLeft=-1;
		int index=0;
		int minRight=arr.length;
		while (index<minRight) {
			if (arr[index]==0) {//arr[index]�����������
				swap(arr, ++maxLeft, index++);
			}else if (arr[index]==2) { //arr[index]�����ұ�����
				swap(arr, index, --minRight);
			}else { //arr[index]�����м�����
				index++;
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
		printArray(arr1);
		leftUnique(arr1);
		printArray(arr1);

		System.out.println();

		int[] arr2 = { 2, 1, 2, 0, 1, 1, 2, 2, 0 };
		printArray(arr2);
		sort(arr2);
		printArray(arr2);

	}

}
