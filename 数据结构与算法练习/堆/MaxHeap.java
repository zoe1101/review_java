package ��;

import java.math.BigDecimal;
import java.util.Arrays;

public class MaxHeap {
	private int[] data;
	/**
	 * ���췽��������һ�����飬��ת��Ϊһ������
	 * @param data
	 */
	public MaxHeap(int[] data) {
		this.data=data;
		buildHeap();
	}
	/**
	 * ������ת��Ϊ����,����󶥶�
	 */
	private void buildHeap() {
		//��ȫ������ֻ�������±�С�ڻ���� (data.length) / 2 - 1 ��Ԫ���к��ӽ�㣬������Щ���
		for(int i=(data.length)/2-1;i>=0;i--) {//���ѣ���(data.length) / 2 - 1 ��ʼ���ϵ���
			heapify(i);
		}
	}
	public void heapify(int i) {
		int left=left(i);
		int right=right(i);
		int largest=i;// �ٶ��ĵ�ǰ�ڵ㡢���ӽڵ㡢���ӽڵ��� ���ֵ���±�
		if(left<data.length &&data[left]>data[i]) {// �������ӽڵ㣬�����ӽڵ��ֵ���ڵ�ǰ�ڵ��ֵ
			largest=left;
		}
		if(right<data.length && data[right]>data[i]) {// �������ӽڵ㣬�����ӽڵ��ֵ���ڵ�ǰ�ڵ��ֵ
			largest=right;
		}
		if(largest!=i) {
			swap(largest, i);
		}else {
			return;
		}
		
		heapify(largest);// ��֮ǰ���ֵ�ڵ�λ�����¶ѻ�
	}
	public int left(int i) { //��ȡ���ӽڵ�������±�
		return i*2+1;
	}
	public int right(int i) { //��ȡ�Һ��ӽڵ�������±�
		return i*2+2;
	}
	
	
	public  void swap(int index1,int index2) {//����Ԫ��
		int temp=data[index1];
		data[index1]=data[index2];
		data[index2]=temp;
		
	}
	public int getroot() {//��ȡ�������Ԫ�أ�����Ԫ��
		return data[0];
	}
	public void setRoot(int root) {//�滻��Ԫ�أ�������heapify
		data[0]=root;
		heapify(0);
	}
	 public void HeapDelete(int value) {
		 int heapsize=data.length;
		 for(int i=0;i<heapsize;i++) {
			 if(data[i]==value) {
				 break;
			 }
		 }
	 }
	public void printHeap() {//�������������
		System.out.print(Arrays.toString(data));
	}

	public static void main(String[] args) {
		int[] num = new int[]{49,38,65,97,76,13,27,49};
		MaxHeap heap = new MaxHeap(num);
		heap.buildHeap();
		heap.printHeap();

	}

}
