package ����������;
import ����������.�ж�t1���Ƿ����t2��ȫ�������˽ṹ.Node;
/*
�������еĽ�����룺�ӽ��A��������B��ÿ�����ֻ����һ�Σ�AB·���ϵĽ��������AB����롣
���ڴ�һ��������ʱ��ֻ�����ַ�����ߣ�
���Ͼ������ڵ㵽�������ֵ�������
���µ������Լ�������������
 */

/*
��hΪ���Ķ������Ľ���������Ŀ��������
    1��Ϊ�������Ľ��������룻
    2��Ϊ�������Ľ��������룻
    3��Ϊ����h������������Ҷ��㵽����������Ҷ����·������
       ����h��������������+h��������������+1��
 */
public class �������ڵ������������� {
	public static class ReturnType {
		public int maxDistance;
		public int height;
		public ReturnType(int maxdis,int h) {
			this.maxDistance=maxdis;
			this.height=h;
		}
	}
	
	public static ReturnType process(Node head) {
		if (head==null) {
			return new ReturnType(0,0);
		}
		ReturnType leftData=process(head.left);
		ReturnType rightData=process(head.right);
		int height=Math.max(leftData.height, rightData.height)+1;
		int maxDistance=Math.max(leftData.height+rightData.height+1,
				Math.max(leftData.maxDistance, rightData.maxDistance));
		return new ReturnType(maxDistance, height);
	}
	public static int getMaxDistance(Node head) {
		return process(head).maxDistance;
	}
}
