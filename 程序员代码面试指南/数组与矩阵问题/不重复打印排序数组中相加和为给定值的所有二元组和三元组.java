package �������������;

public class ���ظ���ӡ������������Ӻ�Ϊ����ֵ�����ж�Ԫ�����Ԫ�� {
	//��Ԫ��
	public static void printUniquePair(int[] arr,int k) {
		if (arr==null ||arr.length<=1) {
			return;
		}
		int left=0;
		int right=arr.length-1;
		while (left<right) {
			if (arr[left]+arr[right]<k) {
				left++;
			}else if (arr[left]+arr[right]>k) {
				right--;
			}else {
				if (left==0 || arr[left]!=arr[left-1]) {
					System.out.println(arr[left]+","+arr[right]);
				}
				left++;
				right--;
			}
		}
	}
	
	//��Ԫ��,��ȷ����һ��Ԫ�أ�Ȼ������Һ�����Ԫ��
	public static void printUniqueTriad(int[] arr,int k) {
		if (arr==null ||arr.length<=2) {
			return;
		}
		for (int i = 0; i < arr.length-2; i++) { //��һ��Ԫ�ؿ���ȡֵ
			if (i==0 || arr[i]!=arr[i-1]) { //��֤����ǰһ��Ԫ���ظ�
				printRest(arr, i, i+1, arr.length-1, k-arr[i]); //Ѱ�Һ�����Ԫ��
			}
		}
	}
	public static void printRest(int[] arr,int f,int l,int r,int k) {
		while (l<r) {
			if (arr[l]+arr[r]<k) {
				l++;
			}else if (arr[l]+arr[r]>k) {
				r--;
			}else {
				if (l==f+1 || arr[l]!=arr[l-1]) {
					System.out.println(arr[f]+","+arr[l]+","+arr[r]);
				}
				l++;
				r--;
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
		int sum = 10;
		int[] arr1 = { -8, -4, -3, 0, 1, 2, 4, 5, 8, 9 };
		printArray(arr1);
		System.out.println("====");
		printUniquePair(arr1, sum);
		System.out.println("====");
		printUniqueTriad(arr1, sum);

	}
}
