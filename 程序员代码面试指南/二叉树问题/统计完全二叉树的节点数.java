package ����������;


public class ͳ����ȫ�������Ľڵ��� {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	public static int nodeNum(Node head) {
		if (head==null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	public static int bs(Node node,int layer,int height) {
		if (layer==height) {
			return layer;
		}
		if (mostLeftLevel(node.right,layer+1)==height) {//���ֵ�ǰ�ڵ㵽�����һ��
			//��ǰ�ڵ���������������������������ҳ���Ϊheight-layer,��Ӧ�ڵ�2^(height-layer)
		    //bs(node.right, layer+1, height)����ǰ�ڵ��������Ľڵ����
			return (layer<<(height-layer)+bs(node.right, layer+1, height));
		}else {//���ֵ�ǰ�ڵ�û�е������һ��
			//layer<<(height-layer-1)����ǰ�ڵ������������Ϊ�����������ڵ����2^(height-layer-1)
			//bs(node.left, layer+1, height)����ǰ�ڵ���������Ľڵ���
			return (layer<<(height-layer-1)+bs(node.left, layer+1, height));
		}
		
	}
	//�ҵ�������������ڵ�
	public static int mostLeftLevel(Node node,int level) {
		while (node!=null) {
			level++;
			node=node.left;
		}
		return level-1;
	}
}
