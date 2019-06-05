package ��;

import java.util.HashMap;
import java.util.Map;

/*
�ڶ������У����ڵ�λ����� 0 ����ÿ�����Ϊ k �Ľڵ���ӽڵ�λ����� k+1 ����
����������������ڵ������ͬ�������ڵ㲻ͬ����������һ�����ֵܽڵ㡣
���Ǹ����˾���Ψһֵ�Ķ������ĸ��ڵ� root���Լ�����������ͬ�ڵ��ֵ x �� y��
ֻ����ֵ x �� y ��Ӧ�Ľڵ������ֵܽڵ�ʱ���ŷ��� true�����򣬷��� false��


���룺root = [1,2,3,4], x = 4, y = 3
�����false

���룺root = [1,2,3,null,4,null,5], x = 5, y = 4
�����true
 */
public class �����������ֵܽڵ� {
	public class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
		}
	
	//���ù�ϣ��洢��ǰ�ڵ�ĸ��ڵ�����ڲ��
	Map<Integer,Integer> parentMap = new HashMap<>();
    Map<Integer,Integer> levelMap = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null ||(root.left==null && root.right==null)) {
			return false;
		}
        helper(root,null,1,x,y);
        return parentMap.get(x)!=parentMap.get(y) && levelMap.get(x)==levelMap.get(y);
    }
	private void helper(TreeNode root, TreeNode parent, int level, int x, int y) {
		if (root==null) {
			return ;
		}
		if (parent!=null && (root.val==x || root.val==y)) {
			parentMap.put(root.val,parent.val);
			levelMap.put(root.val, level);
		}
		helper(root.left, root, level+1, x, y);
		helper(root.right, root, level+1, x, y);
		
	}
}
