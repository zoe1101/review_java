package vivo���������ǰ��;

//һ��������������m,n��Ҫ���ڵ�m�͵�n����֮�ڵ�Ԫ�ص���洢�����������
//����Ĳ��ַ�ת
public class Main2 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node Solution(Node root,int m,int n) {
		if (root==null || root.next==null) {
			return root;
		}
		int len=0;
		Node newroot=root;  //��ͷ
		Node mpre=null; //m��ǰһ���ڵ�
		Node npos=null; //n�ĺ�һ���ڵ�
		while (newroot!=null) { 
			len++;
			//�ҵ�m��ǰһ���ڵ���n�ĺ�һ���ڵ�
			mpre=len==m-1?newroot:mpre;
			npos=len==n+1?newroot:npos;
			newroot=newroot.next;
		}
		if (m>n || m<0 || n>len-1) {
			return newroot;
		}
		newroot=mpre==null?root:mpre.next; //��Ҫ��ת���ֵ�ͷ���
		Node curnode=newroot.next;
		newroot.next=npos; //��ת����λ�õ���һ���ڵ�
		Node next=null;
		//��m,n��֮��ķ�ת
		while (curnode!=npos) {
			next=curnode.next; //��ǰ�ڵ����һ���ڵ�
			curnode.next=newroot; //����ǰ�ڵ����һ���ڵ�ָ����ǰһ���ڵ�
			newroot=curnode; //��ǰ�ڵ��ǰһ���ڵ��Ϊ��ǰ�ڵ�
			curnode=next; //���µ�ǰ�ڵ�
		}
		if (mpre!=null) {
			mpre.next=newroot;
			return root;
		}
		return newroot;
		
	}

}
