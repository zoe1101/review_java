package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * @author zoe
 *
 */
public class ����������� {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	 //�ݹ�
    public int TreeDepth(TreeNode root) {
        if (root==null) {
			return 0;
		}
        int left=TreeDepth(root.left); //�����������
        int right=TreeDepth(root.right); //�����������
        return left>right?left+1:right+1;
    }
    
    //�ǵݹ�,������ȱ���/�������
    public int TreeDepth2(TreeNode root) {
    	if (root==null) {
			return 0;
		}
    	int depth=0;
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root); //�ȰѸ��ڵ�ӽ�ȥ
    	while (!queue.isEmpty()) {
			int size=queue.size();
			TreeNode curNode=null;
			for(int i=0;i<size;i++) {
				curNode=queue.poll();
				if(curNode.left!=null) {
					queue.offer(curNode.left);
				}
				if(curNode.right!=null) {
					queue.offer(curNode.right);
				}
			}
			depth++;
		}
    	return depth;
    }
}
