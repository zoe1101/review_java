package ����;

//������Ĵ��������롢ɾ�������ҡ���ʾ
public class SingleLinkedList {
	public int size; //����ڵ����
	public Node head; // ����һ��ͷ���
	
	public SingleLinkedList() {//���캯��
		size=0;
		head=null;
	}
	//�����ÿ���ڵ���
	//ʹ���ڲ�������ô��ǿ��Ժ��ⲿ�����˽�в����Ļ�����ʡ�
	public class Node { 
		public Object data; //ÿ���ڵ������,//������
		public Node next; //ÿ���ڵ�ָ����һ���ڵ������,//ָ����
		public Node(Object data) {
			this.data=data;
		}
	}
	//������ͷ���Ԫ��
	public Object addHead(Object obj) {
		Node newhead=new Node(obj);
		if(size==0) {
			head=newhead;
		}
		else {//����ӵ�Ԫ�ػ��ɱ�ͷ
			newhead.next=head;
			head=newhead;
		}
		size++;
		return obj;
	}
	//������ͷɾ��Ԫ��
	public Object deleteHead() {
		Object obj=head.data;
		head=head.next;//����һ��Ԫ����Ϊ��ͷ
		size--;
		return obj;
	}
	
	//����ָ��Ԫ�أ��ҵ��˷��ؽڵ�Node���Ҳ�������null
	public Node find(Object obj) {
		Node curNode=head;
		int tempsize=size;
		while(tempsize>0) {
			if(obj.equals(curNode.data)) {
				return curNode; //�ҵ���
			}else {
				curNode=curNode.next;
			}
			tempsize--;
		}
		return null;  //û�ҵ�
	}
	
	//ɾ��ָ����Ԫ�أ�ɾ���ɹ�����true
	public boolean delete(Object obj){
		if(size==0) {
			return false;
		}
		Node curNode=head;
		Node preNode=head;
		while(curNode.data!=obj) {
			if(curNode.next==null) { //������β����δ�ҵ���ӦԪ��,ɾ��ʧ��
				return false;
			}else {
				preNode=curNode;
				curNode=curNode.next;
			}
		}
		//�ҵ�Ҫɾ����Ԫ����
		if(curNode==head) {//���ɾ���Ľڵ��ǵ�һ���ڵ�
			head=curNode.next;
			size--;
		}else {//ɾ���Ľڵ㲻�ǵ�һ���ڵ�
			preNode.next=curNode.next;
			size--;
		}
		return true;
	}
	
	//�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return (size==0);
	}
	
	//��ʾ�ڵ���Ϣ
	public void display() {
		if(size>0) {
			Node node=head;
			int tempsize=size;
			if(tempsize==1) {//��ǰ����ֻ��һ���ڵ�
				System.out.print("["+node.data+"]");
				return ;
			}
		while(tempsize>0) {
			if(node.equals(head)) {//ͷ���
				System.out.print("["+node.data+"->");
			}else if(node.next==null) {//β�ڵ�
				System.out.print(node.data+"]");
			}else {//�м���
				System.out.print(node.data+"->");
			}
			node=node.next;
			tempsize--;
			}
			System.out.println();
		}else {//������
			System.out.println("[]");
			
		}
	}
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList=new SingleLinkedList();
		singleLinkedList.addHead("A");
		singleLinkedList.addHead("B");
		singleLinkedList.addHead("C");
		singleLinkedList.addHead("D");
		singleLinkedList.display();
		singleLinkedList.delete("B");
		singleLinkedList.display();
		System.out.println(singleLinkedList.find("D"));

	}

}
