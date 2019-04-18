package src;
/*
����һ��������ת��������������ı�ͷ��
 */
//��ֹ����Ͽ�����������Ҫ����3��ָ�룬�ֱ�ָ��ǰ�������Ľ�㡢����ǰһ����㼰��һ����㡣
//�ʷ�ת�������������ͷ�Ľ�����ԭ�������β����㡣β�����Ϊm_pNextΪnull�Ľ�㡣
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ��ת���� {
    public ListNode ReverseList(ListNode head) {
    	ListNode curNode=head;//��ǰ�ڵ�
    	ListNode preNode=null;//ǰһ���ڵ�
    	ListNode reverseNode=null;//��ת����ĵ�����洢ͷ���
    	while(curNode!=null) {
    		ListNode nextNode=curNode.next;//��һ���ڵ�
    		if(nextNode==null) {
    			reverseNode=curNode;
    		}
    		curNode.next=preNode; //�޸�curNode��ָ����ָ��preNode
    		preNode=curNode; //��curNode��㸴�Ƹ�preNode
    		curNode=nextNode;  //��curNode����һ����㸴�Ƹ�curNode
    			
    		}
    		return reverseNode;  
    }
    //�ݹ�д��
    public ListNode ReverseList1(ListNode head) {
        if(head==null || head.next==null) { //���û�н�����ֻ��һ�����ֱ�ӷ���head
        	return head;
        }
        
       ListNode nextNode=head.next; //���浱ǰ������һ���
       head.next=null;
       ListNode reverseNode=ReverseList1(nextNode); //�ݹ����ʱreverseHeadһ�����������ͷ���
       nextNode.next=head;
       return reverseNode;
    }

}
