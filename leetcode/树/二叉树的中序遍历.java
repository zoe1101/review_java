package ��;

import java.util.ArrayList;
import java.util.List;

/*
����һ���������������������� ������

ʾ��:

����: [1,null,2,3]
   1
    \
     2
    /
   3

���: [1,3,2]
 */
public class ��������������� {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
    }
	List<Integer> resList=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	if (root==null) {
			return resList;
		}
    	inorderTraversal(root.left);
    	resList.add(root.val);
    	inorderTraversal(root.right);
    	return resList;
    }


}
