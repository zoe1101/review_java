package �����㷨;
import java.util.Arrays;


//ѡ�����򣺣���ð��������죬���д������٣�
public class ѡ������ {
	
//    ��С����
	public static int[] SmalltoBig(int[] arr) {
		if (arr==null || arr.length<2) {
			return arr;
		}
		//ÿ��ѡ��С�ķ�ǰ��
		for(int i=0;i<arr.length-1;i++) {  //iΪ���������е�ĩβ
			for (int j=i+1;j<arr.length;j++) { //jΪδ��������
				if(arr[j]<arr[i]) {  //�ҳ�δ���������е���Сֵ
					swap(arr,i,j);
					//Ԫ�ؽ���λ�ã��ŵ����������е�ĩβ���ò������п��ܰ��ȶ��Դ��ң�����ѡ�������ǲ��ȶ��������㷨
				}
			}
		}
		return arr;
	}


//    �Ӵ�С
	public static int[] BigtoSmall(int[] arr) {
		if (arr==null || arr.length<2) {
			return arr;
		}
		//ÿ��ѡ���ķ�ǰ��
		for(int i=0;i<arr.length-1;i++) { //ǰi+1��Ԫ���Ѿ��ź����ˣ������ٶ�
			for (int j=i+1;j<arr.length;j++) {
				if(arr[j]>arr[i]) {
					swap(arr, i, j);
				}
			}
		}
		return arr;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

	//�����������
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//(int)((maxSize + 1) * Math.random())�� [0,maxSize]���������һ��ֵ��Ϊ���鳤��
		int[] arr=new int[(int)((maxSize + 1) * Math.random())]; 
		for (int i = 0; i < arr.length; i++) {
			//�����������[-maxValue,maxValue]��ֵ
			arr[i]=(int) ((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
		}
		return arr;
	}
	

	// ��ӡ����Ԫ��
	public static void printArray(int[] arr) {
		if (arr==null) {
			return ;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int maxSize = 20; //������󳤶�
		int maxValue = 50; //Ԫ�����ֵ
		int[] arr1= generateRandomArray(maxSize, maxValue);
		printArray(arr1);
		printArray(BigtoSmall(arr1));
		printArray(SmalltoBig(arr1));
	}

}
