package src;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author zoe
 *
 */
public class 二叉搜索树与双向链表 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    TreeNode pCurNode=null; //定义链表当前结点
    TreeNode pHead = null; //定义链表头部的结点
  //中序递归遍历修改链表指针即可实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) {
        	return null;
        }
        Convert(pRootOfTree.left); //左子树
        if(pCurNode==null) {//根节点
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
