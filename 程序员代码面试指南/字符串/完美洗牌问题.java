package �ַ���;

import java.util.Arrays;

import javax.swing.table.TableRowSorter;

/**
 * �и�����Ϊ2n������{a1,a2,a3,��,an,b1,b2,b3,��,bn}��ϣ�������{a1,b1,a2,b2,��.,an,bn}
 * ʱ�临�Ӷ�o(n)���ռ临�Ӷ�0(1)
 * @author zoe
 *
 */
public class ����ϴ������ {
	/**
	 * λ�õ���,λ��������1��ʼ
	 * @param i
	 * @param len
	 */
	public static int modify1(int i,int len) {
		if(i<=len/2) {
			return 2*i;
		}else {
			return 2*(i-len/2)-1;
		}
	}
	//modify1��������
	public static int modify2(int i,int len) {
		return (2*i)%(len+1);
	}

	
	/**
	 * ������
	 * @param arr
	 */
	public static void shuffle(int[] arr) {
		if(arr!=null && arr.length!=0&& (arr.length&1)==0) {//������벻Ϊ���ҳ���Ϊż��
			shuffle(arr,0,arr.length-1);
		}
	}
	
	public static void shuffle(int[] arr,int left,int right) {
		while (right-left+1>0) { //�г�һ��һ����,ÿ�鳤�����㣨3^k��-1
			int len=right-left+1;
			int base=3;
			int k=1;
			while (base<=(len+1)/3) { //�ҳ���len��Χ�ڵģ����㣨3^k��-1����len������������ҵ�����k
				base*=3;
				k++;
			}
			int half=(base-1)/2; //��ǰ��Ҫ�������Ϊbase-1�Ŀ飬һ������ٳ���2
			int mid=(left+right)/2; //[left,Right]���м�λ��
			rotate(arr, left+half, mid, mid+half);//��midΪ�磬�����[left+half,mid]��Ԫ���Ƶ��ұߵĺ���
			cycles(arr, left, base-1, k); //��left��ʼ�����г���Ϊbase-1�Ĳ��������±���
			left=left+base-1; //��������ʣ�ಿ��
			
		}
	}
	/**
	 * �����±��ƣ���start��ʼ��������len������һ�������
	 * @param arr
	 * @param start
	 * @param len
	 * @param k
	 */
	public static void cycles(int[] arr,int start,int len,int k) {
	//      trigger:ÿһ�����ĳ���λ�ã�һ����k��
	//		ÿһ��trigger������������±���
	//		����λ��trigger��1��ʼ���������±��0��ʼ
		for(int i=0,trigger=1;i<k;i++,trigger*=3) {
			int preValue=arr[trigger+start-1];
			int cur=modify2(trigger, len);
			while (cur!=trigger) {
				int tmp=arr[cur+start-1];
				arr[cur+start-1]=preValue;
				preValue=tmp;
				cur=modify2(cur, len);
			}
			arr[cur+start-1]=preValue;
		}
	}
	/**
	 * ��벿�����Ұ벿�ֽ���
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void rotate(int[] arr,int left,int mid,int right) {
		reverse(arr, left, mid);
		reverse(arr, mid+1, right);
		reverse(arr, left, right);
	}
	/**
	 * ���鲿������
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void reverse(int[] arr, int left,int right) {
		while (left<right) {
			int tmp=arr[left];
			arr[left]=arr[right];
			arr[right]=tmp;
			left++;
			right--;
		}
	}
	/**
	 * ���������飬����Ϊ�����������ڵ�����������<=������>=�Ĺ�ϵ,����a<=b>=c<=d>=e.
	 * @param arr
	 */
	
	public static void wiggleSort(int[] arr) {
		if(arr==null || arr.length==0) {
			return;
		}
		Arrays.sort(arr);
		if((arr.length&1)==1) { //����
			shuffle(arr, 1, arr.length-1);
		}else { //ż��
			shuffle(arr, 0, arr.length-1);
			for(int i=0;i<arr.length;i+=2) {
				int tmp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=tmp;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(arr));
		shuffle(arr);
		System.out.println(Arrays.toString(arr));
		wiggleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}


}
