package �ַ���;
/*\
����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���
�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
*****ע��:
�����ַ����ĳ��Ȳ��ᳬ�� 1010��

����:
"abccccdd"
���:
7
����:
���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
 */
public class ��������Ĵ� {
    public static int longestPalindrome(String s) {
         //����һ����ĸ����ż���Σ���ô�ض����Թ��ɻ����ַ����е�Ԫ��(����ƽ������)
		//���һ����ĸ���������Σ�ֻ��ȡż���������Ĵ� ������ - 1
        //�������ڻ��Ĵ����м����һ�������ַ�

        int[] charcount=new int[58]; ////��С��ĸһ��56��
        for(char c:s.toCharArray()) {
        	charcount[c-'A']++; //�ַ�����
        }
        int count=0; //����Ĵ��ַ�����
        for(int t:charcount) {
        	count+=(t>>1<<1); //(t/2)*2
        }
        return count==s.length()?count:count+1;
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
