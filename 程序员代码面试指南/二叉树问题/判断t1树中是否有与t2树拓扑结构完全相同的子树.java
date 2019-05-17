package ����������;

import ����������.�ж�t1���Ƿ����t2��ȫ�������˽ṹ.Node;

//t2�Ƿ���t1������
public class �ж�t1�����Ƿ�����t2�����˽ṹ��ȫ��ͬ������ {
//�ֽ�t1��t2���л���Ȼ�������Ӵ�ƥ���㷨ʵ��
	public static boolean isSunTree(Node t1,Node t2) {
		String t1String=serialByPre(t1);
		String t2String=serialByPre(t2);
		return getIndexOf(t1String, t2String)!=-1;
	}
	public static String serialByPre(Node head) {
		if (head==null) {
			return "#!";
		}
		String res=head.value+"!";
		res+=serialByPre(head.left);
		res+=serialByPre(head.right);
		return res;
	}
	//KMP�㷨�������Ӵ�λ��
	public static int getIndexOf(String s, String m) {
		if (s==null || m==null || m.length()==0 || s.length()==0) {
			return -1;
		}
		char[] ss=s.toCharArray();
		char[] ms=m.toCharArray();
		int i=0;
		int j=0;
		int[] next=getNextArray(ms);
		while (i<ss.length && j<ms.length) {
			if (ss[i]==ms[j]) {
				i++;
				j++;
			}else if (next[j]==-1) {
				i++;
			}else {
				j=next[j];
			}
		}
		return j==ms.length?i-j:-1;
	}
	public static int[] getNextArray(char[] ms) {
		if (ms.length==1) {
			return new int[] {-1};
		}
		int[] next=new int[ms.length];
		next[0]=-1;
		next[1]=0;
		int pos=2;
		int cn=0;
		while (pos<next.length) {
			if (ms[pos-1]==ms[cn]) {
				next[pos++]=++cn;
			}else if (cn>0) {
				cn=next[cn];
			}else {
				next[pos++]=0;
			}
		}
		return next;
	}
}
