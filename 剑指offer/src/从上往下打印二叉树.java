package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * �������������
 * @author zoe
 *
 */
public class �������´�ӡ������ {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	// ���ݲ���������ص㣬���Ǻ������뵽ʹ�ö��У����ù�����ȱ����ķ�ʽ�����б���
	
//	�ǵݹ�ʵ��
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	//����һ��list����������Ҫ��ӡ�Ľڵ��val
        ArrayList<Integer> list= new ArrayList<Integer>();
        if(root==null) {
        	return list;
        }
        ArrayList<TreeNode> queue=new ArrayList<TreeNode>(); //����һ��queue��������ӡ�ڵ��˳��
        queue.add(root);//���Ƚ��������ĸ��ڵ㴫�뵽����������
      
        while (queue.size()!=0) {//ѭ����������������Ϊ��
			TreeNode tmp=queue.remove(0);//ArrayList ��remove��ɾ���ýڵ㲢���ýڵ㷵��
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
			list.add(tmp.val);
		}
        return list;
    }
}
