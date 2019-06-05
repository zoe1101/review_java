package ������Ŀ;

/*
��������n���������ĵ�i(i��1��ʼ�����ұ߿�ʼ����)λ���ϰ���������1�ĸ�����
�����iλ�ϵ�����Ϊx�Ļ�����
1.���x > 1�Ļ������iλ���ϰ�����1����ĿΪ��(��λ���� + 1��* 10 ^ (i-1) 
 	(���и�λ�����Ǵ�i+1λһֱ�����λ�����ɵ�����)
2.���x < 1�Ļ������iλ���ϰ�����1����ĿΪ��(��λ���� ��* 10 ^ (i-1)
3.���x == 1�Ļ������iλ���ϰ���1����ĿΪ��(��λ����) * 10 ^ (i-1) +(��λ����+1)   
	(���е�λ����ʱ�ӵ�i - 1λ��һֱ����1λ�����ɵ�����)
 */
public class һ��n��1���ֵĴ��� {
	public int oneNums(int n) {
		if (n<1) {
			return 0;
		}
		int len=getLenOfNum(n); //n��λ��
		if (len==1) {
			return 1;
		}
		int tmp1=powerBaseOf10(len-1);
		int first=n/tmp1;  //��ʾ��ǰ�����λֵ
		int firstOneNum=first==1?n%tmp1+1:tmp1;   //���λ��1�����Ƕ�Ӧ�����ĸ���
		int otherOneNum=first*(len-1)*(tmp1/10);
		return firstOneNum+otherOneNum+oneNums(n%tmp1);
		
	}

	private int powerBaseOf10(int base) {
		return (int) Math.pow(10, base);
	}

	private int getLenOfNum(int n) {
		int len=0;
		while (n!=0) {
			len++;
			n=n/10;
		}
		return len;
	}

}
