package ����������;

import ����������.����������.Node;

public class ͨ��������������ƽ������������ {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value=data;
		}
	}
	public static Node generateTree(int[] sortArr) {
		if(sortArr==null) return null;
		return generate(sortArr,0,sortArr.length-1);
	
	}
	//ѡȡ����������м�ֵΪͷ��㣬��ߵ����ڹ������������ұߵ����ڹ���������
	public static Node generate(int[] sortArr,int start,int end) {
		if(start>end) return null;
		int mid=(start+end)/2;
		Node head=new Node(sortArr[mid]);
		head.left=generate(sortArr,start,end-1);
		head.right=generate(sortArr,start+1,end);
		return head;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
