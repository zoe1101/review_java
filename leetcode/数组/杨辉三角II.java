package ����;

import java.awt.List;
import java.util.ArrayList;

/*
����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�

����: 3
���: [1,3,3,1]
 */
//��������εĵ�n�е�m�����ɱ�ʾΪ C(n-1,m-1).
public class �������II {
	public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> resultList=new ArrayList<Integer>(rowIndex+1);
        long nk = 1;
        for(int i=0;i<=rowIndex;i++) {
        		resultList.add((int)nk);
        		nk=nk*(rowIndex-i)/(i+1);
        	}
        return resultList;
    }
	public static void main(String[] args) {
		int rowIndex=3;
		System.out.println(getRow(rowIndex));
		

	}

}
