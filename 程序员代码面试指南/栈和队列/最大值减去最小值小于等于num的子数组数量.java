package ջ�Ͷ���;

import java.util.LinkedList;
import java.util.Stack;

//����˫�˶��нṹ����Ҫ���������ƶ��任ʱ����
public class ���ֵ��ȥ��СֵС�ڵ���num������������ {
	public static int getnum(int[] arr,int num) {
		if(arr==null ||arr.length==0 || num<0) {
			return 0;
		}
		LinkedList<Integer> qmin=new LinkedList<Integer>(); //ά��arr[i:j]����Сֵ���Ӵ�С��λ������
		LinkedList<Integer> qmax=new LinkedList<Integer>(); //ά��arr[i:j]�����ֵ����С�����λ������
		int i=0,j=0,res=0;
		while(i<arr.length){
			while (j<arr.length) {
				if(qmin.isEmpty() || qmin.peekLast()!=j) { //qminΪ�ջ�arr[i:j]����������
					while (!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[j]) {//arr[i:j]����������ʱ
						qmin.pollLast();
					}
					qmax.addLast(j);
				}
				if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num) {//qmax����С��-qmin���Ķ�����num
					break;//�������鲻�ϸ�ֹͣ����j
				}
				j++;
			}
			res+=j-1;
			if(qmin.peekFirst()==i) {
				qmin.pollFirst();
			}
			if(qmax.peekFirst()==i) {
				qmax.pollFirst();
			}
			i++;
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
