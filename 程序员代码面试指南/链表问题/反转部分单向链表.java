package ��������;


public class ��ת���ֵ������� {
	public static class Node { //������
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	//��[from,to]���ַ�ת
	public static Node reversePart(Node head,int from,int to) {
		int len=0;
		Node node1=head;
		Node fpreNode=null;
		Node tnextNode=null;
		while (head!=null) {
			len++;
			fpreNode= len==from-1 ? node1:fpreNode; //�����len++�Ĺ����У��ҵ���fromǰһ�����Ǿͽ�pre��Ϊ��ʱ�ۼӵ�������ڵ�
			tnextNode= len==to+1 ? node1:tnextNode; //�����len++�������ҵ���to�����һ�����͸�ֵΪ��ǰ�㣬�����Ϊnull
			node1=node1.next;
		}
		if(from<to || from<1 ||to >len) { //�����Ϸ�ת����
			return head;
		}
		node1= fpreNode==null ? head:fpreNode.next; //���Ƿ���Ҫ��ͷ,��fpreNode==nullʱ,ͷ���Ҫ��,���Ǵ�ԭͷ��ʼ��
		Node node2=node1.next; 
		Node next=null;
		while(node2!=tnextNode) {//��ת����
			next=node2.next;
			node2.next=node1;
			node1=node2;
			node2=next;
		}
		if(fpreNode!=null) {  //���fpreNode���ڵ�ʱ�򣬽ӵ�fpreNode��from-1������
			fpreNode.next=node1;
			return head;
		}
		return node1; //������ƴ�ӣ�ֱ���ǵ�ת֮�����ͷ���
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
