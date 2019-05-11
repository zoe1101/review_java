package src;


/**
 * ����һ����������������е�����k����㡣
 * @author zoe
 *Ϊ���ܹ�ֻ����һ�ξ����ҵ�������k���ڵ㣬���Զ�������ָ�룺
������1����һ��ָ��������ͷָ�뿪ʼ������ǰ��k-1���ڶ���ָ�뱣�ֲ�����
������2���ӵ�k����ʼ���ڶ���ָ��Ҳ��ʼ�������ͷָ�뿪ʼ������
������3����������ָ��ľ��뱣����k-1������һ��������ǰ��ģ�ָ�뵽�������β���ʱ���ڶ���ָ�루���ں���ģ�ָ�������ǵ�����k����㡣
 */
public class �����е�����k����� {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head==null || k==0) {
    		return null;
    	}
    	ListNode ahead=head;
    	ListNode behind=null;
    	for(int i=0;i<k-1;i++) {
    		if(ahead.next!=null) {
    			ahead=ahead.next;
    		}else {
    			return null;
    		}
    	}
    	behind=head;
    	while (ahead.next!=null) {
			ahead=ahead.next;
			behind=behind.next;
		}
    	return behind;
    }
}
