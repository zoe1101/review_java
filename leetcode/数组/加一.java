package ����;

import test.class_A;

/*
����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�
����Լ���������� 0 ֮�⣬��������������㿪ͷ��

����: [1,2,3]
���: [1,2,4]
����: ���������ʾ���� 123��
 */
//����˼·��ʹ�üӷ���λ��ԭ�������⡣
public class ��һ {
	 public static int[] plusOne(int[] digits) {
        int carry=0;//��λ��־
        int index=digits.length-1;
        if(digits[index]<9){  //ĩβС��9  ֱ�Ӽ�һ  ��������
            digits[index]+=1;
            return digits;
        }
        while(digits[index]==9){      //ĩβΪ9
            digits[index]=0;   //ĩβ��0  ֮���жϴ�ĩβ
            if(index==0){          //��������Ϊ999 �� 9���ּ������
                //��������������µ�����ռ�
                int newLen=digits.length+1;
                int[] newDigits=new int[newLen];
                newDigits[0]=1;//���λ��1
                return newDigits;
            }
            --index;  //���жϴ�ĩβ�Ƿ�Ϊ9
            carry=1;   //��λ
        }
        digits[index]=digits[index]+carry;
        return digits; 
    }
	public static void main(String[] args) {
		int[] digits= {9,9,9,9};
		for(int e:plusOne(digits)){
			System.out.println(e+" ");
		}

	}

}
