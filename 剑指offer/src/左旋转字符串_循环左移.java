package src;
/*
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 */
public class ����ת�ַ���_ѭ������ {
	
    // ������ת,������
    // 1. ��תҪ��λ�Ĳ���
    // 2. ��ת���ಿ��
    // 3. ���巴ת
	//Ҳ���԰���Щ���跴����,�������巴ת�ڲ��ַ�ת
    public static String LeftRotateString(String str,int n) {
        if(n < 0 || n >= str.length()) {
        	return str;
        }
        char[] chas=str.toCharArray();
        reverse(chas, 0, n-1);
        reverse(chas, n, chas.length-1);
        reverse(chas, 0, chas.length-1);
    	return new String(chas);
    }
    private static void reverse(char[] chas,int start,int end) {
		while (start<end) {
			swap(chas, start, end);
			start++;
			end--;
		}
	}
    private static void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
      }
    
	public static void main(String[] args) {
		String string="abcXYZdef";
		System.out.println(string);
		System.out.println(LeftRotateString(string,3));

	}
}

