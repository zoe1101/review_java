package Math;
/*
����һ������ n����������С�ڵ��� n �ķǸ����������� 1 ���ֵĸ�����

ʾ��:
����: 13
���: 6 
����: ���� 1 ����������������: 1, 10, 11, 12, 13 ��

 */
public class ����1�ĸ��� {
    public int countDigitOne(int n) {
    	if (n<1) {
			return 0;
		}
		int len=getNumLen(n); //n��λ��
		if (len==1) {
			return 1;
		}
        int temp=powerBaseOf10(len-1);//nΪ123��tempΪ100
    /*
    ��һ�����ֲ��Ϊ���λ�����ұ� ������ 3452����� 3 �� 452�� ���λ high = 3, last = 452, 
    ���ķ�Χ�Ǽ�ǧ�����֣���ô power = 1000 �ȿ����λ�����˶��ٸ� 1��
    ������λ����1�� ��ô���λ����1000��1��1000~1999 ��ôʣ��λ���׶��ٸ�1�أ�
    ֻҪ��0-999�ĸ���ʮ����λ�����˶��ٸ�1�� ��ô 1000~1999��2000~2999���ĸ���ʮ����λ���׵�1��
    ��������һ���� ��high * countDigitOne(power-1)��1 ���ʣ��3000-3452��last+1�����ֵ�
    ����ʮ����λ���׵�1����������countDigitOne(last)
     */
        int first=n/temp; //���λ����
        //���λ�ܹ��׶��ٸ�1
        //123�ܹ���24��123%100+1����1��100-123��
        //223�ܹ�����100��1��100-199��
        int firstOneNum=first==1?n%temp+1:temp; 
        //�����λ����������Թ��׶��ٸ�1
        int otherOneNum=first*(len-1)*(temp/10);
        return firstOneNum+otherOneNum+countDigitOne(n%temp); //�ݹ�Ĺ���
    }

	private int powerBaseOf10(int i) {
		return (int) Math.pow(10, i);
	}

	private int getNumLen(int n) {
		int len=0;
		while (n!=0) {
			len++;
			n=n/10;
		}
		return len;
	}
}
