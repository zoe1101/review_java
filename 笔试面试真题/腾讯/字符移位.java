package ��Ѷ;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

import test.class_A;

/*
СQ���������һ�����⣺��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ䡣
���ܰ��СQ��

��������1:
AkleBiCeilD
�������1:
kleieilABCD
 */
public class �ַ���λ {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		while (scanner.hasNext()) {
			String string=scanner.nextLine();
			int len=string.length();
			int p=len-1;
			char[] s=string.toCharArray();
			for (int i = p; i >= 0; i--){
				char c = s[i];
				if ('A' <= c && c<= 'Z'){
					for (int j = i; j < p; j++)
						s[j] = s[j + 1];
					s[p--]=c;
				}
			}
			for (char c:s) {

				System.out.print(c);
			}
			System.out.println();

		}

	}


}
