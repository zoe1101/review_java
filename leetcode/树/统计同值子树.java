package ��;
/*
 Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
return 4.

��һ������������Ψһֵ�����ĸ�����Ψһֵ���������нڵ������ֵͬ��
 */

import ��.��֤����������.TreeNode;
public class ͳ��ֵͬ���� {
	public int countUnivalSubtrees(TreeNode root) {
        int count =0;
        isUnivalSubtrees(root,count);
        return count;
    }
     
    private boolean isUnivalSubtrees(TreeNode root, int count) {
        if(root == null) return true;
        if(isUnivalSubtrees(root.left, count) && isUnivalSubtrees(root.right, count)) {
            if(root.left != null && root.left.val != root.val ||
        	   root.right != null && root.right.val != root.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}
