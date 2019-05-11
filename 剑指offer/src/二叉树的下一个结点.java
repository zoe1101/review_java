package src;
/*
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */
public class ����������һ����� {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
/*
1������ý��������������ý�����һ�����Ϊ�ý����������������㡣
2������ý��û�������������ַ�����������ۣ�
���һ������ý��Ϊ�ý��ĸ��������ӣ���ý��ĸ����pNode.next��Ϊ��һ����㡣
�����������ý��Ϊ�ý��ĸ������Һ��ӣ���ý��ĸ����ĸ����ĸ���㣬
 	    ֱ�����е�һ���������������������ӣ���ø����ĸ����Ϊ��һ����㡣
 * 
 */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
    	if (pNode==null) {
			return null;
		}
    	if(pNode.right!=null) {//����ý����������
    		pNode=pNode.right;
    		while (pNode.left!=null) {
				pNode=pNode.left;
			}
    		return pNode;
    	}
    	while (pNode.next!=null) {
			if (pNode.next.left==pNode) { //�ý��Ϊ�ý��ĸ���������
				return pNode.next;
			}
			pNode=pNode.next;
		}
    	return null;  
    }
}
