package src;
/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author zoe
 *
 */
public class �ϲ�������������� {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public ListNode Merge(ListNode head1,ListNode head2) {
        if(head1==null || head2==null) {
        	return head1==null?head2:head1;
        }
//      �ȱȽ�1��2��ͷ�����ֵ�Ĵ�С����С��ֵ�Ľ�㣨����Ϊ����1ͷ��㣩��Ϊ�ϲ������������3����ͷ��㡣
        ListNode head=head1.val<head2.val?head1:head2;
        ListNode cur1=head==head1?head1:head2; 
        ListNode cur2=head==head1?head2:head1; 
        ListNode pre=null;
        ListNode next=null;
        while (cur1!=null && cur2!=null) {
			if(cur1.val<=cur2.val) {
				pre=cur1;
				cur1=cur1.next;
			}else {
				next=cur2.next;
				pre.next=cur2;
				cur2.next=cur1;
				pre=cur2;
				cur2=next;
			}
		}
        pre.next=cur1==null?cur2:cur1;  //�������1�����꣬�������ʣ�ಿ��ƴ��head����
        return head;
    }
}
