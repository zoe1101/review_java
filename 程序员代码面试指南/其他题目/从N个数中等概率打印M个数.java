package ������Ŀ;

public class ��N�����еȸ��ʴ�ӡM���� {
	//����ӡ����������������Ұ벿��
	public static void printRandM(int[] arr,int m) {
		if (arr==null ||arr.length==0|| m<1) {
			return ;
		}
		m=Math.min(m, arr.length);
		int count=0;
		int index=0;
		while (count<m) {
			index=(int)(Math.random()*(arr.length-count)); //��1��n-count�����ѡһ����
			System.out.println(arr[index]);
			swap(arr, index, arr.length-count-1); //����ǰѡ�е��������δ��ӡ���ֵ����һ��������
			count++;
		}
	}
	public static void swap(int[] arr ,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		int[] arr= {2,45,67,3,25,2,5,3,5,7};
		printRandM(arr, 4);
	}

}
