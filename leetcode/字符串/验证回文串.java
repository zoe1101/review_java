package �ַ���;
/*
����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

����: "A man, a plan, a canal: Panama"
���: true
 */
public class ��֤���Ĵ� {
    public static boolean isPalindrome(String s) {
        if(s.length()<=1) return true;
        int n=s.length();
        s=s.toLowerCase();
        StringBuffer stringBuffer=new StringBuffer(n);
        for(char c:s.toCharArray()) {
        	if((c>='0' &&c<='9') ||(c>='a' && c<='z')) {
        		stringBuffer.append(c);
        	}
        }
        return stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
