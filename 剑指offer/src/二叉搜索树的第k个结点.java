package src;

import java.util.LinkedList;

import javax.swing.text.html.HTML.Tag;

/*
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
 * ���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 */
public class �����������ĵ�k����� {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    
//    �ǵݹ��������
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if(pRoot==null||k<0){
            return null;
        }
        TreeNode curNode=pRoot; //ָ��ǰ�ڵ�
        TreeNode KNode=null;
        int count=0;
        LinkedList<TreeNode> stack=new LinkedList<>();
        //�������������
        while(!stack.isEmpty()||curNode!=null){
            while(curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }
            if(!stack.isEmpty()){
                curNode=stack.pop();
                count++;
                if(k==count){
                    KNode=curNode;
                    break;
                }
                curNode=curNode.right;
            }
        }
        return KNode;
    }
    
//	�ݹ��������ʵ��
	int count=0;
    TreeNode KthNode(TreeNode pRoot, int k){
    	if (pRoot==null || k<0) {
			return null;
		}
    	TreeNode target=null;
    	if (pRoot.left!=null) {
    		target =KthNode(pRoot.left, k);
		}
    	count++;
    	if (target==null) {
			if (count==k) {
				target=pRoot;
				return target;
			}
		}
    	if (target==null && pRoot.right!=null) {
			target=KthNode(pRoot.right, k);
		}
    	return target;
    }
}
