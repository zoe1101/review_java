package Math;
/*
����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���

ʾ�� 1:

����: 1
���: true
����: 20 = 1
 */
public class two���� {
	//2���ݴη��ڶ������£�ֻ��1λ��1������ȫ��0��
    public boolean isPowerOfTwo(int n) {
        if (n<=0) {
			return false;
		}
        if ((n&(n-1))==0) { //n��1000��n-1:0111
			return true;
		}
        return false;
    }
}
