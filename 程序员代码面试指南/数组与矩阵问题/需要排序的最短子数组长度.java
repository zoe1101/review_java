package �������������;

public class ��Ҫ�������������鳤�� {
	public static int getMinLength(int[] arr) {
		if (arr==null ||arr.length<=1) {
			return 0;
		}
		//����arr[noMinIndex:noMaxIndex]����Ҫ����Ĳ���
		int min=arr[arr.length-1]; //�����������ʱ���Ҳ���ֹ�����Сֵ
		int noMinIndex=-1;
		int max=arr[0]; //�������ұ���ʱ�������ֹ������ֵ
		int noMaxIndex=-1;
		for (int i = arr.length-1; i >=0; i--) {
			if (arr[i]>min) { //����
				noMinIndex=i;
			}else {
				min=Math.min(arr[i], min);
			}
		}
		if (noMinIndex==-1) { //�������������������
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]<max) { //����
				noMaxIndex=i;
			}else {
				max=Math.max(arr[i], max);
			}
		}
		return noMaxIndex-noMinIndex+1;
	}

}
