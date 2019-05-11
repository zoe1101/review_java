package ����;

import java.util.Stack;


/*
���ж�һ�������Ƿ�Ϊ��������

����: 1->2->2->1
���: true

�� O(n) ʱ�临�ӶȺ� O(1) �ռ临�Ӷ�
 */
//ʹ�ÿ���ָ���ҵ�������е�
public class �жϻ������� {
	
//	���ÿ���ָ���ҵ��м䣬Ȼ������ĺ�벿�ַ�ת�������ν��бȽ�.
	//���Ҫ��һЩ
    public static boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null) return true;
        ListNode fast=head; //��ָ��
        ListNode slow=head;  //��ָ��
        // ���ݿ���ָ�룬�ҵ�������е�
        while(fast.next!=null &&fast.next.next!=null) {
        	fast=fast.next.next; //һ���ƶ�����
        	slow=slow.next;      //һ���ƶ�һ��
        }
        fast=slow.next; //��벿�ֵĵ�һ���ڵ�
        slow.next=null;
        ListNode right=null;
        while (fast!=null) { //�����벿�ַ�ת
			right=fast.next; //right->������һ���ڵ�
			fast.next=slow; //��һ����ת�ڵ�
			slow=fast; //��ָ���ƶ�
			fast=right;  //��ָ���ƶ�
		}
        right=slow;
        fast=head;
        boolean res=true;
        
        while (slow!=null && fast!=null) { //�ж��Ƿ��ǻ��ĵ�
        	if(slow.val!=fast.val) {
        		return false;
        	}
        	fast=head.next; //���ҵ��в�
        	slow=slow.next;	 //�����в�	
		}
        slow=right.next;
        right.next=null;
        while (slow!=null) {//����ָ�
			fast=slow.next;
			slow.next=right;
			right=slow;
			slow=fast;
		}
        return res;
    }
    
    
    //����ջ�������ǰ���ѹջ��Ȼ���ջ������ĺ�������ȶԡ�
    //���м�λ�õķ����ǿ���ָ�롣
    public static boolean isPalindrome2(ListNode head) {
    	if(head==null ||head.next==null) return true;
    	Stack<ListNode> stack=new Stack<ListNode>();
    	ListNode fast=head;
    	ListNode slow=head;
    	 //����ջ��˼��
    	while (fast!=null && fast.next!=null ) {
			stack.push(slow);
			slow=slow.next;
			fast=fast.next.next;
		}
    	//���Ϊ������
    	if(fast!=null) {
    		slow=slow.next;
    	}
    	while(!stack.isEmpty()) {
    		if(stack.pop().val!=slow.val) {
    			return false;
    		}
    		slow=slow.next;
    	}
    	return true;
    }
    	
	public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(isPalindrome2(node1));
        System.out.println(isPalindrome(node1));
	}

}
