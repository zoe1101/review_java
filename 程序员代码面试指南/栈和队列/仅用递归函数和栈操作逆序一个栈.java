package ջ�Ͷ���;

import java.util.Stack;

public class ���õݹ麯����ջ��������һ��ջ {
	//ջ����
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) return;
		int i=getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
		
	}
	//�Ƴ������ص�ǰջ��Ԫ��
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result=stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			int last=getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
		
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
