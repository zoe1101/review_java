package �ַ���;
/*
����һ���ַ�����һ������ k������Ҫ�Դ��ַ�����ͷ�����ÿ�� 2k ���ַ���ǰk���ַ����з�ת��
���ʣ������ k ���ַ�����ʣ�������ȫ����ת��
�����С�� 2k �����ڻ���� k ���ַ�����תǰ k ���ַ�������ʣ����ַ�����ԭ����

ʾ��:

����: s = "abcdefg", k = 2
���: "bacdfeg"

 */
public class ��ת�ַ���II {
	public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i  < len; i = i + 2 * k) {
            if (i + k - 1 < len) {
                reverse(chars, i, i + k - 1);
            }else {
                reverse(chars, i, len - 1);
            }
        }

        return new String(chars);
    }

    public void reverse(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
