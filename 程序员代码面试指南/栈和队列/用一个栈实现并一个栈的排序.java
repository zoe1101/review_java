package ջ�Ͷ���;

import java.util.Stack;
//��ջ����ջ�״Ӵ�С���򣬼�Ҫ���С������ջ
public class ��һ��ջʵ�ֲ�һ��ջ������ {
	public void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> helpStack =new Stack<Integer>();//��������ջ,�Ӵ�С����ջ
		while (!stack.isEmpty()) {
			int cur=stack.pop();
			while (!helpStack.isEmpty() && helpStack.peek()<cur) {
				stack.push(helpStack.pop());
			}
			helpStack.push(cur);
		}
		while (!helpStack.isEmpty()) {
			stack.push(helpStack.pop()); //��С�������ջ
			
		}
		
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
