package ջ�Ͷ���;

import java.util.Stack;



//2��ɽ��1������ɽ������2*n-3
public class �ɼ���ɽ������� {
	public static class Record{
		public int value;
		public int times;
		public Record(int value) {
			this.value=value;
			this.times=1;
		}
	}

	public static int getVisibleNum(int[] arr) {
		if(arr==null ||arr.length<=1) {
			return 0;
		}
		int size=arr.length;
		int maxIndex=0;
		for(int i=0;i<size;i++) {//�ڻ����ҵ�����һ�����ֵ��λ��
			maxIndex=arr[i]>arr[maxIndex]?i:maxIndex;
		}
		Stack<Record> stack=new Stack<Record>();
		stack.push(new Record(arr[maxIndex]));//�ֽ�(���ֵ,1)������¼ѹ��ջ
		int index=nextIndex(maxIndex,size); //�����ֵλ�ÿ�ʼ����next�������
		//���á���С�Ҵ󡱵ķ�ʽ
		int res=0; //�ɼ�ɽ�������
		while (index!=maxIndex) {
			while (stack.peek().value<arr[index]) {
				int k=stack.pop().times;
				res+=2*k+getInternalSum(k);
			}
			if(stack.peek().value==arr[index]) {
				stack.peek().times++;
			}else {
				stack.push(new Record(arr[index]));
			}
			index=nextIndex(index, size);
		}
		while (stack.size()>2) {
			int times=stack.pop().times;
			res+=2*times+getInternalSum(times);
		}
		if(stack.size()==2) {
			int times=stack.pop().times;
			res+=getInternalSum(times)+(stack.peek().times==1?times:2*times);
		}
		res+=getInternalSum(stack.pop().times);
		return res;
	}
	
	//�������鵱ǰλ��Ϊi�����鳤��Ϊsize������i����һ��λ��
	public static int nextIndex(int i ,int size) {
		return i<(size-1)?i+1:0;
	}
	
	//ͬһ�߶ȵ�ɽ���ڲ�������ɵĿɼ�ɽ�������
	public static int getInternalSum(int k) {
		return k==1?0:(k*(k-1)/2); //(k*(k-1)/2):Cn2
	}

	public static void main(String[] args) {
		int[] arr={3,2,5,4};
		System.out.print(getVisibleNum(arr));
	}

}
