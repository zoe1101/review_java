package ��;

import java.util.ArrayList;
import java.util.List;

/*
����һ������������������ ǰ�� ������

 ʾ��:

����: [1,null,2,3]  
   1
    \
     2
    /
   3 

���: [1,2,3]
 */
public class ��������ǰ����� {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
    }
	List<Integer> resList=new ArrayList<Integer>();
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root==null) {
			return resList;
		}
		resList.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return resList;
	        
    }
}
