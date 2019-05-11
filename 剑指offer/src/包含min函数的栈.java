package src;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 * @author zoe
 *
��һ������ջ��ʵ����Сֵ�ĸ��¹�����
��ջʱ:
1��������ջΪ��ʱ������ջ��Ԫ��ͬʱҲ���븨��ջ��
2��������Ϊ��ʱ���ͰѸ���ջԪ���븨��ջ��ջ��Ԫ�ؽ��бȽϣ�����ջԪ��С�����Ԫ��ͬʱҲ���븨��ջ�������ǣ���Ը���ջ�����в���

��ջʱ:
1����ʱ����ջ��ջ��Ԫ�ص��ڴ������ݵ�����ջջ��Ԫ��ʱ����������ջҪ����Ԫ�أ�����ջҲҪ����ջ��Ԫ�أ�
2)������ʱ��ֻ������ջ���г�ջ������
 */
public class ����min������ջ {
	Stack<Integer> datestack=new Stack<Integer>();//���Ԫ��ջ
	Stack<Integer> minstack=new Stack<Integer>();//����ջ��dataջ��ÿ�ν���һ��Ԫ�أ�min����ջ�ʹ�ŵ�ǰdataջ�е���СԪ��
	public void push(int node) {
        datestack.push(node);
        if(minstack.isEmpty()) {
        	minstack.push(node);
        }else if (!minstack.isEmpty() && minstack.peek()>node) {
			minstack.push(node);
		}
        
    }
    
    public void pop() {
    	 if(!datestack.isEmpty()) {
    		 int tmp=datestack.pop();
    		 if(minstack.peek()==tmp) {
    			 minstack.pop();
    		 }
        }
    }
    
    public int top() {
        return datestack.peek();
    }
    
    public int min() {
        return minstack.peek();
    }
}
