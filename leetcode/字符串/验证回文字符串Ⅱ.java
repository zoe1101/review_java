package �ַ���;
/*
����һ���ǿ��ַ��� s�����ɾ��һ���ַ����ж��Ƿ��ܳ�Ϊ�����ַ�����

����: "abca"
���: True
����: �����ɾ��c�ַ���
 */
//����һ�����Ծ��ٸ����λ���, һ�λ�������, һ�λ�����ұ�, ���λ��ᶼû���վ�˵��false
public class ��֤�����ַ����� {
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while (left<right) {
        	if(s.charAt(left)==s.charAt(right)) {
    			left++;
    			right--;
    		}
        	else {
        		return validPalindrome(s, left+1, right) || validPalindrome(s, left, right-1);
		    }
        }
    	return true;
    }
    public boolean validPalindrome(String s, int left, int right) {
    	while(left<right) {
    		if(s.charAt(left)==s.charAt(right)) {
    			left++;
    			right--;
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    	
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
