package �ַ���;

import java.util.Arrays;

//�����������
public class �ַ����ĵ������滻 {
	/**
	 * �ַ����滻
	 * @param chas
	 */
	public static void replace(char[] chas) {
		if(chas==null || chas.length==0) {
			System.out.println("�ַ�����Ϊ��");
			return ;
		}
		int num=0; //�ո�ͳ��
		for(int i=0;i<chas.length;i++) {
			if(chas[i]==' ') {
				num++;
			}
		}
		int newlen=chas.length+2*num;
		char[] newchas=new char[newlen];
		for(int i=chas.length-1;i>=0;i--) {
			if(chas[i]!=' ') {
				newchas[--newlen]=chas[i];
			}else {
				newchas[--newlen]='0';
				newchas[--newlen]='2';
				newchas[--newlen]='%';
			}
		}
		System.out.println(Arrays.toString(newchas));
	}
	/**
	 * �ַ�������
	 * @param chas
	 */
	public static void modify(char[] chas) {
		if(chas==null || chas.length==0) {
			System.out.println("�ַ�����Ϊ��");
			return ;
		}
		int len=chas.length;
		for(int i=chas.length-1;i>=0;i--) { //�Ƚ���*������λ
			if(chas[i]!='*') {
				chas[--len]=chas[i];
			}
		}
		for(;len>0;) {
			chas[--len]='*';
		}
		System.out.println(Arrays.toString(chas));
	}

	public static void main(String[] args) {
		String string="123 34 ";
		String string2="123***45**6";
		char[] chas=string.toCharArray();
		char[] chas2=string2.toCharArray();
		replace(chas);
		modify(chas2);

	}

}
