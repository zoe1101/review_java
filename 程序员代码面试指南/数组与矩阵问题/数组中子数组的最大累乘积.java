package �������������;

public class �����������������۳˻� {
	public static double maxProduct(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		double max=arr[0]; //��arr[i]��β������۳˻�
		double min=arr[0]; //��arr[i]��β����С�۳˻�
		double res=arr[0];
		double maxEnd=0; 
		double minEnd=0;
		for (int i = 0; i < arr.length; i++) {
			maxEnd=max*arr[i];  //3*5�����
			minEnd=min*arr[i]; //���������������-3��-5��
			//arr[i]:(0.5,100)�����
			max=Math.max(Math.max(maxEnd, minEnd), arr[i]); //��arr[i]��β������۳˻�
			min=Math.min(Math.min(maxEnd, minEnd), arr[i]);
			res=Math.max(res, max);
		}
		return res;
	}

}
