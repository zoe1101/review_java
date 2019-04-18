package 树;
 
//时间复杂度为O(N), 额外空间复杂度为O(1)
//利用的是线索二叉树思想
public class Morris遍历二叉树 {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	/**
	 * Morris 先序遍历二叉树(第一次发现节点就打印：①左子树的右孩子为空时打印 ②无左子树时打印)
	 * @param node
	 */
	public static void preorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("树为空");
			return;
		}
		TreeNode cur=node;
		TreeNode next=null;
		while (cur!=null) {
			next=cur.left;
			if(next!=null) {
				while (next.right!=null & next.right!=cur) {//找到左子树最右节点
					next=next.right;
				}
				if(next.right==null) { //最右点的右指针指向null
					next.right=cur; //右指针指向当前节点
					System.out.print(cur.val + " ");
					cur=cur.left;  //当前node向左孩子移动
					continue;
				}else { //最右点的右指针已经指向当前节点，让它指向null
					next.right=null;
				}
			}else {
				System.out.print(cur.val + " ");
			}
			cur = cur.right;              //当前node向右孩子移动
		}
		System.out.println();
	}
	
	/**
	 * Morris中序遍历二叉树(node每次往右移之前打印节点)
	 * @param node
	 */
	public static void inorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("树为空");
			return;
		}
		TreeNode cur=node;//当前node
		TreeNode next = null;//当前node左子树最右的节点
		while (cur!=null) {
			next=cur.left;
			if(next!=null) { //左节点存在
				while (next.right!=null && next.right!=cur) {// 不等于cur，说明未遍历过，设置线索，并跳到该左子树
					next=next.right;
				}
				if(next.right==null) { //说明该左子树已处理完毕，恢复原指针
					next.right=cur;
					cur=cur.left;
					continue;
				}else { //该节点的左子树已处理完毕,转向右子树
					next.right=null;
				}
			}
			System.out.print(cur.val+" ");
			cur=cur.right;
		}
		System.out.println();
	}
	
	/**
	 *Morris后序遍历二叉树(当第二次回到node时，逆序打印左子树的右边界，在打印整树的右边界) 
	 * @param node
	 */
	public static void postorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("树为空");
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
