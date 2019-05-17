package �ݹ��붯̬�滮;

public class ��ŵ������ {
	public static void hanoi(int n) {
		if (n>0) {
			func(n, "left", "mid", "right");
		}
	}
	//�����ƶ��켣
	public static void func(int n,String from,String mid,String to) {
		if (n==1) {
			System.out.println("move from "+from+" to "+to);
		}else {
			func(n-1, from, to, mid); //�Ƚ������n-1�����Ӵ�����ƶ����м�
			func(1, from, mid, to);   //�ٽ���n�����Ӵ�����ƶ����ұ�
			func(n-1, mid, from, to); //���զ�м��n-1�������ƶ����ұ�
		}
	}
	/*
	 arr[i]��ֵ�����i+1��Բ�����ڵ�λ��
	����arr��������ʾ��״̬�������ƶ��켣�еĵڼ���״̬����������������ƶ��켣�ͷ���-1
	*/
	
	//����1
	public static int step1(int[] arr) {
		if (arr==null || arr.length==0) {
			return -1;
		}
		return process(arr, arr.length-1, 1, 2, 3);
	}

	//����2
	public static int step2(int[] arr) {
		if (arr==null || arr.length==0) {
			return -1;
		}
		int from=1; //���
		int mid=2; //�м�
		int to=3;  //�ұ�
		int i=arr.length-1;
		int res=0;
		int temp=0;//���ڴ洢�м�ֵ
		while (i>0) {
			if (arr[i]!=from && arr[i]!=to) {//Բ��i������ߺ��ұ�ʱ����Բ�����м��ǲ����ܵ�
				return -1;
			}
			if (arr[i]==to) {//Բ��i���ұߣ������ڴ���ǰi-1�����Ӵ��м��ƶ����ұ߹�����
				res+=1<<i;
				temp=from;
				from=mid;
			}else {//Բ��i����ߣ��������ڴ���ǰi-1������
				temp=to;
				to=mid;
			}
			mid=temp;
			i--;
		}
		return res;
	}
	
	public static int process(int[] arr,int i,int from,int mid,int to) {
		if (i==-1) {
			return 0;
		}
		if (arr[i]!=from && arr[i]!=to) { //Բ��i������ߺ��ұ�ʱ����Բ�����м��ǲ����ܵ�
			return -1;
		}
		if (arr[i]==from) {//Բ��i����ߣ��������ڴ���ǰi-1������
			return process(arr, i-1, from, to, mid);
		}else {//Բ��i���ұߣ������ڴ���ǰi-1�����Ӵ��м��ƶ����ұ߹�����
			int rest=process(arr, i-1, mid, from, to);
			if (rest==-1) {
				return -1;
			}
			return (1<<i)+rest;
		}
	}
	public static void main(String[] args) {
		int n = 4;
		hanoi(n);

		int[] arr = { 3, 3, 2, 1 };
		System.out.println(step1(arr));
		System.out.println(step2(arr));

	}
}
