package ��;
import ��.��֤����������.TreeNode;
/*
��תһ�ö�������

ʾ����

���룺

     4
   /   \
  2     7
 / \   / \
1   3 6   9
�����

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
public class ��ת������ {
	
	//BFS
    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
			return null;
		}
        //������ǰ�ڵ������ӽڵ�
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        //�����������ӽڵ�Ϊ���ڵ�����ӽڵ�ķ�ת
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
}
