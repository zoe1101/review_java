package ջ�Ͷ���;

import java.util.Stack;

import javax.management.RuntimeErrorException;
import javax.swing.text.rtf.RTFEditorKit;

public class ������ջ��ɵĶ��� {
	public Stack<Integer> stackpush; //ѹ��ջ
	public Stack<Integer> stackpop; //����ջ
	public ������ջ��ɵĶ���() {
		stackpush=new Stack<Integer>();
		stackpop=new Stack<Integer>();
	}
	public void pushTopop() {//��ѹ��ջ������ѹ�뵯��ջ
		if(stackpop.isEmpty()) {
			while (!stackpush.isEmpty()) {
				stackpop.push(stackpush.pop());
			}
		}
	}
	public void add(int value) {//���
		stackpush.push(value);
		pushTopop();
	}
	public int poll() {//����
		if(stackpop.isEmpty() &&stackpush.isEmpty()) {
			throw new RuntimeErrorException(null,"�ն���");
		}
		pushTopop();
		return stackpop.pop();
	}
	public int peek() {//��ȡ��ͷԪ�أ���������
		if(stackpop.isEmpty() &&stackpush.isEmpty()) {
			throw new RuntimeErrorException(null,"�ն���");
		}
		pushTopop();
		return stackpop.peek();
	}

	public static void main(String[] args) {
		������ջ��ɵĶ��� queue=new ������ջ��ɵĶ���();
		queue.add(4);
		queue.add(2);
		queue.add(1);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.peek());


	}

}
