package �������������;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ����Ŀ������������� {
	public static class Program{
		public int cost; //��Ŀ�����ʽ�
		public int profit; //��Ŀ������
		public Program(int cost,int profit) {
			this.cost=cost;
			this.profit=profit;
		}
	}
	//����С������αȽϴ�С
	public static class CostMinComp implements Comparator<Program> {
		@Override
		public int compare(Program o1,Program o2) {
			return o1.cost-o2.cost;
		}
	}
	
	//����������αȽϴ�С
	public static class ProfitMaxComp implements Comparator<Program> {
		@Override
		public int compare(Program o1,Program o2) {
			return o2.profit-o1.profit;
		}
	}
	//�������
	public static int getMaxProfit(int W,int K,int[] costs,int[] profits) {
		//������Ч
		if (W<1 || K<0 || costs==null || profits==null ||
				costs.length!=profits.length) {
			return W;
		}
		//�������ȶ���ʵ�ִ������С���ѣ���ʱ���Զ���˳��
		PriorityQueue<Program> costMinHeap=new PriorityQueue<Program>(new CostMinComp()); //����С����
		PriorityQueue<Program> profitMaxHeap=new PriorityQueue<Program>(new ProfitMaxComp()); //��������
		//������Ŀ��������С����
		for (int i = 0; i < costs.length; i++) {
			costMinHeap.add(new Program(costs[i], profits[i]));
		}
		//������K����Ŀ
		for (int i = 0; i < K; i++) {
			//������Щ���Ѳ����ڵ�ǰ�ʽ�W����Ŀ��������Щ��Ŀ��������������
			while (!costMinHeap.isEmpty() && costMinHeap.peek().cost<=W) {
				profitMaxHeap.add(costMinHeap.poll());
			}
			if (profitMaxHeap.isEmpty()) { //��������Ϊ�գ�����û�п��Կ��ǵ���Ŀ�������ʽ�W
				return W;
			}
			W+=profitMaxHeap.poll().profit; //�������������Ŀ������Ҫ�Ӵ�������ó��Ѷ�����������Ŀ
		}
		return W;
	}
	
	public static void main(String[] args) {
		int W=3;
		int K=2;
		int[] costs= {5,4,1,2};
		int[] profits= {3,5,3,2};
		System.out.println(getMaxProfit(W, K, costs, profits));

	}
	

}
