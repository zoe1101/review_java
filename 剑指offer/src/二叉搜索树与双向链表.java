package src;
/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * @author zoe
 *
 */
public class ������������˫������ {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    TreeNode pCurNode=null; //��������ǰ���
    TreeNode pHead = null; //��������ͷ���Ľ��
  //����ݹ�����޸�����ָ�뼴��ʵ��
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) {
        	return null;
        }
        Convert(pRootOfTree.left); //������
        if(pCurNode==null) {//���ڵ�
        	pCurNode=pRootOfTree;
        	pHead=pRootOfTree;
        }else {
        	pCurNode.right=pRootOfTree;
        	pRootOfTree.left=pCurNode;
        	pCurNode=pRootOfTree;
        }
        Convert(pRootOfTree.right); 
        return pHead;
    }
}
