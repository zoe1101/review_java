package ��;

import java.util.ArrayList;
import java.util.List;

public class �������ĺ������ {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
    }
	List<Integer> resList=new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
		if (root==null) {
			return resList;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		resList.add(root.val);
		return resList;
	        
    }
}
