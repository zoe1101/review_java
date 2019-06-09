package 链表;

import java.awt.Frame;

import vivo软件大类提前批.Main2.Node;
import 链表.反转链表.ListNode;

/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

 */
//部分反转
public class 反转链表II {
	 public class ListNode {
		 int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	int len=0;
    	ListNode mpre=null;
    	ListNode npos=null;
    	ListNode cur1=null;
    	while (cur1!=null) {
			len++;
			mpre=len==m-1?cur1:mpre;
		}
    	
    }
	
	

}
