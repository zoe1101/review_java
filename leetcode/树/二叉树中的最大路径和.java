package ��;
/*
����һ���ǿն����������������·���͡�

�����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣

ʾ�� 1:

����: [1,2,3]

       1
      / \
     2   3

���: 6

 */
import ��.��ǰ��������������й��������.TreeNode;
public class �������е����·���� {
    /**
    ��������һ���ڵ�, �������·�������ýڵ�, ��ôֻ�������������:
    1. �����������������ɵĺ�·��ֵ�ϴ���Ǹ����ϸýڵ��ֵ���򸸽ڵ���ݹ������·��
    2. ���������������·����, ���ϸýڵ��ֵ���������յ����·��
    **/
	private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	getMax(root);
        return res;
    }
	private int getMax(TreeNode root) {
		if (root==null) {
			return 0;
		}
		int left=Math.max(0, getMax(root.left)); // �������·����Ϊ����Ӧ����0��ʾ���·������������
		int right=Math.max(0, getMax(root.right));
        //�Ե�ǰ�ڵ�Ϊ���ڵ�,�ж��ڸýڵ��������������·�����Ƿ���ڵ�ǰ���·����
		res=Math.max(res, root.val+left+right);
        //��ǰ�ڵ���Ϊ���ڵ��һ���ӽڵ�͸��ڵ����ӵĻ�����ȡ�����˵����ֵ������
		return Math.max(left, right)+root.val;
		
	}
}
