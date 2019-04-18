package ����;

import java.util.ArrayList;
import java.util.Stack;

/*
 ��β��ͷ��ӡ����

��������������Ϊ����ı�ͷ
������������Ϊ��Ҫ��ӡ�ġ��������ı�ͷ
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class ��β��ͷ��ӡ���� {
    public static void  main(String[] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        for(int i:printListFromTailToHead(l1)){
            System.out.print(i+ " ");
        }

    }
    
    //ѡ��ArrayList����Ϊ��ѯЧ�ʸ�
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);  //��ջ
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop()); //��ջ
        }
        return list;
    }
}