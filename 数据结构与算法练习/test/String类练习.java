package test;

import java.util.*;


public class String����ϰ {

	public static void main(String[] args) {
		String str1String=" HELLO WORLD!  ";
		
//		�ַ�����
		System.out.println(str1String.charAt(3));
//		�ַ�������
		System.out.println(str1String.indexOf('W'));//��ǰ������
		System.out.println(str1String.lastIndexOf('W'));//�Ӻ���ǰ��
		
//	�Ӵ���ȡ
		System.out.println(str1String.substring(4)); //�ӵ�ǰλ��4��ȡ���ַ�������
		System.out.println(str1String.substring(4,7));//��ȡ[4,7)���ַ���
		
//		ȥ��β�ո�
		System.out.println(str1String.trim());
//		�ַ����滻
		System.out.println(str1String.replace('E', 'e')); 
		
//		�ж��ַ����Ŀ�ʼ���β
		System.out.println(str1String.startsWith(" ")); //�ж��ַ����Ƿ��ѿո�ͷ
		System.out.println(str1String.endsWith(" ")); //�ж��ַ����Ƿ��ѿո��β
		
//		�ж��ַ����Ƿ����
		String str2String=" HELLO WorLD!  ";
		System.out.println(str1String.equals(str2String));//���ִ�Сд
		System.out.println(str1String.equalsIgnoreCase(str2String));//���Դ�Сд
//		�ַ����Ƚ�
		System.out.println(str1String.compareTo(str2String));
//		��Сдת��
		System.out.println(str1String.toLowerCase());
		System.out.println(str2String.toUpperCase());
//		�ַ����ָ�
		System.out.println(str2String.split(" ",2));//������
//		��ʽ���ַ���
		System.out.println(String.format("%d",400/2));
		Date date=new Date();
		String string=String.format("%tY", date); //��ǰ���
		System.out.println(string);
//		StringBuilder
		StringBuilder sb= new StringBuilder("hello");
		sb.append('a');
		System.out.println(sb.toString());
		sb.insert(3,'a');
		System.out.println(sb.toString());
		sb.delete(2, 4);
		System.out.println(sb.toString());
	}

}
