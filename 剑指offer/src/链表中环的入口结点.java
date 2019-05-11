package src;
//��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
public class �����л�����ڽ�� {
	 public class ListNode {
		    int val;
		    ListNode next = null;
	
		    ListNode(int val) {
		        this.val = val;
		    }
		}
	 
	 //��������ָ��
//1�����ÿ���ָ�룬�����л����������һ��������
//2������ָ��ֱ������ͷ�����������������ÿ����һ�������һ���ڻ����������
    public ListNode EntryNodeOfLoop(ListNode pHead){
    	ListNode fast=pHead;
    	ListNode slow=pHead;
    	while (fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) { //������
				break;
			}
		}
    	if (fast==null || fast.next==null) {
			return null;
		}
    	slow=pHead;
    	while (fast!=slow) { //�ҵ������
			fast=fast.next;
			slow=slow.next;
		}
    	return slow;
    }
}
