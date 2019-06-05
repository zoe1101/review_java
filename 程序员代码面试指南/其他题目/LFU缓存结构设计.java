package ������Ŀ;
/*
ʵ�� LFU �����㷨, ���һ���� LFUCache��ʵ��������������
      ���캯��: ���� Cache ������ܴ洢�� key ������
   get(key)����� Cache �д��ڸ� key���򷵻ض�Ӧ�� value ֵ�����򣬷���-1�� 
	�������ᵼ�� Cache �д洢�� key ��������������������ڲ���ǰ��̭���ʴ������ٵ����ݡ�

ע��
���� key �� value ���� int ���͡�
���ʴ�����ÿ��get/setһ�����ڵ�key�������Ը�key��һ�η��ʣ���ĳ��key����̭��ʱ�򣬷��ʴ������㡣
 */

import java.awt.font.TextHitInfo;
import java.util.HashMap;

import test.class_A;

public class LFU����ṹ��� {
	//����˫���������ϣ��ʵ��
	
	//�ڵ����ݽṹ
	public class Node{
		public Integer key;
		public Integer value;
		public Integer times;
		public Node last;
		public Node next;
		public  Node(int key,int value,int times) {
			this.key=key;
			this.value=value;
			this.times=times;
		}
	}
	//Ͱ�ṹ
	public class NodeList{
		public Node head;
		public Node tail;
		public NodeList last;
		public NodeList next;
		public NodeList(Node node) {
			head=node;
			tail=node;
		}
		public void addNodeFromHead(Node newHead) {
			newHead.next=head;
			head.last=newHead;
			head=newHead;
		}
		public boolean isEmpty() {
			return head==null;
		}
		public void deleteNode(Node node) {
			if (head==tail) {
				head=null;
				tail=null;
			}else {
				if (node==head) {
					head=node.next;
					head.last=null;
				}else if (node==tail) {
					tail=node.last;
					tail.next=null;
				}else {
					node.last.next=node.next;
					node.next.last=node.last;
				}
			}
			node.last=null;
			node.next=null;
		}
	}
	public class LFUCache{
		private int capacity;
		private int size;
		private HashMap<Integer, Node> records; //key���ĸ�Node��ʾ
		private HashMap<Node, NodeList> heads; //Node���ĸ�ͰNodeList��
		private NodeList headList; //����ߵ�Ͱ
		public  LFUCache(int k) {
			this.capacity=k;
			this.size=0;
			this.records=new HashMap<Integer, Node>();
			this.heads=new HashMap<Node, NodeList>();
			headList=null;
		}
		/**
		 * �жϸղ�ɾ����һ���ڵ���Ͱ�Ƿ�Ϊ�գ������Ϊ�վ�ʲôҲ����
		 * ���Ϊ�գ���Ҫ������
		 * @param removeNodeList:�ղ�ɾ����һ���ڵ���Ͱ
		 * @return
		 */
		private boolean modifyHeadList(NodeList removeNodeList) {
			if (removeNodeList.isEmpty()) {//����ղ�ɾ����һ���ڵ���ͰΪ��
				if (headList==removeNodeList) { //Ϊ����������ߵ�Ͱ����ɾ������ߵ�Ͱ
					headList=removeNodeList.next;
					if (headList!=null) {
						headList.last=null;
					}
				}else { //��������ߵ�Ͱ
					removeNodeList.last.next=removeNodeList.next; //ɾ��remove�Ľڵ�
					if (removeNodeList.next!=null) { 
						removeNodeList.last=removeNodeList.last;
					}
				}
				return true;
			}
			return false;
		}
		private void move(Node node,NodeList oldNodeList) {
			oldNodeList.deleteNode(node); //��ԭʼͰ��ɾ���ڵ�node
			NodeList preList=modifyHeadList(oldNodeList)?oldNodeList.last:oldNodeList; //�õ�nodeӦ����ӵ�Ͱ��ǰһ��Ͱ
			NodeList nextList=oldNodeList.next;  //�õ�nodeӦ����ӵ�Ͱ�ĺ�һ��Ͱ
			if (nextList==null) { //���һ��Ͱ
				NodeList newList=new NodeList(node);
				if (preList!=null) {
					preList.next=newList;
				}
				newList.last=preList;
				if (headList==null) {
					headList=newList;
				}
				heads.put(node, newList);
			}else {
				if (nextList.head.times.equals(node.times)) { //Ӧ�ò���Ͱ��ͷ���λ��
					nextList.addNodeFromHead(node);
					heads.put(node, nextList);
				}else {
					NodeList newList=new NodeList(node);
					if (preList!=null) {
						preList.next=newList;
					}
					newList.last=preList;
					newList.next=nextList;
					nextList.last=newList;
					if (headList==nextList) {
						headList=newList;
					}
					heads.put(node, newList);
				}
			}
			
			
		}
		public void set(int key,int value) {
			if (records.containsKey(key)) {
				Node node=records.get(key);
				node.value=value;
				node.times++;
				NodeList curNodeList=heads.get(node);
				move(node, curNodeList);
			}else {
				if (size==capacity) {
					Node node=headList.tail;
					headList.deleteNode(node);
					modifyHeadList(headList);
					records.remove(node.key);
					heads.remove(node);
					size--; //��֤������������Ч��
				}
				Node node=new Node(key, value, 1);
				if (headList==null) {
					headList=new NodeList(node);
				}else {
					if (headList.head.times.equals(node.times)) {
						headList.addNodeFromHead(node);
					}else {
						NodeList newList=new NodeList(node);
						newList.next=headList;
						headList.last=newList;
						headList=newList;
					}
				}
				records.put(key, node);
				heads.put(node, headList);
				size++;
			}
		}
		public Integer get(int key) {
			if (!records.containsKey(key)) {
				return null;
			}
			Node node=records.get(key);
			node.times++;
			NodeList curNodeList=heads.get(node);
			move(node, curNodeList);
			return node.value;
		}
	}
}
