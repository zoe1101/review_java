package ����;
/*
�������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�

��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�

�����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��

ʾ����

���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 0 -> 8
ԭ��342 + 465 = 807
 */
public class ������� {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead=new ListNode(0); // ͷ���
    	ListNode p=l1,q=l2,cur=dummyHead;
    	int carry=0; //��λ��־
    	while (p!=null ||q!=null) {
    		int x=(p!=null)?p.val:0;
    		int y=(q!=null)?q.val:0;
    		int sum=carry+x+y;
    		carry=sum/10;  // ���ν�λ
    		cur.next=new ListNode(sum%10); // ��λ�Ľ��
    		cur=cur.next;
    		if(p!=null) p=p.next;
    		if(q!=null) q=q.next;
			
		}
    	 // ���һ����ӻ��н�λ
    	if(carry>0) {
    		cur.next=new ListNode(carry);
    	}
    	return dummyHead.next;   
    }

	public static void main(String[] args) {
		

	}

}
