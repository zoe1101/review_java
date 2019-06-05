package ����;
/*
�ϲ� k �������������غϲ������������������������㷨�ĸ��Ӷȡ�

����:
[
  1->4->5,
  1->3->4,
  2->6
]
���: 1->1->2->3->4->4->5->6
 */

import ����.�ϲ�������������.ListNode;

public class �ϲ�K���������� {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
//���÷���˼�룬�����ϲ�
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists==null || lists.length==0) {
			return null;
		}
    	int len=lists.length;
    	if (len==1) {
			return lists[0];
		}
    	int interval=1; //�ϲ����
    	while (interval<len) {
			for (int i = 0; i < len-interval; i=i+interval*2) {//
				lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
			}
			interval=interval*2;
		}
    	return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1==null || l2==null) {
			return l1!=null?l1:l2;
		}
	    ListNode head = null;//declare head as new Node,use to return.
	    if (l1.val <= l2.val){
	        head = l1;
	        head.next = mergeTwoLists(l1.next, l2);
	    } else {
	        head = l2;
	        head.next = mergeTwoLists(l1, l2.next);
	    }
	    return head;
    }
}
