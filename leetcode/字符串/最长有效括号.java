package �ַ���;

import java.util.Stack;

/*
����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�


����: "(()"
���: 2
����: ���Ч�����Ӵ�Ϊ "()"

����: ")()())"
���: 4
����: ���Ч�����Ӵ�Ϊ "()()"
 */

//����ջ+��̬�滮��˼��ʵ��
public class ���Ч���� {
    public int longestValidParentheses(String s) {
    	if (s==null || s.equals("")) {
			return 0;
		}
    	char[] chas=s.toCharArray();
    	int len=chas.length;
    	Stack<Integer> stack=new Stack<Integer>();
    	int max=0;
    	int start=0;
    	for (int i = 0; i < len; i++) {
			if (chas[i]=='(') { //��������(��ѹջ(ջ��Ԫ��Ϊ��ǰλ���������±�)
				stack.push(i);
			}else {
				if (stack.isEmpty()) { //ջ��û����֮��Ӧ�������ţ�����һ��λ�ÿ�ʼ���¼���
					start=i+1;
				}else {
					stack.pop();
					if (stack.isEmpty()) { //ջ��ֻ��һ���������ˣ������������Ч����
						max=Math.max(i-start+1, max);
					}else { //��ֹһ������
						max=Math.max(i-stack.peek(), max);
					}
				}
			}
		}
    	return max;
    }
}
