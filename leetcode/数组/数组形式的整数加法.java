package ����;
/*
���ڷǸ����� X ���ԣ�X ��������ʽ��ÿλ���ְ������ҵ�˳���γɵ����顣
���磬��� X = 1231����ô��������ʽΪ [1,2,3,1]��
�����Ǹ����� X ��������ʽ A���������� X+K ��������ʽ��

���룺A = [1,2,0,0], K = 34
�����[1,2,3,4]
���ͣ�1200 + 34 = 1234
 */
//����˼·�������ӷ����൱������ʽ����
import java.awt.List;
import java.util.ArrayList;

public class ������ʽ�������ӷ� {
	public static ArrayList<Integer> addToArrayForm(int[] A, int K) {
        int carry=0;//��λ��־
        int t;//�����ݴ�����
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=A.length-1;i>=0;i--,K/=10) {
        	t=A[i]+K%10+carry;
        	carry=t/10;//�ж��Ƿ���Ҫ��λ
        	list.add(0,t%10);//������������
        }
        //���K��A��λ���࣬��������мӷ�����
        while(K>0) {
        	t=K%10+carry;
        	carry=t/10; //�ж��Ƿ���Ҫ��λ
        	list.add(0,t%10);
        	K/=10;
        }
        if(carry>0) {//�Խ�λ�����λ��1��������д���
        	list.add(0,carry);
        }
        return list;
    }

	public static void main(String[] args) {
		int[] A= {9,9,9,9,9,9,9,9,9,9};
		int K=101;
		System.out.println(addToArrayForm(A,K));

	}

}
