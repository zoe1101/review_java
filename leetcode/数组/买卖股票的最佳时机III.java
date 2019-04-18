package ����;
/*
����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�
ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����

����: [3,3,5,0,0,3,1,4]
���: 6
����: �ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
 ����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ����Ʊ�۸� = 4����ʱ����������ʽ������ܻ������ = 4-1 = 3 ��
 */
//����˼·:��̬�滮
public class ������Ʊ�����ʱ��III {
	public static int maxProfit(int[] prices) {
		if(prices==null ||prices.length==0) {
			return 0;
		}
	    int[] local=new int[3];
	    int[] global=new int[3];
	    for(int i=1;i<prices.length;i++) {
	    	int temp=prices[i]-prices[i-1];
	    	for(int j=2;j>=1;--j) {
	    		local[j]=Math.max(global[j-1]+Math.max(temp, 0), local[j]+temp);
	    		global[j]=Math.max(local[j], global[j]);
	    	}
	    }
	    return global[2];
	   }
	public static void main(String[] args) {
		int[] prices= {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));

	}

}
