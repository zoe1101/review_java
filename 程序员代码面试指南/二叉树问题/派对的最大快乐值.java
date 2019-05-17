package ����������;

import java.util.List;

public class �ɶԵ�������ֵ {
	public static class Employee { 
		public int happy; // ����Ա�����Դ����Ŀ���ֵ
	    public List<Employee> nexts; // ����Ա������Щֱ���¼� 
	}
	
	// �õ�һ��Ա������or�������ֱ��Ӧ�����happy��������
	public static class ReturnType{
		public int laiMaxHappy;
		public int buMaxHappy;
		public ReturnType(int lai, int bu) {
			laiMaxHappy = lai;
			buMaxHappy = bu;
		}
	}
	
	public static int maxHappy(Employee boss) {
		ReturnType headInfo = process(boss);
		return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
	}
	

	// �õ�һ��Ա������or�������ֱ��Ӧ�����happy��������
	public static ReturnType process(Employee x) {
		//1. base case
		if(x.nexts.isEmpty()) {
			return new ReturnType(x.happy,0);
		}
		int lai = x.happy;
		int bu = 0;
		for(Employee next : x.nexts) {
			ReturnType nextInfo = process(next);// 2. Ĭ�õ�������info��Ϣ
			// 3. ������Ϣ�����ںУ��õ�info�о���ġ�
			lai += nextInfo.buMaxHappy;
			bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
		}// 4. ����ReturnType
		return new ReturnType(lai,bu);
	}
}
