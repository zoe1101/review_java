package ������Ŀ;

import java.util.HashMap;

public class ���RandomPool�ṹ {
	public static class RandomPool<K>{
		private HashMap<K, Integer> keyIndexMap; //��¼key��index�Ķ�Ӧ��ϵ
		private HashMap<Integer,K> indexKeyMap;//��¼index��key�Ķ�Ӧ��ϵ
		private int size; //��ǰpool�Ĵ�С
		public RandomPool() {
			this.keyIndexMap=new HashMap<K, Integer>();
			this.indexKeyMap=new HashMap<Integer,K>();
			this.size=0;
		}
		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}
		public void delete(K key) {
			if (this.keyIndexMap.containsKey(key)) {
				int deleteIndex=this.keyIndexMap.get(key); //��Ҫɾ����key��index
				int lastIndex=--this.size;
				K lastkey=this.indexKeyMap.get(lastIndex); //pool�����¼����key
				//��(lastkey��lastIndex)����(lastkey��deleteIndex) �������һ��key��index����ɾ��key
				this.keyIndexMap.put(lastkey, deleteIndex);
				this.indexKeyMap.put(deleteIndex, lastkey);
				//ɾ����key,deleteIndex��
				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastIndex);
			}
		}
		public K getRandom() {
			if (this.size==0) {
				return null;
			}
			int randomIndex=(int) Math.random()*this.size;
			return this.indexKeyMap.get(randomIndex);
		}
	}

}
