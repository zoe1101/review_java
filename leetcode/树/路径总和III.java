package ��;
/*
����һ��������������ÿ����㶼�����һ������ֵ��

�ҳ�·���͵��ڸ�����ֵ��·��������

·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��

������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

���� 3���͵��� 8 ��·����:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11

 */
import ��.��ǰ��������������й��������.TreeNode;
public class ·���ܺ�III {
	int pathnumber;
    public int pathSum(TreeNode root, int sum) {
        if (root==null) {
			return 0;
		}
        Sum(root,sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathnumber;
    }

	private void Sum(TreeNode root, int sum) {
		if (root==null) {
			return;
		}
		sum-=root.val;
		if (sum==0) {
			pathnumber++;
		}
		Sum(root.left, sum);
		Sum(root.right, sum);
	}
}
