package ����������;
import ����������.�ж�t1���Ƿ����t2��ȫ�������˽ṹ.Node;

public class �ڶ��������ҵ������ڵ������������� {
//	�ڶ��������ҵ������ڵ�������������
//  ���ú�������ʵ�֣���Ϊ������������Ҹ��Ľṹ
	public static Node lowsetAncestor(Node head, Node o1,Node o2) {
		if (head==null || head==o1 || head==o2) {
			return head;
		}
		Node left=lowsetAncestor(head.left, o1, o2); //���������Ƿ��ҵ���o1����o2
		Node right=lowsetAncestor(head.right, o1, o2);//���������Ƿ��ҵ���o1����o2
		if (left!=null && right!=null) {
			return head;
		}
		return left!=null?left:right;
	}
}
