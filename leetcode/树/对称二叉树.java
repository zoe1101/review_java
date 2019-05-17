package ��;
/**
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�
���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�
    1
   / \
  2   2
 / \ / \
3  4 4  3

 *
 */
public class �Գƶ����� {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root, root);
    }
    /**
     * 
     * @param root1 :������
     * @param root2:������
     * @return
     */
    public static boolean isMirror(TreeNode root1,TreeNode root2) {
		if (root1==null && root2==null) {
			return true;
		}
		if (root1==null || root2==null) {
			return false;
		}
		return  root1.val==root2.val 
				&& isMirror(root1.right, root2.left)
				&& isMirror(root1.left, root2.right);
	}
}
