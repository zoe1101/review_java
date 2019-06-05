package ��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ��.�������ĺ������.TreeNode;

/*
����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��

����:
����������: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
�������α��������

[
  [3],
  [9,20],
  [15,7]
]
 */
public class �������Ĳ�α��� {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
   }
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> resList=new ArrayList<List<Integer>>();
    	if (root==null) {
			return resList;
		}
    	
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
			int size=queue.size();
			List<Integer> one=new ArrayList<Integer>();
			while (size-->0) {
				TreeNode curNode=queue.poll();
				one.add(curNode.val);
				if (curNode.left!=null) {
					queue.add(curNode.left);
				}
				if (curNode.right!=null) {
					queue.add(curNode.right);
				}
			}
			resList.add(one);
		}
    	return resList;
        
    }
}
