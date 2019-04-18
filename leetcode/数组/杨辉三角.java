package ����;

import java.util.ArrayList; //ArrayList��һ�������ࡣ

/*
����һ���Ǹ����� numRows������������ǵ�ǰ numRows �С�
����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
����: 5
���:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

//����: ��̬�滮
//���ڹ���������ǵĵ����������Թ���Ϊ��̬�滮, ��Ϊ������Ҫ����ǰһ��������ÿһ�С�
public class ������� {

	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		if(numRows==0) {//0�е����
			return list;
		}
		ArrayList<Integer> firstrow=new ArrayList<Integer>();
		firstrow.add(1);
		list.add(firstrow);//��һ������[1] 
		
		for(int i=1;i<numRows;i++) {
			ArrayList<Integer> rowlist=new ArrayList<Integer>();
			ArrayList<Integer> prerowlist=list.get(i-1);//��ȡ��һ�е�Ԫ��
			rowlist.add(1);///ÿһ�еĵ�һ��Ԫ������1;
			for(int j=1;j<i;j++) {
				rowlist.add(prerowlist.get(j-1)+prerowlist.get(j));
			}
			rowlist.add(1);//ÿһ�е����һ��Ԫ������1;
			list.add(rowlist);
		}
		return list;
        
    }
	public static void main(String[] args) {
		int  numRows=5;
		System.out.println(generate(numRows));

	}

}
