package ��������;

public class ��ת�����˫������ {
	public static class Node { //������
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	public static Node reverseList(Node head) {
		Node preNode=null; //ǰһ�����
		Node nexNode=null; //��һ�����
		while (head!=null) {//��ǰ�ڵ㲻Ϊ��
			nexNode=head.next;
			head.next=preNode;
			preNode=head;
			head=nexNode;
		}
		return preNode;
	}
	
	public static class DoubleNode { //˫������
		public int value;
		public DoubleNode next;
		public DoubleNode last;
		public DoubleNode(int data) {
			this.value=data;
		}
	}
	public static DoubleNode reverseDoubleList(DoubleNode head) {
		DoubleNode preNode=null;
		DoubleNode nextNode=null;
		while (head!=null) {
			nextNode=head.next;
			head.next=preNode;
			head.last=nextNode;
			preNode=head;
			head=nextNode;

		}
		return preNode;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
