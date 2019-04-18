package ����������;

import java.util.Stack;

public class ���������� {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value=data;
		}
	}
	//�ݹ��������,��,��,��
	public static void preOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		System.out.print(head.value+" ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	//�ǵݹ��������,��,��,��
	public static void preOrderUnRecur(Node head) {
		while (head!=null) {
			Stack<Node> stack=new Stack<Node>();
			stack.push(head);
			while (!stack.isEmpty()) {
				head=stack.pop();
				System.out.print(head.value+" ");
				if(head.right!=null) {
					stack.push(head.right);
				}
				if(head.left!=null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	//�ݹ��������,��,��,��
	public static void inOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value+" ");
		inOrderRecur(head.right);
	}
	

	//�ǵݹ��������,��,��,��
	public static void inOrderUnRecur(Node head) {
		while(head!=null) {
			Stack<Node> stack=new Stack<Node>();
			while (!stack.isEmpty() || head!=null) {
				if(head!=null) {
					stack.push(head);
					head=head.left;
				}else {
					head=stack.pop();
					System.out.print(head.value+" ");
					head=head.right;
				}
			}
		}
		System.out.println();
	}
	
	//�ݹ�������,��,��,��
	public static void posOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value+" ");
	}
	
	//�ǵݹ�������,��,��,��
		public static void posOrderUnRecur(Node head) {
			if(head!=null) {
				Stack<Node> stack=new Stack<Node>();
				stack.push(head); //head:���һ�ε�������ӡ��Ԫ��
				Node cNode=null; //ջ��Ԫ��
				while (!stack.isEmpty()) {
					cNode=stack.peek();
					if(cNode.left!=null && head!=cNode.left && head!=cNode.right){
						stack.push(cNode.left);
					}else if(cNode.right!=null && head!=cNode.right) {
						stack.push(cNode.right);
					}else {
						System.out.print(stack.pop().value+" ");
					}
				}
			}
			System.out.println();
		}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
