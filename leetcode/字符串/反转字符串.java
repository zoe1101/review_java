package �ַ���;
/*
��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���


ʾ�� 1��

���룺["h","e","l","l","o"]
�����["o","l","l","e","h"]

 */
public class ��ת�ַ��� {
    public void reverseString(char[] s) {
    	if (s.length<2) {
			return ;
		}
        for (int i = 0; i < s.length/2; i++) {
			swap(s,i,s.length-i-1);
		}
    }

	private void swap(char[] s, int i, int j) {
		char temp=s[i];
		s[i]=s[j];
		s[j]=temp;
		
	}
}
