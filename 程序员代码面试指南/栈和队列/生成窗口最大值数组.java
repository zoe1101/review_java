package ջ�Ͷ���;

import java.util.Arrays;
import java.util.LinkedList;

//����˫�˶���ʵ��
public class ���ɴ������ֵ���� {
	public static int[] getMaxWindow(int[] arr,int w) {
		if(arr==null ||arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax=new LinkedList<Integer>(); //˫�˶��У���ŵ����±�
		int[] res=new int[arr.length-w+1];
		int index=0;
		for(int i=0;i<arr.length;i++) {
			//�ǿ�,�Ҷ�β��ŵ��±��Ӧ��Ԫ��С�ڵ���arr[i],�򵯳�Ԫ��
			while (!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]) {
				qmax.pollLast();
			}//ֱ���ӿջ��β��ŵ��±��Ӧ��Ԫ�ش���arr[i],Ȼ��iѹ�����
			qmax.addLast(i);;
			if(qmax.peekFirst()==i-w) {//��ͷ��ŵ��±��ѹ��ڣ�ֻά������Ϊw��������
				qmax.pollFirst();
			}
			if(i>=w-1) {
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr= {4,3,5,4,3,3,6,7};
		System.out.println(Arrays.toString(getMaxWindow(arr, 3)));

	}

}
