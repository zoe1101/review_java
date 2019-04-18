package ����;

import java.util.Stack;

/*
���������ǿ����������������Ǹ��������������λλ������ʼλ�á����ǵ�ÿ���ڵ�ֻ�洢�������֡�
����������ӻ᷵��һ���µ�����

����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��

����:
��������������޸ĸ���δ������仰˵���㲻�ܶ��б��еĽڵ���з�ת��

ʾ��:
����: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
���: 7 -> 8 -> 0 -> 7
 */

//�ѵ�: ��λ�Ĵ���; �����޷��������
//��ջ�ķ�ʽʵ��, ��ջ�����ÿһ����������
public class �������II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode result=new ListNode(0);
    	Stack<Integer>stack1=new Stack<Integer>();
    	Stack<Integer>stack2=new Stack<Integer>();
    	ListNode p=l1,q=l2;
    	int carry=0;
    	while (p!=null) {//��ջ
    		stack1.add(p.val);
    		p=p.next;
		}
    	while (q!=null) {//��ջ
    		stack2.add(q.val);
    		q=q.next;
		}
    	while(!stack1.isEmpty() ||!stack2.isEmpty()) {
    		int x=(!stack1.isEmpty())?stack1.peek():0;
    		int y=(!stack2.isEmpty())?stack2.peek():0;
    		int sum=carry+x+y;
    		carry=sum/10;
    	    ListNode cur=new ListNode(sum%10);
    		cur.next=result.next;
    		result.next=cur;
    		if (!stack1.isEmpty()) stack1.pop();
    		if (!stack2.isEmpty()) stack2.pop();
    	}
    	if(carry>0) {
    		ListNode cur=new ListNode(carry);
    		cur.next=result.next;
    		result.next=cur;
    	}
    	 return result.next;
    }
   
}
