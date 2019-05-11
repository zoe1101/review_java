package src;

import java.util.Stack;

/**
 * �������������ҳ����ǵĵ�һ��������㡣
 * @author zoe
 *�������������ڹ�����㣬��ô���Ǵӹ�����㿪ʼһֱ������Ľ�β����һ����
 */
public class ��������ĵ�һ��������� {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	//����ջ
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	 Stack<ListNode> stack1=new Stack<ListNode>();
    	 Stack<ListNode> stack2=new Stack<ListNode>();
    	 while (pHead1!=null) {
			stack1.push(pHead1);
			pHead1=pHead1.next;
		}
      	 while (pHead2!=null) {
 			stack2.push(pHead2);
 			pHead2=pHead2.next;
 		}
      	 
      	 ListNode res=null;
      	 while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek()==stack2.peek()) {
			stack1.pop();
			res=stack2.pop();
		}
      	 return res;
    }
    
//���ҳ�2������ĳ���,Ȼ���ó���������������ĳ��Ȳ�,Ȼ����һ����,ֱ���ҵ���һ��������㡣
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null) {
            return null;
    	}
    	int count1=0;
    	int count2=0;
    	ListNode p1=pHead1;
    	ListNode p2=pHead2;
    	while (p1!=null) {
			p1=p1.next;
			count1++;
		}
    	while (p2!=null) {
			p2=p2.next;
			count2++;
		}
    	if(count1>count2) {
    		int dif=count1-count2;
    		while (dif!=0) {
				pHead1=pHead1.next;
				dif--;
			}
    	}else {
    		int dif=count2-count1;
    		while (dif!=0) {
				pHead2=pHead2.next;
				dif--;
			}
		}
    	while (pHead1!=null &&pHead2!=null) {
			if(pHead1==pHead2) {
				return pHead1;
			}
			pHead1=pHead1.next;
			pHead2=pHead2.next;
		}
    	return null;
    }
}
