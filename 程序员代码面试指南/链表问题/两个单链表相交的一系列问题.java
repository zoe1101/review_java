package ��������;


/*
 * �����Ƿ��л�
 * �޻������Ƿ��ཻ
 * �л������Ƿ��ཻ
 */
public class �����������ཻ��һϵ������ {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node getIntersectNode(Node head1,Node head2) {
		if (head1==null || head2==null) {
			return null;
		}
		Node loop1=getLoopNode(head1);
		Node loop2=getLoopNode(head2);
		if (loop1==null && loop2==null) {
			return noLoop(head1, head2);
		}else if (loop1!=null && loop2!=null) {
			return bothLoop(head1, head2, loop1, loop2);
		}else {
			return null;
		}
	}
	//�ж������Ƿ��л�,����У����ص�һ�����뻷�Ľڵ㣬���򷵻�null
	public static Node getLoopNode(Node head) {
		if (head==null || head.next==null || head.next.next==null) {
			return null;
		}
		Node slow=head.next;
		Node fast=head.next.next;
		while (slow!=fast) {
			if (fast.next==null || fast.next.next==null) {
				return null;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		fast=head;
		while (fast!=slow) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	//�޻������Ƿ��ཻ
	public static Node noLoop(Node head1,Node head2) {
		if (head1==null ||head2==null) {
			return null;
		}
		Node cur1Node=head1;
		Node cur2Node=head2;
		int n=0; //��¼���������ȵĲ�ֵ
		while (cur1Node.next!=null) {
			n++;
			cur1Node=cur1Node.next;
		}
		while (cur2Node.next!=null) {
			n--;
			cur2Node=cur2Node.next;
		}
		if (cur1Node!=cur2Node) {//��������β�ڵ㲻ͬ�����ཻ
			return null;
		}
		cur1Node=n>0?head1:head2; //cur1Node��ʾ���Ƚϳ�������
		cur2Node=cur1Node==head1?head2:head1; //cur2Node��ʾ���Ƚ϶̵�����
		n=Math.abs(n);
		while (n!=0) { //�ó��Ƚϳ����������߲�ֵ��
			cur1Node=cur1Node.next;
			n--;
		}
		while (cur1Node!=cur2Node) { //�ҵ��������
			cur1Node=cur1Node.next;
			cur2Node=cur2Node.next;
		}
		return cur1Node;
	}

	//�л������Ƿ��ཻ
	public static Node bothLoop(Node head1,Node head2,Node loop1,Node loop2) {
		Node cur1Node=null;
		Node cur2Node=null;
		if (loop1==loop2) {
			cur1Node=head1;
			cur2Node=head2;
			int n=0;
			while (cur1Node!=loop1) {
				n++;
				cur1Node=cur1Node.next;
			}
			while (cur2Node!=loop2) {
				n--;
				cur2Node=cur2Node.next;
			}
			cur1Node=n>0?head1:head2;
			cur2Node=cur1Node==head1?head2:head1;
			n=Math.abs(n);
			while (n>0) {
				n--;
				cur1Node=cur1Node.next;
			}
			while (cur1Node!=cur2Node) {
				cur1Node=cur1Node.next;
				cur2Node=cur2Node.next;
			}
			return cur1Node;
		}else {
			cur1Node=loop1.next;
			while (cur1Node!=loop1) {
				if (cur1Node==loop2) {
					return loop1;
				}
				cur1Node=cur1Node.next;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}
}
