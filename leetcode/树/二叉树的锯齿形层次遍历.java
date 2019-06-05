package ��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
����һ����������������ڵ�ֵ�ľ���β�α����������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���

���磺
���������� [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
���ؾ���β�α������£�
[
  [3],
  [20,9],
  [15,7]
]
 *
 */
public class �������ľ���β�α��� {
//���ù�����ȱ���
	public class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> resList=new ArrayList<List<Integer>>();
    	if (root==null) {
			return resList;
		}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int index = 1; //��ż�ж�
        while (!queue.isEmpty()) {
            int size = queue.size(); //ÿһ�е�Ԫ�ظ���
            List<Integer> one = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curNode = queue.poll();
                one.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            if (index % 2 == 0) { //ż������Ҫ��ת
                Collections.reverse(one);
            }
            index++;
            resList.add(one);
        }
        return resList;
    }
}
