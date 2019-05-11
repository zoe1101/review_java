package src;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * @author zoe
 *
 *˼·������һ������ĸ���ջ
 */
public class ջ��ѹ�뵯������ {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0 || popA.length==0||popA.length!=pushA.length) {
        	return false;
        }
        Stack<Integer> stack=new Stack<Integer>();
        int j=0;
        for(int i=0;i<pushA.length;i++) {
        	stack.push(pushA[i]);
        	while (!stack.isEmpty() && stack.peek()==popA[j]) {
				stack.pop();
				j++;
			}
        }
        return stack.isEmpty(); //�ж��Ƿ�ȫ��ջ�ˣ�ȫ��ջ��˵��popA���������ǶԵ�
    }
}
