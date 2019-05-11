package �ַ���;

import java.util.Arrays;

import test.test;
/**
 * �����ַ������򣬵���˳������
 * @author zoe
 *
 */
public class ��ת�ַ��� {
	public static void rotateWord(char[] chas) {
		if(chas==null ||chas.length==0) {
			return ;
		}
		reverse(chas, 0, chas.length-1);
		int left=-1;
		int right=-1;
		for(int i=0;i<chas.length;i++) {
			if(chas[i]!=' ') {
				left= i==0 || chas[i-1]==' '?i:left;
				right=i==chas.length-1 || chas[i+1]==' '?i:right;
			}
			if(left!=-1 && right!=-1) {
				reverse(chas, left, right);
				left=-1;
				right=-1;
			}
		}
	}
	/**
	 * �ַ�������
	 * @param chas
	 * @param start
	 * @param end
	 */
	public static void reverse (char[] chas,int start,int end) {
		char tmp=0;
		while (start<end) {
			tmp=chas[start];
			chas[start]=chas[end];
			chas[end]=tmp;
			start++;
			end--;
		}
	}
/**
 * �ַ��������ƶ���ǰsize���ַ��ƶ����ַ�����벿��
 * @param chas
 * @param size
 */
	public static void rotateString(char[] chas,int size) {
		if(chas==null ||size<=0|| size>=chas.length) {
			return ;
		}
		
		reverse(chas, 0, size-1); //ǰ�벿������
		reverse(chas, size, chas.length-1);//��벿������
		reverse(chas, 0, chas.length-1);//��������
	}
	
	/**
	 * �ַ��������ƶ���ǰsize���ַ��ƶ����ַ�����벿��
	 * @param chas
	 * @param size
	 */
	public static void rotateString2(char[] chas,int size) {
		if(chas==null ||size<=0|| size>=chas.length) {
			return ;
		}
		
		int start=0;
		int end=chas.length-1;
		int lpart=size; //����ַ�������
		int rpart=chas.length-size; //�ұ��ַ�������
		int exsize=Math.min(lpart, rpart); //�������ֵĳ���
		int d=lpart-rpart; //��ߺ��ұ��ַ����ĳ��Ȳ�
		while (true) {
			exchange(chas, start, end, exsize);
			if(d==0) { ////�����ַ������,������ֹͣѭ��
				break;
			}else if(d>0) { //����ַ������ұ�,�ұߵ��Ƶ���ߵ��ַ��������ƶ�,��ǰexsize��Ԫ���Ѷ�
				start+=exsize; //�����ƶ�����ʼλ�������ƶ�exsize
				lpart=d;
			}else {//����ַ������ұ�,��ߵ��Ƶ��ұߵ��ַ��������ƶ�,����exsize��Ԫ���Ѷ�
				end-=exsize; //�����ƶ��Ľ���λ�������ƶ�exsize
				rpart=-d;
			}
			exsize=Math.min(lpart, rpart);
			d=lpart-rpart;
		}
	}
	public static void exchange(char[] chas, int start,int end, int size) {
		int i=end-size+1;
		char tmp=0;
		while (size--!=0) {
			tmp=chas[start];
			chas[start]=chas[i];
			chas[i]=tmp;
			start++;
			i++;
		}
	}
	
	public static void main(String[] args) {
		char[] chas1 = { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
				'i', 'g' };
		System.out.println(String.valueOf(chas1));
		rotateWord(chas1);
		System.out.println(String.valueOf(chas1));

		char[] chas2 = { '1', '2', '3', '4', '5', 'A', 'B', 'C' };
		System.out.println(String.valueOf(chas2));
		rotateString(chas2, 5);
		System.out.println(String.valueOf(chas2));
		rotateString2(chas2, 5);
		System.out.println(String.valueOf(chas2));

	}

}
