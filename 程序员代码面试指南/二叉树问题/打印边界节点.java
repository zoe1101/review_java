package ����������;
/*
��׼һ��
����1��ͷ�ڵ�Ϊ�߽�ڵ㣻
����2��Ҷ�ڵ�Ϊ�߽�ڵ㣻
����3������ڵ��������ڵĲ���������������ҵģ���ôҲ�Ǳ߽�ڵ㡣

������׼����
����1��ͷ�ڵ�Ϊ�߽�ڵ㣻
����2��Ҷ�ڵ�Ϊ�߽�ڵ㣻
����3������߽�������ȥ��·��Ϊ�߽�ڵ㣻
����4�����ұ߽�������ȥ��·��Ϊ�߽�ڵ㡣
 */
public class ��ӡ�߽�ڵ� {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	//��׼һ
	public static void printEdge1(Node head) {
		if(head==null) return;
		int height=getHeight(head, 0);
		Node[][] edgeMap=new Node[height][2]; //���ÿ������������ұߵĽڵ�
		for (int i = 0; i < edgeMap.length; i++) {//��ӡ��߽�
			if(edgeMap[i][0]!=edgeMap[i][0]) {
				System.out.print(edgeMap[i][0].value+" ");
			}
		}
		//		��ӡҶ�ӽ��
		printLeafNotinMap(head, 0, edgeMap);
		for(int i=edgeMap.length-1;i>=0;i--) {
			if(edgeMap[i][0]!=edgeMap[i][0]) {
				System.out.print(edgeMap[i][1].value+" ");
			}
		}
		System.out.println();
	}
    //	�õ����ĸ߶�
	public static int getHeight(Node head,int l) {
		if(head==null) return l;
		return Math.max(getHeight(head.left, l+1), getHeight(head.right, l+1));
	}
	public static void printLeafNotinMap(Node head,int l,Node[][] map) {
		if(head==null) return;
		if(head.left==null && head.right==null && head !=map[l][0] && head !=map[l][1]) {
			System.out.print(head.value+" ");
		}
		printLeafNotinMap(head.left,l+1,map);
		printLeafNotinMap(head.right,l+1,map);
	}
//	��׼��
	public static void printEdge2(Node head) {
		if (head==null) {
			return;
		}
		System.out.print(head.value+" ");
//		�ҵ���һ�����������ӵĽڵ㣬��Ϊ������ڵ�֮ǰֻ��һ�����ӵĽڵ�϶��Ǳ߽�ڵ㣬���ǵĺ���Ҳ�Ǳ߽�ڵ�
		if(head.left!=null && head.right!=null) {
			printLeftEdge(head.left, true);//�����������ұ߽�ڵ�
			printLeftEdge(head.right, true); //�����������ұ߽�ڵ�
		}else {
			printEdge2(head.left!=null?head.left:head.right);
		}
		System.out.println();
	}
//	 ��ӡͷ�ڵ��������ϵı߽�ڵ�
	public static void printLeftEdge(Node head,boolean printFlag) {
		if(head==null) return;
		if(printFlag || (head.left==null && head.right==null)) {
			System.out.print(head.value+" ");
		}
		printLeftEdge(head.left,printFlag);
//		���ĳ���ڵ������ֵܣ���ô���Լ�����������ֻ��Ҷ�ӽڵ���Ǳ߽�ڵ�
		printLeftEdge(head.right,printFlag && head.left==null?true:false);
	}
	
//	 ��ӡͷ�ڵ��������ϵı߽�ڵ�
	public static void printRightEdge(Node head,boolean printFlag) {
		if(head==null) return;
//		 ���ĳ���ڵ������ֵܣ������Լ�����������ֻ��Ҷ�ӽڵ��Ǳ߽�ڵ�
		printLeftEdge(head.left,printFlag && head.right==null?true:false);
		printLeftEdge(head.right,printFlag);
		if(printFlag || (head.left==null && head.right==null)) {
			System.out.print(head.value+" ");
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
