package ����;
/*
 ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣

ʾ����
����һ������: 1->2->3->4->5, �� n = 2.
��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
 */
public class ɾ������ĵ�����N���ڵ� {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { 
	    	  this.val = x; 
    	  }
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode curNode=head;
		while (curNode!=null) {
			n--;
			curNode=curNode.next;
		}
		//Ŀ�����ҵ���N-n���ڵ�
		//һ�α�����n=n-N, N��������
		if (n==0) { //Ҫɾ�����ǵ�һ���ڵ�
			head=head.next;
		}
		if (n<0) {
			curNode=head;
			while (++n!=0) {
				curNode=curNode.next;
			}
			curNode.next=curNode.next.next; //ɾ��������n���ڵ�
		}
		return head;
	        
    }

}
