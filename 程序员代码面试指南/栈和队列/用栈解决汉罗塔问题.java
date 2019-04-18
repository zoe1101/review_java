package ջ�Ͷ���;

import java.util.Stack;

//���ܴ������ֱ���ƶ������ұ�
//Ҳ���ܴ����ұ�ֱ���ƶ������
//����ͨ���м�����Ϊ����
public class ��ջ������������� {

	public static enum action{ //������Ϊ�о�
		No,LtoM,MtoL,MtoR,RtoM;
	}
//	�ǵݹ飬����ջʵ��
	public static int hanoi1(int num,String left,String mid,String right) {
		Stack<Integer> ls=new Stack<Integer>();
		Stack<Integer> ms=new Stack<Integer>();
		Stack<Integer> rs=new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		for(int i=num;i>0;i--) {//�ֽ�����Ԫ��ѹ����ߵ�ջ
			ls.push(i);
		}
		action[] record= {action.No};
		int step=0;
		while (rs.size()!=num+1) {
			//��ѭ�������ɵ�ǰ����������ǰһ�����ظ���ԭ��
			step+=stackTostack(record, action.MtoL, action.LtoM,ls,ms, left, mid);
			step+=stackTostack(record, action.LtoM, action.MtoL,ms,ls, mid, left);
			step+=stackTostack(record, action.RtoM, action.MtoR,ms,rs, mid, right);
			step+=stackTostack(record, action.MtoR, action.RtoM,rs,ms, right, mid);
		}
		return step;
	}
	public static int stackTostack(action[] record,action preNoAct,action nowAct,
			Stack<Integer> fStack,Stack<Integer> tStack,String from,String to) {
		//��ǰ������ǰһ��������ͬ����Դջ��Ҫѹ��Ŀ��ջ��Ԫ�ز��ܴ���Ŀ��ջ��Ԫ��
		if(record[0]!=preNoAct && fStack.peek()<tStack.peek()) {
			tStack.push(fStack.pop());
			System.out.println("Move "+tStack.peek()+" from "+ from+" to "+to);
			record[0]=nowAct;
			return 1;
		}
		return 0;
	}

	//�ݹ鷨
	public static int hanoi2(int num,String left,String mid,String right) {
		if(num<1) return 0;
		return Process(num,left,mid,right,left,right);
	}
	public static int Process(int num,String left,String mid,String right,String from,String to) {
		if(num==1) { //ֻ��һ������
			if(from.equals(mid) || to.equals(mid)) { //һ���ƶ�һ��λ��
				System.out.println("Move 1 from "+from+" to "+to);
				return 1;
			}else {//������Ƶ��ұ߻���ұ��Ƶ���ߣ������м�����
				System.out.println("Move 1 from "+from+" to "+mid);
				System.out.println("Move 1 from "+mid+" to "+to);
				return 2;
			}
		}
		if(from.equals(mid) || to.equals(mid)) {  //һ���ƶ�һ��λ��
//			����ߵ��м䡢���м䵽��ߡ����ұߵ��м䡢���м䵽�ұ�
			String another=(from.equals(left) || to.equals(left)?right:left);
			int part1=Process(num-1, left, mid, right, from, another);
			int part2=1;
			System.out.println("Move "+num+" from "+from+" to "+to);
			int part3=Process(num-1, left, mid, right, another, to);
			return part1+part2+part3;
		}else {//������Ƶ��ұ߻���ұ��Ƶ���ߣ������м�����
			int part1=Process(num-1, left, mid, right, from, to);
			int part2=1;
			System.out.println("Move "+num+" from "+from+" to "+mid);
			int part3=Process(num-1, left, mid, right, to, from);
			int part4=1;
			System.out.println("Move "+num+" from "+mid+" to "+to);
			int part5=Process(num-1, left, mid, right, from, to);
			return part1+part2+part3+part4+part5;
		}
			
		
	}

	public static void main(String[] args) {
		System.out.println("�ǵݹ��ջ����");
		hanoi1(2,"A","B","C");
		System.out.println("�ݹ鷽��");
		hanoi2(2,"A","B","C");

	}

}
