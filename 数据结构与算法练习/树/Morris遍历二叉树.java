package ��;
 
//ʱ�临�Ӷ�ΪO(N), ����ռ临�Ӷ�ΪO(1)
//���õ�������������˼��
public class Morris���������� {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	/**
	 * Morris �������������(��һ�η��ֽڵ�ʹ�ӡ�������������Һ���Ϊ��ʱ��ӡ ����������ʱ��ӡ)
	 * @param node
	 */
	public static void preorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("��Ϊ��");
			return;
		}
		TreeNode cur=node;
		TreeNode next=null;
		while (cur!=null) {
			next=cur.left;
			if(next!=null) {
				while (next.right!=null & next.right!=cur) {//�ҵ����������ҽڵ�
					next=next.right;
				}
				if(next.right==null) { //���ҵ����ָ��ָ��null
					next.right=cur; //��ָ��ָ��ǰ�ڵ�
					System.out.print(cur.val + " ");
					cur=cur.left;  //��ǰnode�������ƶ�
					continue;
				}else { //���ҵ����ָ���Ѿ�ָ��ǰ�ڵ㣬����ָ��null
					next.right=null;
				}
			}else {
				System.out.print(cur.val + " ");
			}
			cur = cur.right;              //��ǰnode���Һ����ƶ�
		}
		System.out.println();
	}
	
	/**
	 * Morris�������������(nodeÿ��������֮ǰ��ӡ�ڵ�)
	 * @param node
	 */
	public static void inorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("��Ϊ��");
			return;
		}
		TreeNode cur=node;//��ǰnode
		TreeNode next = null;//��ǰnode���������ҵĽڵ�
		while (cur!=null) {
			next=cur.left;
			if(next!=null) { //��ڵ����
				while (next.right!=null && next.right!=cur) {// ������cur��˵��δ��������������������������������
					next=next.right;
				}
				if(next.right==null) { //˵�����������Ѵ�����ϣ��ָ�ԭָ��
					next.right=cur;
					cur=cur.left;
					continue;
				}else { //�ýڵ���������Ѵ������,ת��������
					next.right=null;
				}
			}
			System.out.print(cur.val+" ");
			cur=cur.right;
		}
		System.out.println();
	}
	
	/**
	 *Morris�������������(���ڶ��λص�nodeʱ�������ӡ���������ұ߽磬�ڴ�ӡ�������ұ߽�) 
	 * @param node
	 */
	public static void postorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("��Ϊ��");
			return;
		}
		TreeNode cur=node;
		TreeNode next=null;
		while (cur!=null){
			next=cur.left;
			if(next!=null) {
				while (next.right!=null && next.right!=cur) {
					next=next.right;
				}
				if(next.right==null) {
					next.right=cur;
					cur=cur.left;
					continue;
				}else {
					next.right=null;
					printEdge(cur.left);
				}
			}
			cur=cur.right;
		}
		printEdge(node);
		System.out.println();
	}
	
	public static void printEdge(TreeNode head) {
		TreeNode tail = reverseEdge(head);
		TreeNode cur = tail;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}
	
	public static TreeNode reverseEdge(TreeNode from) {
		TreeNode pre = null;
		TreeNode next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}

	// print tree
		public static void printTree(TreeNode head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}
	 
		public static void printInOrder(TreeNode head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.val + to;
			int lenM = val.length();
			int lenL = (len - lenM) / 2;
			int lenR = len - lenM - lenL;
			val = getSpace(lenL) + val + getSpace(lenR);
			System.out.println(getSpace(height * len) + val);
			printInOrder(head.left, height + 1, "^", len);
		}
	 
		public static String getSpace(int num) {
			String space = " ";
			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < num; i++) {
				buf.append(space);
			}
			return buf.toString();
		}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(4);
		head.left = new TreeNode(2);
		head.right = new TreeNode(6);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(7);
		printTree(head);
		preorderMorrisTraversal(head);
		inorderMorrisTraversal(head);
		postorderMorrisTraversal(head);
		printTree(head);
	}

}
