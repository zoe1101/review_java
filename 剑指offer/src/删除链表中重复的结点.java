package src;

/*
��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */
public class ɾ���������ظ��Ľ�� {
    public ListNode deleteDuplication(ListNode pHead){ 
        if (pHead == null) {
			return null;
		}
        ListNode first = new ListNode(-1); //ע�ⱸ��ͷ���, ͷ�����ܱ�ɾ��
        first.next = pHead;
        ListNode curNode = pHead;
        ListNode preNode = first;  //ǰ�ڵ�,��ʼ��Ϊnull
        
        while(curNode!=null && curNode.next!=null) {
            if(curNode.next.val==curNode.val){
                int val=curNode.val; //��¼val�����жϺ���ڵ��Ƿ��ظ�
                while(curNode !=null && curNode.val==val){ //����������ȵĽڵ�,����ɾ��
                    curNode=curNode.next;
                }
                preNode.next=curNode;//ɾ������,ǰ�ڵ��nextֱ�ӵ������ڵĽڵ�, ���м�Ľڵ�ֱ�ӿ��
            }else{
                preNode=curNode;
                curNode=curNode.next;
            }
        }
         return first.next; //���ر�ͷ
    }
}
