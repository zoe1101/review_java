package ��;

import java.util.Arrays;

public class MinHeap {
	private int[] data;
	public MinHeap(int[] data) {
		this.data=data;
		buildHeap();
	}
	public void buildHeap() {
		for(int i=(data.length)/2-1;i>=0;i--) {
			heapify(i);
		}
	}
	public void heapify(int i) {
		int left=left(i);
		int right=right(i);
		int smallest=i;
		if(left<data.length && data[left]<data[i]) {// �������ӽڵ㣬�����ӽڵ��ֵС�ڵ�ǰ�ڵ��ֵ
			smallest=left;
		}
		if(right<data.length && data[right]<data[i]) {// �������ӽڵ㣬�����ӽڵ��ֵС�ڵ�ǰ�ڵ��ֵ
			smallest=right;
		}
		if(smallest!=i) {// ����Сֵ�뵱ǰ�ڵ㻥��λ��
			swap(smallest, i);
		}else {
			return;
		}
		heapify(smallest);// ��֮ǰ��Сֵ�ڵ�λ�����¶ѻ�
	}
	public  void swap(int index1,int index2) {//����Ԫ��
		int temp=data[index1];
		data[index1]=data[index2];
		data[index2]=temp;
		
	}
	public int left(int i) {
		return i*2+1;
	}
	public int right(int i) {
		return i*2+2;
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
		MinHeap heap = new MinHeap(num);
		heap.buildHeap();
		heap.printHeap();

	}

}
