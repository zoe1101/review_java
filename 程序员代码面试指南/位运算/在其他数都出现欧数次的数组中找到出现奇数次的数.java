package λ����;

public class ��������������ŷ���ε��������ҵ����������ε��� {
	
	//ֻ��һ��������������
	public static void printOddTimeNum1(int[] arr) {
		int eo=0;
		for (int cur:arr) {
			eo^=cur;
		}
		System.out.println(eo);
	}
	//ֻ������������������
	public static void printOddTimeNum2(int[] arr) {
		int eo=0;
		int eohasOne=0; //�������е�����һ��
		for (int cur:arr) {
			eo^=cur;
		}
		int rightOne=eo&(~eo+1);
		for(int cur:arr) {
			if((cur &rightOne)!=0) {
				eohasOne^=cur;
			}
		}
		System.out.println(eohasOne+" "+(eo^eohasOne));//(eo^eohasOne):��һ��
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
		printOddTimeNum1(arr1);

		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimeNum2(arr2);

	}

}
