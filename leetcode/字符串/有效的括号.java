package �ַ���;

import java.util.Stack;

import javax.naming.InitialContext;

/*
����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
��Ч�ַ��������㣺
�����ű�������ͬ���͵������űպϡ�
�����ű�������ȷ��˳��պϡ�
ע����ַ����ɱ���Ϊ����Ч�ַ�����
ʾ�� 1:

����: "()[]{}"
���: true
 */
//[ ( { ��ջ ,  ] ) } ��ջ . ��ջʱ�Ƚ��Ƿ��Ӧ,���򷵻�false
//ѭ���������ַ���֮�� ջ����Ϊ�� ����false
public class ��Ч������ {

    public static boolean isValid(String s) {
    	Stack<Character> stack=new Stack<Character>();
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(c=='(' ||c=='[' ||c=='{') {//����Ч����ѹ��ջ
    			stack.push(c);
    		}else { 
    			if(!stack.isEmpty()) {
	    			char topchar=stack.pop(); //ջ��Ԫ��
	    			if(c!=')' && topchar=='(') {
	    				return false;
	    			}else if(c!=']' && topchar=='[') {
	    				return false;
	    			}else if(c!='}' && topchar=='{') {
	    				return false;
	    			}
    			}else {
	    			return false;
	    		}
			}
		}
    	if(!stack.isEmpty()){
    		return false;
    	}
    	return true;
    }

	public static void main(String[] args) {
		String string="((())){}{}";
		System.out.println(isValid(string));
	}

}
