package src;
import java.util.Stack;

/*
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class ������ջʵ�ֶ��� {
	Stack<Integer> stack1 = new Stack<Integer>(); //ѹ��ջ
    Stack<Integer> stack2 = new Stack<Integer>(); //����ջ
    
    public void push(int node) {
    	stack1.push(node);

    }
    
    public int pop() {
        if(!stack2.isEmpty()) {
        	return stack2.pop();
        }else {
        	while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
        	return stack2.pop();
        }
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
