package Math;
/*
��������Ǽ��� a^b �� 1337 ȡģ��a ��һ����������b ��һ���ǳ�����������һ���������ʽ������

����: a = 2, b = [1,0]
���: 1024
 */
//���ð�λ����������2^23 = (2^2)^10 * 2^3, 
//�������ǿ��Դ�b�����λ��ʼ��������������res��Ȼ����һλ�ǣ�res��ʮ�η��ٳ���a�ĸ�λ�η��ٶ�1337ȡ��

//�������ĳ˻�������ڣ�ab % k = (a%k)(b%k)%k
public class �����η� {
    public static int superPow(int a, int[] b) {
    	int res=1;
        for(int i=0;i<b.length;i++) {
        	res=powMod(res, 10)*powMod(a, b[i])%1337;
        }
        return res;
    }
    public static int powMod(int x, int n) { ////����x^n %(k),��0<=n<=10
        if (n == 0) return 1;
        if (n == 1) return x % 1337;
        return powMod(x%1337, n/2) * powMod(x%1337, n-n/2)%1337;
    }
    
	public static void main(String[] args) {
		int a=2;
		int[] b= {1,0,0};
		System.out.println(superPow(a,b));

	}

}
