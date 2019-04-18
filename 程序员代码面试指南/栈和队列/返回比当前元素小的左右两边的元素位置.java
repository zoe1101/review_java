package ջ�Ͷ���;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ���رȵ�ǰԪ��С���������ߵ�Ԫ��λ�� {
//	������ 
//	ʱ�临�Ӷȣ�O(n^2)
	public static int[][] violence(int[] arr) {//���ظ�ֵʱ
		int[][] res=new int[arr.length][2];
		for(int i=0;i<arr.length;i++) {
			int leftLessIndex=-1; //-1��������
			int rightLessIndex=-1;
			int cur=i-1;//���Ԫ�ز�����ʼλ��
			while (cur>=0) {
				if(arr[cur]<arr[i]) {
					leftLessIndex=cur;
					break;
				}
				cur--;
			}
			cur=i+1;//�ұ�Ԫ�ز�����ʼλ��
			while (cur<arr.length) {
				if(arr[cur]<arr[i]) {
					rightLessIndex=cur;
					break;
				}
				cur++;
			}
			res[i][0]=leftLessIndex;
			res[i][1]=rightLessIndex;
		}
		return res;
	}
	//	ʹ�õ���ջ�ṹ
	public static int[][] ByStack(int[] arr) {//���ظ�ֵʱ
		int[][] res=new int[arr.length][2];
		Stack<Integer> stack=new Stack<Integer>();//�������λ��
		for(int i=0;i<arr.length;i++) {
			while (!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
				int popIndex=stack.pop();
				int leftLessIndex=stack.isEmpty()?-1:stack.peek();
				res[popIndex][0]=leftLessIndex;
				res[popIndex][1]=i;
				
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {//���ջ��ʣ�µ�λ�ã���Щλ�ö�Ӧ��Ԫ���ұ�û�б���С��Ԫ�أ���Ϊջ�ǵ�����
			int popIndex=stack.pop();
			int leftLessIndex=stack.isEmpty()?-1:stack.peek();
			res[popIndex][0]=leftLessIndex;
			res[popIndex][1]=-1;
		}
		return res;
	}
	
	//	ʹ�õ���ջ�ṹ
	public static int[][] ByStack2(int[] arr) {//���ظ�ֵʱ
		int[][] res=new int[arr.length][2];
		Stack<List<Integer>> stack=new Stack<List<Integer>>();//��ͬ��Ԫ����������һ��list��
		for(int i=0;i<arr.length;i++) {
			while (!stack.isEmpty() && arr[stack.peek().get(0)]>arr[i]) {//ջ�ǿ���ջ��Ԫ�ش��ڵ�ǰԪ��
				List<Integer> popIs=stack.pop();
				int leftLessIndex=stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);//��������������һ������λ��
				for(Integer popi:popIs) {
					res[popi][0]=leftLessIndex;
					res[popi][1]=i;
				}
			}
			if(!stack.isEmpty() && arr[stack.peek().get(0)]==arr[i]) {//���и�Ԫ�ص�һ��λ����������������
				stack.peek().add(Integer.valueOf(i));
			}else {//ջ�л�û�и�Ԫ�ص�����
				ArrayList<Integer> list=new ArrayList<Integer>();
				list.add(i);
				stack.push(list);
			}
		}
		while (!stack.isEmpty()) {
			List<Integer> popIs=stack.pop();
			int leftLessIndex=stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
			for(Integer popi:popIs) {
				res[popi][0]=leftLessIndex;
				res[popi][1]=-1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr= {3,4,3,1,5,6,2,7};
		int[][] a=violence(arr);
		int[][] b=ByStack2(arr);
		for(int[] row:a) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("����ջ����");
		for(int[] row:b) {
			System.out.println(Arrays.toString(row));
		}

	}

}
