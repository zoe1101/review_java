package ̰���㷨;
/*
��ʦ��������Ƿַ��ǹ����� N ������վ����һ��ֱ�ߣ���ʦ�����ÿ�����ӵı��֣�Ԥ�ȸ��������֡�
����Ҫ��������Ҫ�󣬰�����ʦ����Щ���ӷַ��ǹ���

ÿ���������ٷ��䵽 1 ���ǹ���
���ڵĺ����У����ָߵĺ��ӱ����ø�����ǹ���
��ô������������ʦ������Ҫ׼�����ٿ��ǹ��أ�

����: [1,0,2]
���: 5
����: ����Էֱ�����������ӷַ� 2��1��2 ���ǹ���
 */


public class �ַ��ǹ� {
    public static int candy(int[] ratings) {
        int[] cd=new int[ratings.length];
        int nums=0;
        if(ratings.length==0) {
        	return 0;
        }
        for(int i=0;i<ratings.length;i++) { //ȷ��ÿ���˶����ǹ�����ʼ��Ϊ1
        	cd[i]=1;
        }
        for(int i=1;i<ratings.length;i++) {
        	if(ratings[i]>ratings[i-1]) {
        		cd[i]=cd[i-1]+1;
        	}
        }
        for(int i=ratings.length-1;i>0;i--) {
        	if(ratings[i-1]>ratings[i] && cd[i-1]<=cd[i]) {
        		cd[i-1]=cd[i]+1;
        	}
        }
        for(int e:cd) {
        	nums+=e;
        }
        return nums;
    }

	public static void main(String[] args) {
		int[] ratings= {1,0,2};
		System.out.print(candy(ratings));
	}
}
