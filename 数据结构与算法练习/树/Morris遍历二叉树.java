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
	 * Morris��  , �����ظ���ӡ�����
	 * @param node
	 */
	public static void morrisTraversal(TreeNode node) {
		if(node==null) return;
		TreeNode curNode=node;
		TreeNode mostRightNode=null;
		while (curNode!=null) {
			mostRightNode=curNode.right;  
			if(mostRightNode!=null) {//��ǰ�ڵ���������
				//�ҵ���ǰ�ڵ������������ҵĽڵ�
				while(mostRightNode.right!=null &&mostRightNode.right!=curNode) {
					mostRightNode=mostRightNode.right;
				}
				if(mostRightNode.right==null) {
					mostRightNode.right=curNode;
					curNode=curNode.left;
					continue; //�ص�������while�������ж�curNode�����
				}else { //���ҵĽڵ�ָ��ǰ�ڵ�ʱ
					mostRightNode.right=null;
				}
			}
			curNode=curNode.right; //��ǰ�ڵ�û���������������������ҽڵ����ָ��ָ��ǰ�ڵ�ʱ���������ƶ�
		}
	}
    /** Morris �������������(��һ�η��ֽڵ�ʹ�ӡ�������������Һ���Ϊ��ʱ��ӡ ����������ʱ��ӡ)
	 * @param node
	 */
	public static void preorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("��Ϊ��");
			return;
		}
		TreeNode cur=node;
		TreeNode mostRight=null;
		while (cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) {
				while (mostRight.right!=null & mostRight.right!=cur) {//�ҵ������������ҽڵ�
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) { //���ҵ����ָ��ָ��null
					mostRight.right=cur; //��ָ��ָ��ǰ�ڵ�
					System.out.print(cur.val + " ");
					cur=cur.left;  //��ǰnode�������ƶ�
					continue; //�ص�������while�������ж�curNode�����
				}else { //���ҵ����ָ���Ѿ�ָ��ǰ�ڵ㣬����ָ��null
					mostRight.right=null;
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
		TreeNode cur=node;//��ǰ�ڵ�
		TreeNode mostRight = null;//��ǰ�ڵ����������ҵĽڵ�
		while (cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) { //��������
				while (mostRight.right!=null && mostRight.right!=cur) {//�ҵ������������ҽڵ�
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) { //˵�����������Ѵ�����ϣ��ָ�ԭָ��
					mostRight.right=cur;
					cur=cur.left;
					continue;
				}else { //�ýڵ���������Ѵ������,ת��������
					mostRight.right=null;
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
		TreeNode mostRight=null;
		while (cur!=null){
			mostRight=cur.left;
			if(mostRight!=null) {
				while (mostRight.right!=null && mostRight.right!=cur) {
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) {
					mostRight.right=cur;
					cur=cur.left;
					continue;
				}else {//�ڶ��ε���ʱ
					mostRight.right=null;
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
