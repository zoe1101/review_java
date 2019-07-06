package ��;
import ��.MaxHeap;
/*
���� 
��һ�ö��������ҵ������·���ĳ��ȡ� 
����·����ָ �κεĽڵ������е���ʼ�ڵ㵽���е���һ�ڵ㶼������ѭ ��-�� ��ϵ��
�������·�������ǴӸ��׽ڵ㵽���ӽڵ㣨�������򣩡�

���� 
�ٸ����ӣ�

   1
    \
     3
    / \
   2   4
        \
         5
1
2
3
4
5
6
7
�������·��Ϊ 3-4-5�����Է��� 3��

   2
    \
     3
    / 
   2    
  / 
 1
1
2
3
4
5
6
7
�������·��Ϊ 2-3 ,������ 3-2-1 �����Է��� 2��

 */
import ��.��֤����������.TreeNode;
public class ��������������� {
	private int maxlen=0;
	public int longestConsecutive(TreeNode root) {
		longestConsecutive(root,0,0);
		return maxlen;
	}
	//�ݹ�������������ݹ麯�����븸�ڵ��ֵ���԰����ӽڵ��ж��Ƿ�������
	private void longestConsecutive(TreeNode root, int preVal, int curlen) {
		if (root==null) {
			return;
		}
		if (root.val!=preVal+1) {
			curlen=1;
		}else {
			curlen++;
		}
		maxlen=Math.max(curlen, maxlen);
		longestConsecutive(root.left, root.val, curlen);
		longestConsecutive(root.right, root.val, curlen);
	}
}
