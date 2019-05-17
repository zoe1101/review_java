package ����������;

import java.util.HashMap;

public interface ͨ������ͺ����������ɺ������� {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	/*
	1�����ݵ�ǰ�������飬���ú����������ұߵ�ֵ
	2�����ֳ������������������������������������������
	3�����������ظ�ͬ���Ĺ���
	4�����������ظ�ͬ���Ĺ���
	 */
	public static int[] getPosArray(int[] pre,int[] in) {
		if (pre==null ||in==null ||pre.length!=in.length) {
			return null;
		}
		int len=pre.length;
		int[] pos=new int[len]; //��������
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();//���������ֵ����λ��
		for (int i = 0; i < len; i++) {
			map.put(in[i], i);
			
		}
		setPos(pre, 0, len-1, in, 0, len-1, pos, len-1, map);
		return pos;
	}
	/**
	 * �Ӻ���ǰ���к������������
	 * @param pre:��������
	 * @param pre_s���������鿪ʼλ��
	 * @param pre_e�������������λ��
	 * @param in ����������
	 * @param in_s���������鿪ʼλ��
	 * @param in_e�������������λ��
	 * @param pos����������
	 * @param pos_e��������������һ��λ�ã�����ǰ��Ҫ����λ��
	 * @param map
	 * @return �����غ�������������һ��λ��
	 */
	public static int setPos(int[] pre,int pre_s,int pre_e,int[] in,int in_s,int in_e,
			int[] pos,int pos_e,HashMap<Integer, Integer> map) {
		if (pre_s>pre_e) {
			return pos_e;
		}
		pos[pos_e--]=pre[pre_s];
		int i=map.get(pre[pre_s]); //�������������ҵ�ͷ����λ��
		pos_e=setPos(pre, pre_e-in_e+i+1, pre_e, in, i+1, in_e, pos, pos_e, map);//������
		return setPos(pre, pre_s+1, pre_s+i-in_s, in, in_s, i-1, pos, pos_e, map);//������
		
	}
	
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		int[] in = { 4, 2, 5, 1, 6, 3, 7 };
		int[] pos = getPosArray(pre, in);
		printArray(pos);

	}
}
