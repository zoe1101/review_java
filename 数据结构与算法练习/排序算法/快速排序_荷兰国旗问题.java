package �����㷨;

//����һ������arr�� ��һ����num�� ���С��num���������������ߣ�
//����num��������������м䣬 ����num��������������ұߡ�


//����ռ临�Ӷ�O(1)�� ʱ�临�Ӷ�O(N)
public class ��������_������������ {
	public static int[] partition(int[] arr,int l,int r,int num) {
		int less=l-1;
		int more=r+1;
		while (l<more) {
			if (arr[l]<num) {
				swap(arr,++less,l++);
			}else if (arr[l]>num) {
				swap(arr, l, --more);
			}else {
				l++;
			}
		}
		return new int[] {less+1,more-1}; //����num����ʼλ�������λ��
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]+"->"+res[1]);

	}
}
