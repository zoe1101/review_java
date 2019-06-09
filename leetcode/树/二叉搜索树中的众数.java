package ��;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
��һ������ֵͬ�Ķ�����������BST�����ҳ� BST �е���������������Ƶ����ߵ�Ԫ�أ���

�ٶ� BST �����¶��壺

�������������������ֵС�ڵ��ڵ�ǰ����ֵ
�������������������ֵ���ڵ��ڵ�ǰ����ֵ
�����������������Ƕ���������
���磺
���� BST [1,null,2,2],

   1
    \
     2
    /
   2
����[2].

 */
import ��.��ǰ��������������й��������.TreeNode;
public class �����������е����� {
	List<Integer> res = new ArrayList<>();
	TreeNode pre;
	int curTimes=1,maxTimes=1;
    public int[] findMode(TreeNode root) {
    	if (root==null) {
			return new int[] {};
		}
    	inorder(root);
    	int[] ans=new int[res.size()]; 
    	for (int i = 0; i <res.size(); i++) {
    		ans[i]=res.get(i);
		}
    	return ans;
    }
    private void inorder(TreeNode root) {
    	if (root==null) {
			return ;
		}
    	inorder(root.left);
    	if (pre!=null) {
			if (pre.val==root.val) {
				curTimes++;
			}else {
				curTimes=1;
			}
		}
    	if (curTimes==maxTimes) {
			res.add(root.val);
		}
    	if (curTimes>maxTimes) {
			res.clear();
			res.add(root.val);
			maxTimes=curTimes;
		}
    	pre=root;
    	inorder(root.right);
    }
}
