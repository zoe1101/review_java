package ���ֲ���;
/*
 ʵ�� int sqrt(int x) ������
���㲢���� x ��ƽ���������� x �ǷǸ�������
���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��

����: 4
���: 2
 */
//�൱�ڲ������һ��������Ŀ��ֵ����
public class x��ƽ���� {
    public static int mySqrt(int x) {
        if(x<=1) return x;
        int left=0,right=x;
        while(left<right) {
        	int mid=(left+right)/2;
        	if(x/mid>=mid) {
        		left=mid+1;
        	}else {
        		right=mid;
        	}
        }
        return right-1;
    }
	public static void main(String[] args) {
	    int x=8;
	    System.out.println(mySqrt(x));

	}
}
