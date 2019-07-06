package �ַ���;
/*
��дһ�����������ַ�����Ϊ���룬��ת���ַ����е�Ԫ����ĸ��

ʾ�� 1:

����: "hello"
���: "holle"
ʾ�� 2:

����: "leetcode"
���: "leotcede"
˵��:
Ԫ����ĸ��������ĸ"y"��

 */
public class ��ת�ַ����е�Ԫ����ĸ {
    public String reverseVowels(String s) {
    	if(s == null) return s;
    	char[] c = s.toCharArray();
        int low = 0, high = c.length-1;
        char temp;
        while(low <= high){
            while(low<=high && !isValid(c[low])) {
            	low++;
            }
            while(low<=high && !isValid(c[high])) { 
            	high--;
            }
            
            if(low<=high){
                temp = c[low];
                c[low] = c[high];
                c[high] = temp;
                low++;
                high--;
            }
        }
        return new String(c);
    }
    private boolean isValid(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
            || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
