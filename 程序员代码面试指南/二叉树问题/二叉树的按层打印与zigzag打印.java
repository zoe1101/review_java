package ����������;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class �������İ����ӡ��zigzag��ӡ {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
	    public Node(int val) {
	        this.value = val;
	    }
	}
//	�����ӡ
	public static void printByLevel(Node head) {
		if (head==null) {
			return;
		}
		Queue<Node> queue=new LinkedList<Node>();
		int level=1; //��ǰ��
		Node last=head; //���ڴ�ӡ�ĵ�ǰ�е����ڵ�
		Node nlast=null;//��һ�е����ڵ�
		queue.offer(head);
		System.out.print("Level "+(level++)+" : ");
		while (!queue.isEmpty()) {
			head=queue.poll();
			System.out.print(head.value+" ");
			if (head.left!=null) {
				queue.offer(head.left);
				nlast=head.left;
			}
			if (head.right!=null) {
				queue.offer(head.right);
				nlast=head.right;
			}
			if (head==last&&!queue.isEmpty()) { //�û�����
				System.out.print("\nLevel "+(level++)+" :");
				last=nlast;
			}
		}
		System.out.println();
	}
	
//	zigzag��ӡ
	public static void printByZigZag(Node head) {
		if (head==null) {
			return;
		}
		Deque<Node> deque=new LinkedList<Node>();
		int level=1;
		boolean lr=true; //�����ҵķ���
		Node last=head;
		Node nlast=null;
		deque.offerFirst(head);
		printLevelAndOrientation(level++, lr);
		while (!deque.isEmpty()) {
			if (lr) {//�����ҵķ���
				head=deque.pollFirst();
				if (head.left!=null) {
					nlast=nlast==null?head.left:nlast;
					deque.offerLast(head.left);
				}
				if (head.right!=null) {
					nlast=nlast==null?head.right:nlast;
					deque.offerLast(head.right);
				}
			}else {//���ҵ���
				head=deque.pollLast();
				if (head.right!=null) {
					nlast=nlast==null?head.right:nlast;
					deque.offerFirst(head.right);
				}
				if (head.left!=null) {
					nlast=nlast==null?head.left:nlast;
					deque.offerFirst(head.left);
				}
			}
			System.out.print(head.value+" ");
			if (head==last && !deque.isEmpty()) {
				lr=!lr;
				last=nlast;
				nlast=null;
				System.out.println();
				printLevelAndOrientation(level++,lr);
			}
		}
		System.out.println();
	}
	

	public static void printLevelAndOrientation(int level,boolean lr) {
		System.out.print("Level "+level+" from ");
		System.out.print(lr? "left to right: ": "right to left: ");
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.right.left.left = new Node(7);
		head.right.left.right = new Node(8);

		System.out.println("===============");
		printByLevel(head);

		System.out.println("===============");
		printByZigZag(head);

	}
}
