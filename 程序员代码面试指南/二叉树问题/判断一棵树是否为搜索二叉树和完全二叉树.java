package ����������;
import java.util.LinkedList;
import java.util.Queue;
import ����������.�ж�t1���Ƿ����t2��ȫ�������˽ṹ.Node;

public class �ж�һ�����Ƿ�Ϊ��������������ȫ������ {
//	�ж��Ƿ�������������
	public static boolean isBST(Node head) {
		if (head==null) {
			return true;
		}
		boolean res=true;
		Node preNode=null; //��ǰ�ڵ��ǰһ���ڵ�
		Node cur1Node=head; //��ǰ�ڵ�
		Node cur2Node=null; //ǰ���ڵ�,��ǰ�ڵ����������ҵĽڵ�
		while (cur1Node!=null) {
			cur2Node=cur1Node.left;
//			�����ǰ�ڵ�����Ӳ�Ϊ�գ��ڵ�ǰ�ڵ�����������ҵ���ǰ�ڵ�����������µ�ǰ���ڵ㡣
			if (cur2Node!=null) {
				while (cur2Node.right!=null &&cur2Node.right!=cur1Node) {
					cur2Node=cur2Node.right;
				}
//				���ǰ���ڵ���Һ���Ϊ�գ��������Һ�������Ϊ��ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ�����ӡ�
				if (cur2Node.right==null) {
					cur2Node.right=cur1Node;
					cur1Node=cur1Node.left;
					continue;
				}
//				���ǰ���ڵ���Һ���Ϊ��ǰ�ڵ㣬�������Һ���������Ϊ�գ��ָ�������״����
				else {
					cur2Node.right=null;
				}
			}
//			�ж��Ƿ��������Ҫ��
			if (preNode!=null && preNode.value>cur1Node.value) {
				return false;
			}
			
//			�����ǰ�ڵ������Ϊ�գ��������ǰ�ڵ㲢�����Һ�����Ϊ��ǰ�ڵ㡣
			preNode=cur1Node;//�ڵ����
			cur1Node=cur1Node.right;
		}
		return res;
	}
//�ж��Ƿ�����ȫ������
	public static boolean isCBT(Node head) {
		if (head==null) {
			return true;
		}
		Queue<Node> queue=new LinkedList<Node>();
		boolean leaf=false;
		Node leftNode=null;
		Node rightNode=null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head=queue.poll();
			leftNode=head.left;
			rightNode=head.right;
			//��Ҷ�ӽ�㣬�����ӻ��Һ��Ӳ�Ϊ��
			//���ӽڵ�Ϊ�գ����Һ��Ӳ�Ϊ��
			if ((leaf && (leftNode!=null || rightNode!=null)) || (leftNode==null && rightNode!=null)) {
				return false;
			}
			if (leftNode!=null) {
				queue.offer(leftNode);
			}
			if (rightNode!=null) {
				queue.offer(rightNode);
			}else {
				leaf=true;
			}
		}
		return true;
	}
}
