package ����;

import test.class_A;
import ����.SingleLinkedList.Node;

public class TwoWayLinkedList {
	public Node head;//��ͷ�ڵ�
	public Node tail;//��β�ڵ�
	public int size; //����ڵ����
	
	public TwoWayLinkedList() {
		size=0;
		head=null;
		tail=null;
	}
	//�����ÿ���ڵ���
	public class Node{
		public Object data; //�ڵ�Ԫ��
		public Node next;//ָ����һ�ڵ�
		public Node prev;//ָ����һ�ڵ�
		public Node(Object data) {
			this.data=data;
		}
	}
	//������ͷ���ӽڵ�
	public void addHead(Object obj) {
		Node newNode=new Node(obj);
		if(size==0) {//һ��Ԫ��ʱ����ͷ���ڱ�β
			head=newNode;
			tail=newNode;
			size++;
		}else {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			size++;
		}
		
	}
	//������β���ӽڵ�
	public void addTail(Object obj) {
		Node newNode=new Node(obj);
		if(size==0) {
			head=newNode;
			tail=newNode;
			size++;
		}else {
			newNode.prev=tail;
			tail.next=newNode;
			tail=newNode;
			size++;
		}
	}
	//ɾ������ͷ
	public Node deleteHead() {
		Node temp=head;
		if(size!=0) {//�ǿ�����
			head=head.next;
			head.prev=null;
			size--;
		}
		return temp;//����ɾ��������ͷ
	}
	//ɾ������β
	public Node deleteTail() {
		Node temp=tail;
		if(size!=0) {//�ǿ�����
			tail=tail.prev;
			tail.next=null;
			size--;
		}
		return temp;//����ɾ��������β
	}
	//�������Ľڵ����
	public int getSize() {
		return size;	
	}
	 //�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return (size==0);
	}
	//��ʾ�ڵ���Ϣ
	public void display() {
		if(size>0) {
			Node node=head;
			int tempSize=size;
			if(tempSize==1) {//ֻ��һ���ڵ������
				System.out.print("["+node.data+"]");
				return;
			}
			while(tempSize>0) {
				if(node.equals(head)) {//ͷ���
					System.out.print("["+node.data+"->");
				}else if(node.next==null){//β�ڵ�
					System.out.print(node.data+"]");
				}else {//�м���
					System.out.print(node.data+"->");
				}
				node=node.next;
				tempSize--;
			}
			System.out.println();
		}else {//������
			System.out.println("[]");
		}
		
	}
	public static void main(String[] args) {
		TwoWayLinkedList linkedList=new TwoWayLinkedList();
		linkedList.addHead("A");
		linkedList.addHead("B");
		linkedList.addTail("C");
		linkedList.addTail("D");
		linkedList.display();
		linkedList.deleteHead();
		linkedList.deleteTail();
		linkedList.display();

	}

}
