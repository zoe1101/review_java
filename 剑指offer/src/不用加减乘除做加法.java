package src;
/*
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */
//λ�������
public class ���üӼ��˳����ӷ� {
    public int Add(int num1,int num2) {
        while (num2!=0) {//��λֵΪ0ʱ�˳�ѭ��
			int temp=num1^num2;// ��������������൱�����,�����λ
			num2 = (num1 & num2) << 1;// ���λ�൱�������,������һλ
			num1=temp;
		}
       return num1;
    }
}
