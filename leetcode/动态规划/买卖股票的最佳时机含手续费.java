package ��̬�滮;

public class ������Ʊ�����ʱ���������� {
    public int maxProfit(int[] prices, int fee) {
    	int buy = Integer.MIN_VALUE;//��ʾ���������Ʊ���������
        int sell = 0; //��ʾ����������Ʊ���������
        for (int price:prices) {
			buy=Math.max(buy, sell-price-fee); //�������˵������֮ǰ������� ֮������ֵ
			sell=Math.max(sell, buy+price);//�������������֮ǰ��������֮������ֵ
		}
        return sell;
    }
}
