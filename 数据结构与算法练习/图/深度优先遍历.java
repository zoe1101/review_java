package ͼ;

import java.util.Stack;

//�Զ�����Ϊ��

public class ������ȱ��� {

	public static class ListNode {
		ListNode left;
        ListNode right;
        int val;
        public ListNode(int value){
            this.val=value;
        }
	}

	public static void depthTraversal(ListNode node) {
		if(node==null) {
			 System.out.print("empty tree");
             return;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
	       stack.push(node); //�ȰѸ��ڵ�ѹ��ջ
	       while(!stack.isEmpty()){
	             ListNode rnode = stack.pop();
	             System.out.print(rnode.val);
	             if(rnode.right!=null){
	                   stack.push(rnode.right);
	             }
	             if(rnode.left!=null){
	                   stack.push(rnode.left);
	             }
	       }
	}
	    
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
