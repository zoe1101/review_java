package ��������;
//N����Χ��һȦ���ӵ�һ���˿�ʼ����������m���˳�Ȧ��ʣ�µ��˼�����1��ʼ����������m���˳�Ȧ�����������ֱ�������˳�Ȧ��

public class Լɪ������ {
	public static class Node { //������
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	
//	ʱ�临�Ӷ�: O(n*m)
	public static Node josephusKill1(Node head,int m) {
		if(head==null || head.next==head || m<1) return head;
		Node lastNode=head;
		while (lastNode.next!=head) {
			lastNode=lastNode.next;
		}
		int count=0;
		while (head!=lastNode) {
			if(++count==m) {//������mʱ����ɾ����ǰ����Ϊm�Ľڵ�
				lastNode.next=head.next;
			}else {
				lastNode=lastNode.next;
			}
			head=head.next;
		}
		return head;
	}
	
	//�ݹ����, ʱ�临�Ӷ�:O(n)
	public static Node josephusKill2(Node head,int m) {
		if(head==null || head.next==head || m<1) return head;
		Node curNode=head.next;
		int temp=1;
		while (curNode!=head) {
			temp++;
			curNode=curNode.next;
		}
		temp=getLive(temp,m); //�����λ��
		while (--temp!=0) { //�ҵ����ڵ�
			head=head.next;
		}
		head.next=head;//���컷��
		return head;
	}
	public static int getLive(int i,int m) {
		if(i==1) {
			return 1;
		}
		return (getLive(i-1, m)+m-1)%i+1;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
