package �������������;

public class ��������֮��������������ֵ {
	//����Ͱ����˼��
	public static int maxGap(int[] nums) {
		if (nums==null || nums.length<2) {
			return 0;
		}
		int len=nums.length;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i <len; i++) {
			max=Math.max(max, nums[i]);
			min=Math.min(min, nums[i]);
		}
		if (max==min) { 
			return 0;
		}
		boolean[] hasNum=new boolean[len+1]; //��¼ÿ��Ͱ����û����
		int[] maxs=new int[len+1]; //��¼ÿ��Ͱ�����ֵ����ֵ
		int[] mins=new int[len+1]; //��¼ÿ��Ͱ�����ֵ���Сֵ
		int bid=0;
		for (int i = 0; i < len; i++) {
			bid=(nums[i]-min)*len/(max-min); //ÿ������Ӧ��Ͱ��
			mins[bid]=hasNum[bid]?Math.min(mins[bid], nums[i]):nums[i];
			maxs[bid]=hasNum[bid]?Math.max(maxs[bid], nums[i]):nums[i];
			hasNum[bid]=true;
		}
		int res=0;
		int lastMax=maxs[0]; //��������ֵͰ�����ֵ
		for (int i = 1; i <= len; i++) {
			if (hasNum[i]) { //��i��Ͱ������
				res=Math.max(res, mins[i]-lastMax);
				lastMax=maxs[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = { 11, 10, 9, 3, 1, 12 };
		System.out.println(maxGap(arr));

	}

}
