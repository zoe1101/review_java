package ��̬�滮;

import java.util.Stack;

/*
���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
���ڸ���״ͼ�У��ܹ����ճ����ľ��ε���������

����: [2,1,5,6,2,3]
���: 10
 */

//����ջʵ��
public class ��״ͼ�����ľ��� {
	/*
	�������Ƕ������ǵ�stackջ[],���ջ����������Ƕ�Ӧ���ε��±ꡣ
	����ϣ�������stack�ﴢ����±�����Ӧ�ĸ߶��ǵ����ġ�
	������ֲ���������������������˶ϲ㣬��ʱ�����ǾͿ���������ϲ㴦�������ǵ���������
	���˿��ܻ��ʣ������Щ���εĸ߶���һֱ�������أ��ǲ��Ͳ������½��Ķϲ��
	û������������heights��ĩβ������һ��0������Ϊ��������������������㡣

	��[2,1,5,6,2,3]Ϊ������һ��ʼ���Ϊ[2,1,5,6,2,3,0]��
	�������ǰ�0����һ��Ԫ�ص��±꣩���ջ�У������������ĸ߶��Ǹ��ϲ㣬
	��������pop��0����±꣬�������Ϊheights[0]*1 (���Ϊ2)��
	�������������±꣬1��2��3 �ֱ��Ӧ 1�� 5�� 6 �����߶ȣ����������ǵ����ģ�
	������ʱstack������±�Ϊ[1,2,3],�����������ϲ㣬�������ǻ�����ĳ����ǵ�Ԫ�أ�
	�ȱ��±�3������������ٱ��±�2����������������±�1����ĳ�����
	��Ϊ�±�1�͵�ǰ�±�4��������Ǵ��ںܶ��ֿ����Եģ����ǲ���������ͽ�������֮�����ϵ��
	��˼��˵��2���±����Ժ�ı��������п��ܻ���������������������Ǳ�����

	 */
    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0) {
			return 0;
		}
        if (heights.length==1) {
			return heights[0];
		}
        int res=0;
        Stack<Integer> stack=new Stack<Integer>();
        int[] newheights=new int[heights.length+1];
        for (int i = 0; i < heights.length; i++) {
			newheights[i]=heights[i];
		}
        newheights[heights.length]=0;
        for (int i = 0; i < newheights.length; i++) {
			while (!stack.isEmpty() && newheights[stack.peek()]>=newheights[i]) {
				int index=stack.pop();
				int left=stack.isEmpty()?-1:stack.peek();
				res=Math.max(res, (i-left-1)*newheights[index]);
			}
			stack.push(i);
		}
        return res;
    }
}
