package ջ�Ͷ���;

import java.util.Arrays;
import java.util.Stack;

import javax.management.RuntimeErrorException;

//������ջʵ�֣�һ��������Ԫ�أ�һ������СԪ��
public class ���һ����getMin���ܵ�ջ {
	private Stack<Integer> stackdata;
	private Stack<Integer> stackMin;
	public ���һ����getMin���ܵ�ջ() {
		this.stackdata=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	public void push(int newNUm) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNUm);
		}else if(newNUm<=this.getMin()) {
			this.stackMin.push(newNUm);
		}
		this.stackdata.push(newNUm);
		
	}
	public int pop() {
		if(this.stackdata.isEmpty()) {
			throw new RuntimeErrorException(null, "ջΪ��");
		}
		int value=this.stackdata.pop();
		if(value==this.getMin()) {
			this.stackMin.pop();
		}
		return value;
		
	}
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeErrorException(null, "ջΪ��");
		}
		return this.stackMin.peek();
	}
	

	public static void main(String[] args) {
		���һ����getMin���ܵ�ջ mystack=new ���һ����getMin���ܵ�ջ();
		mystack.push(3);
		mystack.push(4);
		mystack.push(2);
		mystack.push(3);
		mystack.push(1);
		System.out.println(mystack.getMin());
		mystack.pop();
		System.out.println(mystack.getMin());

	}

}
