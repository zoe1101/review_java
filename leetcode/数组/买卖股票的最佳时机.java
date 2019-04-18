package ����;
/*
 ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
ע���㲻���������Ʊǰ������Ʊ��

����: [7,1,5,3,6,4]
���: 5
����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
 ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
 */
public class ������Ʊ�����ʱ�� {
	public static int maxProfit(int[] prices) {
		int minprice=Integer.MAX_VALUE; // int �����������ֵ�� 2 �� 31 �η� - 1 = 2147483648 - 1 = 2147483647
        int maxprofit=0;
        for(int i=0;i<prices.length;i++) {
        	if(prices[i]<minprice) {//����ļ۸������ͼ۸�
        		minprice=prices[i];
        	}else if(prices[i]-minprice>maxprofit) {//��ǰ�������֮ǰ���������
        		maxprofit=prices[i]-minprice;
        	}
        }
        return maxprofit;
    }
	public static void main(String[] args) {
		int[] prices= {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));

	}

}
