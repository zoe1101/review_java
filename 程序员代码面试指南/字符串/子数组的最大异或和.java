package �ַ���;

public class �������������� {
	public static int maxXorSubarray1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int[] eor=new int[arr.length]; //eor[i]:��¼arr[0:i]������
		eor[0]=arr[0];
		for (int i = 1; i < arr.length; i++) {
			eor[i]=eor[i-1]^arr[i];
		}
		int max=Integer.MIN_VALUE;
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i<=j; i++) {
				max=Math.max(max, i==0?eor[j]:eor[j]^eor[i-1]); //eor[i:j]=eor[j]^eor[i-1]
			}
		}
		return max;
	}
	//����һ�ֻ���ǰ׺������ѡ����

}
