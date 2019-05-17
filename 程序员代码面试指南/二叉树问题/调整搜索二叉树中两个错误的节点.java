package ����������;

import java.util.Stack;

public class ������������������������Ľڵ� {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	//�ҵ�����ڵ�
//	�����������˼��
	public static Node[] getTwoErrNodes(Node head) {
		Node[] errNodes=new Node[2];
		if (head==null) {
			return errNodes;
		}
		Stack<Node> stack=new Stack<Node>();
		Node preNode=null;
		while (!stack.isEmpty() || head!=null) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			}else {
				head=stack.pop();
				if (preNode!=null && preNode.value>head.value) {
					errNodes[0]=errNodes[0]==null?preNode:errNodes[0];
					errNodes[1]=head;
				}
				preNode=head;
				head=head.right;
			}
		}
		return errNodes;
	}
	
	//��������������Ϊ��ȷ�ģ���Ҫ���ҵ�����ڵ�ĸ��ڵ�
	public static Node recoverTree(Node head) {
		Node[] errs = getTwoErrNodes(head);
		Node[] parents = getTwoErrParents(head, errs[0], errs[1]);
		Node e1 = errs[0];
		Node e1P = parents[0];
		Node e1L = e1.left;
		Node e1R = e1.right;
		Node e2 = errs[1];
		Node e2P = parents[1];
		Node e2L = e2.left;
		Node e2R = e2.right;
		if (e1 == head) {
			if (e1 == e2P) { // ���һ
				e1.left = e2L;
				e1.right = e2R;
				e2.right = e1;
				e2.left = e1L;
			} else if (e2P.left == e2) { // �����
				e2P.left = e1;
				e2.left = e1L;
				e2.right = e1R;
				e1.left = e2L;
				e1.right = e2R;
			} else { // �����
				e2P.right = e1;
				e2.left = e1L;
				e2.right = e1R;
				e1.left = e2L;
				e1.right = e2R;
			}
			head = e2;
		} else if (e2 == head) {
			if (e2 == e1P) { // �����
				e2.left = e1L;
				e2.right = e1R;
				e1.left = e2;
				e1.right = e2R;
			} else if (e1P.left == e1) { // �����
				e1P.left = e2;
				e1.left = e2L;
				e1.right = e2R;
				e2.left = e1L;
				e2.right = e1R;
			} else { // �����
				e1P.right = e2;
				e1.left = e2L;
				e1.right = e2R;
				e2.left = e1L;
				e2.right = e1R;
			}
			head = e1;
		} else {
			if (e1 == e2P) {
				if (e1P.left == e1) { // �����
					e1P.left = e2;
					e1.left = e2L;
					e1.right = e2R;
					e2.left = e1L;
					e2.right = e1;
				} else { // �����
					e1P.right = e2;
					e1.left = e2L;
					e1.right = e2R;
					e2.left = e1L;
					e2.right = e1;
				}
			} else if (e2 == e1P) {
				if (e2P.left == e2) { // �����
					e2P.left = e1;
					e2.left = e1L;
					e2.right = e1R;
					e1.left = e2;
					e1.right = e2R;
				} else { // ���ʮ
					e2P.right = e1;
					e2.left = e1L;
					e2.right = e1R;
					e1.left = e2;
					e1.right = e2R;
				}
			} else {
				if (e1P.left == e1) {
					if (e2P.left == e2) { // ���ʮһ
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.left = e2;
						e2P.left = e1;
					} else { // ���ʮ��
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.left = e2;
						e2P.right = e1;
					}
				} else {
					if (e2P.left == e2) { // ���ʮ��
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.right = e2;
						e2P.left = e1;
					} else { // ���ʮ��
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.right = e2;
						e2P.right = e1;
					}
				}
			}
		}
		return head;
	}
	public static Node[] getTwoErrParents(Node head,Node e1,Node e2) {
		Node[] parentNodes=new Node[2];
		if (head==null) {
			return parentNodes;
		}
		Stack<Node> stack=new Stack<������������������������Ľڵ�.Node>();
		while (!stack.isEmpty() ||head!=null) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			}else {
				head=stack.pop();
				if (head.left==e1 || head.right==e1) {
					parentNodes[0]=head;
				}
				if (head.left==e2 || head.right==e2) {
					parentNodes[1]=head;
				}
				head=head.right;
			}
		}
		return parentNodes;
	}
	
}
