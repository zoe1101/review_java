package ������Ŀ;

import java.util.HashMap;

/*
���һ�ֻ���ṹ�� �ýṹ�ڹ���ʱȷ����С�� �����СΪK�� �����������ܣ�
set(key,value)�� ����¼(key,value)����ýṹ��
get(key)�� ����key��Ӧ��valueֵ��

1�� set��get������ʱ�临�Ӷ�ΪO(1)��
2�� ĳ��key��set��get����һ�������� ��Ϊ���key�ļ�¼�������ʹ�õġ�
3�� ������Ĵ�С����Kʱ�� �Ƴ������ʹ�õļ�¼�� ��set��get���Զ�ġ�

���軺��ṹ��ʵ����cache�� ��СΪ3�� �����η���������Ϊ��
1�� cache.set("A",1)�� ���ʹ�õļ�¼Ϊ("A",1)��
2�� cache.set("B",2)�� ���ʹ�õļ�¼Ϊ("B",2)�� ("A",1)��Ϊ������ġ�
3�� cache.set("C",3)�� ���ʹ�õļ�¼Ϊ("C",2)�� ("A",1)����������ġ�
4�� cache.get("A")�� ���ʹ�õļ�¼Ϊ("A",1)�� ("B",2)��Ϊ������ġ�
5�� cache.set("D",4)�� ��С������3�� �����Ƴ���ʱ�����ʹ�õļ�¼("B",2)�������¼ ("D",4)�� 
����Ϊ���ʹ�õļ�¼�� Ȼ��("C",2)��Ϊ�����ʹ�õļ�¼
 */
public class ���LRU����ṹ {
	//����˫���������ϣ��ʵ��
	public static class Node<V>{
		public V value;
		public Node<V> last;
		public Node<V> next;
		public Node(V value){
			this.value=value;
		}
	}
	public static class NodeDoubleLinkedList<V>{
		public Node<V> head; //ͷ�����ȼ����
		public Node<V> tail; //β�����ȼ����
		public NodeDoubleLinkedList(){
			this.head=null;
			this.tail=null;
		}
		public void addNode(Node<V> newNode) {
			if (newNode==null) {
				return;
			}
			if (this.head==null) {
				this.head=newNode;
				this.tail=newNode;
			}else { //��β�������½ڵ�
				this.tail.next=newNode;
				newNode.last=this.tail;
				this.tail=newNode;
			}
		}
		public void moveNodeToTail(Node<V> node) {
			if (this.tail==node) {
				return;
			}
			if (this.head==node) {
				this.head=node.next;
				this.head.last=null;
			}else {
				node.last.next=node.next;
				node.next.last=node.last;
			}
			node.last=this.tail;
			node.next=null;
			this.tail.next=node;
			this.tail=node;
		}
		public Node<V> removeHead() {
			if (this.head==null) {
				return null;
			}
			Node<V> res=this.head;
			if (this.head==this.tail) {
				this.head=null;
				this.tail=null;
			}else {
				this.head=res.next;
				res.next=null;
				this.head.last=null;
			}
			return res;
		}
	}
	public static class MyCache<K, V> {
		private HashMap<K, Node<V>> keyNodeMap;
		private HashMap<Node<V>, K> nodeKeyMap;
		private NodeDoubleLinkedList<V> nodeList;
		private int capacity;

		public MyCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("should be more than 0.");
			}
			this.keyNodeMap = new HashMap<K, Node<V>>();
			this.nodeKeyMap = new HashMap<Node<V>, K>();
			this.nodeList = new NodeDoubleLinkedList<V>();
			this.capacity = capacity;
		}

		public V get(K key) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> res = this.keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;
			}
			return null;
		}

		public void set(K key, V value) {
			if (this.keyNodeMap.containsKey(key)) {
				Node<V> node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {
				Node<V> newNode = new Node<V>(value);
				this.keyNodeMap.put(key, newNode);
				this.nodeKeyMap.put(newNode, key);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}
			}
		}

		private void removeMostUnusedCache() {
			Node<V> removeNode = this.nodeList.removeHead();
			K removeKey = this.nodeKeyMap.get(removeNode);
			this.nodeKeyMap.remove(removeNode);
			this.keyNodeMap.remove(removeKey);
		}

	}

	public static void main(String[] args) {
		MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
		testCache.set("A", 1);
		testCache.set("B", 2);
		testCache.set("C", 3);
		System.out.println(testCache.get("B"));
		System.out.println(testCache.get("A"));
		testCache.set("D", 4); //��ʱC�Ѿ���ɾ����
		System.out.println(testCache.get("D"));
		System.out.println(testCache.get("C")); 

	}

}
