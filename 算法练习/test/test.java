package test;
import java.util.*;
public class test {  //������

	public static void main(String[] args) {   //main��������
		Scanner stdinScanner=new Scanner(System.in); //��������
		Random random=new Random(); //�����
		final double PI=3.1415926;  //�޷��޸ĵı���
		
//		int[] arr= new int[5];  //��������
		int[] arr= new int[] {1,2,3,4,5};  //������������ֵ
		String string="hello world";
		char[] char_arr=string.toCharArray(); //�ַ���ת����
		String string2=new String(char_arr); //����ת�ַ���
		System.out.println(string2);
		System.out.println(arr);
		
		int x=stdinScanner.nextInt();  //��������ֵ
		String string3=stdinScanner.nextLine(); //����һ���ַ���
		int r=random.nextInt(100); //100���ڵ������
		System.out.println(x);
		// TODO �Զ����ɵķ������
		System.out.println("2+4=6"+"32");

	}

}
