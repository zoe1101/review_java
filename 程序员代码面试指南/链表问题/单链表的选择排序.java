package ��������;

import java.awt.image.SampleModel;

//Ҫ��ռ临�Ӷ�O��1��;
public class �������ѡ������ {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node selectionSort(Node head) {
		Node curNode=head; //���򲿷ֵ�β��
		Node tailNode=null; //δ���򲿷ֵ�ͷ��
		Node smallPreNode=null;//��С�ڵ��ǰһ���ڵ�
		Node smallNode=null;//��С�ڵ�
		while (curNode!=null) {
			smallNode=curNode;
			smallPreNode=getSmallestNode(curNode);
			if (smallPreNode!=null) {
				smallNode=smallPreNode.next;
				smallPreNode.next=smallNode.next;
			}
			curNode=curNode==smallNode?curNode.next:curNode;
			if (tailNode==null) {
				head=smallNode;
			}else {
				tailNode.next=smallNode;
			}
			tailNode=smallNode;
		}
		return head;
	}
	public static Node getSmallestNode(Node head) {
		Node smallPreNode=null;
		Node smallNode=head;
		Node preNode=head;
		Node curNode=head.next;
		while (curNode!=null) {
			if (curNode.value<smallNode.value) {
				smallPreNode=preNode;
				smallNode=curNode;
			}
			preNode=curNode;
			curNode=curNode.next;
		}
		return smallPreNode;
	}
	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head = null;
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(4);
		head.next.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

	}

}
