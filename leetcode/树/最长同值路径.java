package ��;
/*
����һ�����������ҵ����·�������·���е�ÿ���ڵ������ֵͬ��
 ����·�����Ծ���Ҳ���Բ��������ڵ㡣
ע�⣺�����ڵ�֮���·������������֮��ı�����ʾ��


����:

              5
             / \
            4   5
           / \   \
          1   1   5
���:
2

 */
import ��.��ǰ��������������й��������.TreeNode;
public class �ֵͬ·�� {
	private int maxL = 0;
    public int longestUnivaluePath(TreeNode root) {
    	if(root == null) return 0;
        getMaxL(root, root.val);
        return maxL;
    }
	private int getMaxL(TreeNode root, int val) {
		if (root==null) {
			return 0;
		}
		int left = getMaxL(root.left, root.val);
        int right = getMaxL(root.right, root.val);
        maxL = Math.max(maxL, left+right); // ·������Ϊ�ڵ�����1���Դ˴�����1
        if(root.val == val) { // �͸��ڵ�ֵ��ͬ�ŷ����Ե�ǰ�ڵ����ܹ��ɵ��֪ͨ·������, ���򷵻�0
            return Math.max(left, right) + 1;
        }
        return 0;
		
	}
}
