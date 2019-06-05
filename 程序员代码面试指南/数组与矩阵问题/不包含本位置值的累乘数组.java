package �������������;

public class ��������λ��ֵ���۳����� {
	//���淽����ʹ�ó���ʵ��
	public static int[] product1(int[] arr) {
		if (arr==null ||arr.length==0) {
			return null;
		}
		int count=0; //��0���м���
		int allproduct=1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]!=0) {
				allproduct*=arr[i];
			}else {
				count++;
			}
		}
		int[] res=new int[arr.length];
		if (count==0) { //û��0Ԫ��
			for (int i = 0; i < arr.length; i++) {
				res[i]=allproduct/arr[i];
			}
		}
		if (count==1) { //ֻ��1��0,���0���ڵ�λ���⣬�۳˽����Ϊ0
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]==0) {
					res[i]=allproduct;
				}
			}
		}
		//���0�ĸ�������һ������ô���н����Ϊ0
		return res;
	}
	
	//����ʹ�ó���ʱ��ʹ�����Ԫ�س˻������ұ�Ԫ�س˻�
	public static int[] product2(int[] arr) {
		if (arr==null ||arr.length==0) {
			return null;
		}
		int[] left=new int[arr.length];//���Ԫ�س˻�
		int[] right=new int[arr.length]; //�ұ�Ԫ�س˻�
		left[0]=1;
		right[arr.length-1]=1;
		for (int i = 1; i < arr.length; i++) {
			left[i]=left[i-1]*arr[i-1];
		}
		for (int i = arr.length-2; i>=0; i--) {
			right[i]=right[i+1]*arr[i+1];
		}
		int[] res=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i]=left[i]*right[i];
		}
		return res;
	}
	//�Է���2�����Ż������ý������
	public static int[] product3(int[] arr) {
		if (arr==null ||arr.length==0) {
			return null;
		}
		int[] res=new int[arr.length];
		res[0]=arr[0];
		for (int i = 1; i < arr.length; i++) { //��¼��߳˻����
			res[i]=res[i-1]*arr[i];
		}
		int tmp=1;
		for (int i = arr.length-1; i>0 ; i--) {
			res[i]=res[i-1]*tmp;  //��߳����ұ�
			tmp*=arr[i]; //�ұ߳˻����
		}
		res[0]=tmp; //��һ��λ�ã������ұ߳˻����
		return res;
		
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int[] res1 = product1(arr);
		printArray(res1);
		int[] res2 = product2(arr);
		printArray(res2);
		int[] res3 = product3(arr);
		printArray(res3);

	}

}
