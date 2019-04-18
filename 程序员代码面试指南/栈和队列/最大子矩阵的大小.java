package ջ�Ͷ���;

import java.util.Stack;

public class ����Ӿ���Ĵ�С {
	public static int maxRecSize(int[][] map) {
		if(map==null || map.length==0||map[0].length==0) {
			return 0;
		}
		int maxArea=0;
		int[] height=new int[map[0].length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				height[j]=map[i][j]==0?0:height[j]+1;//ֻ��¼����1�����
			}
			maxArea=Math.max(maxArea, maxRecFromBoottom(height));
		}
		return maxArea;
	}
	public static int maxRecFromBoottom(int[] height) {
		if(height==null ||height.length==0) {
			return 0;
		}
		int maxArea=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<height.length;i++) {
			while (!stack.isEmpty() && height[stack.peek()]>=height[i]) {
				int curIndex=stack.pop();
				int leftLessIndex=stack.isEmpty()?-1:stack.peek(); //�������С�ڵ�ǰԪ�ض�ӦԪ�ص�λ������
				int curArea=(i-leftLessIndex-1)*height[curIndex];
				maxArea=Math.max(curArea, maxArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int curIndex=stack.pop();
			int leftLessIndex=stack.isEmpty()?-1:stack.peek(); //�������С�ڵ�ǰԪ�ض�ӦԪ�ص�λ������
			int curArea=(height.length-leftLessIndex-1)*height[curIndex];
			maxArea=Math.max(curArea, maxArea);
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
