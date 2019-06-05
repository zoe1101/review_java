package �������������;


public class ��ӡN��������������TopK {
	//���ô󶥶�ʵ��
	/**
	1.����һ����СΪN�Ĵ���ѣ����ѵĹ��̾��ǰ�ÿһ����������һ��ֵ��
		Ҳ���Ǹ���������ֵ�����μ��뵽���������̾��ǽ��ѵĵ������̡�
	2.���ö��Ժ󣬴�ʱ�Ѷ���Ԫ�ؾ�����������������Ԫ�أ���ӡ�Ѷ�Ԫ�ء�
	3.����Ѷ���Ԫ������ a ����� i λ�ã���ô���Ѷ���Ԫ����a[i-1]�滻��
		Ȼ��Ӷѵ�ͷ�����µ����ѡ�������ִ�ʱ a �����Ѿ�û��Ԫ�أ���ô�ͽ��Ѷ�Ԫ�����βԪ�ؽ�����
		ͬʱ��ѵĴ�С��1����Ȼ�ǴӶѵ�ͷ�����µ����ѡ�
	4.ÿ�ζ��ɵõ�һ���Ѷ�Ԫ�أ���ӡk���Ѷ�Ԫ�أ��������յĽ����
	 */
	public static class HeapNode{
		public int value; //�ڵ�ֵ
		public int arrNum; //�ڵ������ĸ�����
		public int index; //�ڵ�����������ĸ�λ��
		public HeapNode(int value,int arrNum,int index) {
			this.value=value;
			this.arrNum=arrNum;
			this.index=index;
		}
	}
	public static void printTopK(int[][] matrix,int topK) {
		int heapSize=matrix.length; //����ĸ���
		HeapNode[] heap=new HeapNode[heapSize];
		for (int i = 0; i < heapSize; i++) {  
			int index=matrix[i].length-1; 
			 //��ÿ����������һ��Ԫ�طŽ�����
			heap[i]=new HeapNode(matrix[i][index], i, index);
			heapInsert(heap, i);
		}
		System.out.println("Top" +topK+" : ");
		for (int i = 0; i < topK; i++) {
			if (heapSize==0) { //�Ѿ�û��Ԫ����
				break;
			}
			System.out.print(heap[0].value+" "); //����Ѷ�Ԫ��
			if (heap[0].index!=0) { //���ǵ�һ��Ԫ��ʱ��ǰһ��Ԫ���滻�Ѷ�Ԫ��
				heap[0].value=matrix[heap[0].arrNum][--heap[0].index];
			}else { //�Ѷ�Ԫ�����ڵ������Ѿ��������ˣ���Ҫ�ԶѵĽڵ���������
				swap(heap, 0, --heapSize);
			}
			heapify(heap, 0, heapSize); //�ѵ���
		}
	}
	//�ڶ��в���ڵ�
	public static void heapInsert(HeapNode[] heap,int index) {
		while (index!=0) { //������ǶѶ��ڵ�
			int parent=(index-1)/2; //���ڵ�
			if (heap[parent].value<heap[index].value) {
				swap(heap, parent, index);
				index=parent;
			}else {
				break;
			}
		}
	}
	//�ѵ���
	public static void heapify(HeapNode[] heap,int index,int heapSize) {
		int left=index*2+1;
		int right=index*2+2;
		int largest=index;
		while (left<heapSize) {
			if (heap[left].value>heap[index].value) {
				largest=left;
			}
			if (right<heapSize && heap[right].value>heap[largest].value) {
				largest=right;
			}
			if (largest!=index) {
				swap(heap, largest, index);
			}else {
				break;
			}
			index=largest;
			left=index*2+1;
			right=index*2+2;
		}
	}
	public static void swap(HeapNode[] heap,int index1,int index2) {
		HeapNode tmp=heap[index1];
		tmp=heap[index1]=tmp=heap[index2];
		tmp=heap[index2]=tmp;
	}

}
