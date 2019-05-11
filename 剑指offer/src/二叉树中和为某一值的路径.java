package src;

import java.util.ArrayList;

/**
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ
 * @author zoe
 *
 */
public class �������к�Ϊĳһֵ��·�� {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//ʹ��ǰ������ķ�ʽ���ʽڵ�
	/*
	 * ���Ⱦ���Ҫ�ѵ�ǰ��㣨�����Ǹ���㣩��ӵ�·���ͬʱtarget ��ȥ��ǰ����ֵ��
	 * Ȼ�������ǰ���ΪҶ�ڵ㲢�Һ�Ҳ�ﵽ����ֵ���Ͱ����·����ӵ��б������һֱ������ȥ��
	 * ��󣬱�����Ҷ�ڵ�֮�󣬷����ϲ���֮ǰ��һ��Ҫ�����һ������·����ɾ��
	 * 
	�ѷ���������·����ӵ��б��е�ʱ����Ϊadd��ӵ������ã��������ÿ�ζ�newһ��path�Ļ�������list���浽��ֻ�����һ��path
	 */
  	 ArrayList<Integer> path = new ArrayList<Integer>();
	 ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	 if(root==null) return list;
    	//ÿ���ʵ�һ������ʱ�򣬶��ѵ�ǰ�Ľ����ӵ�·����ȥ��������target��ֵ
    	 path.add(root.val);
    	 target-=root.val;
    	 //�ѵ�Ҷ�ڵ㲢�Һ�Ϊtarget����ѵ�ǰ·����ӵ�����б���
         //��Ϊadd��ӵ������ã������newһ���Ļ�������list���浽��ֻ�����һ��path
    	 if(target==0 && root.left==null && root.right==null) {
    		 list.add(new ArrayList<Integer>(path));
    	 }
    	 //�����������
    	 FindPath(root.left, target);
    	 FindPath(root.right, target);
    	 
    	//�ѵ�Ҷ�ڵ�֮������������ݹ麯��������,��ʱҪ�����һ������·����ɾ��,���ܷ����ϲ���
    	 path.remove(path.size()-1);
    	 return list;
    }
}
