package ��;
/*
Given a binary tree, collect a tree's nodes as if you were doing this: 
Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
 */

import java.util.ArrayList;
import java.util.List;

import ��.��֤����������.TreeNode;
public class Ѱ����ȫ��������Ҷ�ӽڵ� {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> resLists=new ArrayList<>();
		height(root,resLists);
		return resLists;
	}
//���㵱ǰnode��leaf�ľ���Ϊ��ǰnode�ĸ߶ȣ���ͬ�߶ȵĵ����ͬһ��list��.
	private int height(TreeNode root, List<List<Integer>> resLists) {
		if (root==null) {
			return -1;
		}
		int h=Math.max(height(root.left, resLists), height(root.left, resLists))+1;
		if (resLists.size()<=h) {
			resLists.add(new ArrayList<Integer>());
		}
		resLists.get(h).add(root.val);
		return h;
	}
}
