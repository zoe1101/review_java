package src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 * 
 * ��νṹ��ӡ:����ʵ��
 * ��Ҫ����������һ��start��¼��ǰ���Ѿ���ӡ�Ľڵ������һ��end��¼ǰ�������еĽڵ������
 * �� start == end ʱ����ʾ��ǰ��������ˣ��Ϳ��Կ�ʼ��һ�������
 */

public class �Ѷ�������ӡ�ɶ��� {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
    	if (pRoot==null) {
    		return res;
		}
    	ArrayList<Integer> temp=new ArrayList<Integer>();
    	Queue<TreeNode> layer=new LinkedList<TreeNode>(); //�����ڵ�
    	layer.offer(pRoot); //��һ��,һ���ڵ�
    	int start=0, end=1;
    	while (!layer.isEmpty()) {
			TreeNode node=layer.poll();
			temp.add(node.val);
			start++;
			//�ڵ�ǰ��Ľڵ㵯�������У�����һ��Ľڵ������Ӳ���
			if (node.left!=null) {
				layer.add(node.left);
			}
			if (node.right!=null) {
				layer.add(node.right);
			}
			//��ǰ��ڵ㵯�����ˣ��Ե�ǰ���ݴ��б�temp,λ��ָ��start��end����
			if(start==end) {
				start=0;
				res.add(temp);
				temp=new ArrayList<Integer>();
				end=layer.size();
			}
		}
    	return res;
    }
}
