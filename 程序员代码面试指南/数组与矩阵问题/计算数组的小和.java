package �������������;
/**
����С�͵Ķ������£����磬����s=[1,3,5,2,4,6]
��s[0]�����С�ڻ����s[0]�����ĺ�Ϊ0
��s[1]�����С�ڻ����s[1]�����ĺ�Ϊ1
��s[2]�����С�ڻ����s[2]�����ĺ�Ϊ1+3=4
��s[3]�����С�ڻ����s[3]�����ĺ�Ϊ1
��s[4]�����С�ڻ����s[4]�����ĺ�Ϊ1+3+2=6
��s[5]�����С�ڻ����s[5]�����ĺ�Ϊ1+3+5+2+4=15
����s��С��Ϊ0+1+4+1+6+15=27
����һ������s��ʵ�ֺ�������s��С�͡�

 * @author zoe
 *
 */
public class ���������С�� {
	public static int getSmallSum(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		return func(arr, 0, arr.length-1);
		
	}
	 //���ù鲢����ʵ�֣���������ٺϲ�
	public static int func(int[] arr,int l,int r) { 
		if (l==r) {
			return 0;
		}
		int mid=(l+r)/2;
		return func(arr, l, mid)+func(arr, mid+1, r)+merge(arr, l, mid, r);
	}
	public static int merge(int[] arr,int left,int mid,int right) {
		int[] help=new int[right-left+1]; //��¼����õ�����
		int hi=0;
		int i=left;
		int j=mid+1;
		int smallSum=0;
		while (i<=mid && j<=right) {
			if (arr[i]<=arr[j]) {
				smallSum+=arr[i]*(right-j+1);
				help[hi++]=arr[i++];
			}else {
				help[hi++]=arr[j++];
			}
		}
		for (; (j<=right || i<=mid);j++,i++) {
			help[hi++]=i>mid?arr[j]:arr[i];
		}
		for (int k = 0; k < help.length; k++) { //������õ�����ֵ���Ƹ�ԭ����
			arr[left++]=help[k];
		}
		return smallSum;
	}
	public static void main(String[] args) {
		int[] arr = { 1,3,5,2,4,6 };
		System.out.println(getSmallSum(arr));

	}
}
