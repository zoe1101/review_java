package �������������;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class ���������ҵ����ִ�������N����K���� {
//�������ù�ϣ���¼ÿ�����Ĵ���ʵ�֣������Ӷȸ�
//��һ�ַ�����һ��ɾ��K����ͬ������ֱ��ʣ�µ����಻��Kʱֹͣ��ʣ��������ǳ��ִ�������K/N����
	
	//��ӡ��������һ�����������еĻ���ֻ����һ����
	public static void printHalfMajor(int[] arr) {
		int cand=0; //��ѡ��
		int times=0; //��ѡ�����ֵĴ���
		//�õ���ѡ�������һ�������ִ�����һһ�룬���ջᱻʡ������Ϊ��ѡ
		for (int i = 0; i < arr.length; i++) {
			if (times==0) { //��times=0ʱ��û�к�ѡ��,��arr[i]������ѡ��ͬʱtimes��һ
				cand=arr[i];
				times=1;
			}else if (arr[i]==cand) { //arr[i]�뵱ǰ��ѡ����ͬ��times+1
				times++;
			}else { //arr[i]�뵱ǰ��ѡ����ͬ��times-1
				times--;
			}
		}
		//��ѡ�����ִ���ͳ��
		times=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==cand) {
				times++;
			}
		}
//		�����ѡ���Ƿ�������Ǵ�������һ�����
		if (times>arr.length/2) {
			System.out.println(cand);
		}else {
			System.out.println("û�г��ִ�������һ�����");
		}
	}
	//��ӡ���������ҵ����ִ�������N/K����
	public static void printKMajor(int[] arr,int K) {
		if (K<=1) {
			System.out.println("Kֵ����Ч��");
			return;
		}
		//��Ҫ����K-1����ѡ������¼����ִ���
		HashMap<Integer, Integer> cands=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (cands.containsKey(arr[i])) {
				cands.put(arr[i], cands.get(arr[i])+1);
			}else {
				if (cands.size()==K-1) { //��ѡ����K������Ҫ�������ɾ����һ����
					allCandsMinusOne(cands);
				}else { //��ѡ������K����Ҫ��arr[i]������ѡ
					cands.put(arr[i], 1);
				}
			}
		}
		HashMap<Integer, Integer> reals=getReals(arr, cands);
		boolean hasPrint=false; //��ע��ѡ�����Ƿ�������Ҫ�����
		for(Entry<Integer, Integer> set:cands.entrySet()) {
			Integer key=set.getKey();
			if (reals.get(key)>arr.length/K) {
				hasPrint=true;
				System.out.print(key+" ");
			}
		}
		System.out.println(hasPrint?"":"û�г��ִ�������K/N����");
	}
	 //���еĺ�ѡ������������һ
	public static void allCandsMinusOne(HashMap<Integer, Integer> cands) {
		List<Integer> removelList=new LinkedList<Integer>(); //��¼��һ��Ϊ0����
		for(Entry<Integer, Integer> set:cands.entrySet()) {
			Integer key=set.getKey();
			Integer value=set.getValue();
			if (value==1) { //�����ǰ����Ϊ1����һ���Ϊ0����Ҫ��������Ӻ�ѡ����ɾ��
				removelList.add(key);
			}
			cands.put(key, value-1);
		}
		for(Integer removekey:removelList) { //�Ѽ�һ��Ϊ0�����Ӻ�ѡ����ɾ��
			cands.remove(removekey);
		}
	}
	//�Ժ�ѡ������ʵ���ִ������м���
	public static HashMap<Integer, Integer> getReals(int[] arr,HashMap<Integer, Integer> cands) {
		HashMap<Integer, Integer> reals=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (cands.containsKey(arr[i])) {
				if (reals.containsKey(arr[i])) {
					reals.put(arr[i], reals.get(arr[i])+1);
				}else {
					reals.put(arr[i], 1);
				}
			}
		}
		return reals;
	}

}
