package ��������;

import java.util.LinkedList;
import java.util.Queue;

public class ������������ת����˫������ {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	//�������������
	public static Node convert1(Node head) {
		Queue<Node> queue=new LinkedList<Node>(); //����������
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head=queue.poll();
		Node preNode=head;
		preNode.left=null;
		Node curNode=null;
		while (!queue.isEmpty()) {
			curNode=queue.poll();
			preNode.right=curNode;
			curNode.left=preNode;
			preNode=curNode;
		}
		preNode.right=null;
		return head;
		
	}
	
	
	//�������
	public static void inOrderToQueue(Node head,Queue<Node> queue) {
		if (head==null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}
	
	
}
