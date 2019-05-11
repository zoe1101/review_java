package src;
/**
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
 * Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
 * @author zoe
 *
 */
public class ������1���ֵĴ���_��1��n��1���ֵĴ��� {
	//���α���ÿ����,�ж�ÿ���������Ƿ����1
    public int NumberOf1Between1AndN_Solution(int n) {
        int res=0;
        for(int i=1;i<=n;i++) {
        	res+=number1(i);
        }
        return res;
    }
    public int number1(int n) { //�������а���1�ĸ���
		int res=0;
		while (n>0) {
			if(n%10==1) {
				res++;
			}
			n/=10;
		}
		return res;
	}
    
//    ������ת���ַ�����ֱ���ж�
    public int NumberOf1Between1AndN_Solution2(int n) {
    	int res=0;
    	StringBuffer stringBuffer=new StringBuffer();
        for(int i=1;i<=n;i++) {
        	stringBuffer.append(i);
        }
        String string=stringBuffer.toString();
        for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i)=='1') {
				res++;
			}
		}
        return res;
    }
    
    /**���ɷ�
     *  ����Ҫ֪�����¹���:
�� 1 �� 10�������ǵĸ�λ���У������ x �������� 1 ��
�� 1 �� 100�������ǵ�ʮλ���У������ x �������� 10 ��
��1��1000�������ǵİ�λ���У������x��������100��
�������ƣ��� 1 �� 10^i�������ǵ������ڶ�λ(������ i λ)������� x �������� (10^(i-1))�Ρ�


����abXcd��˵��
X=0ʱ�����ab=01����ô����00100~00199��100�����ֶ���Xλ��1������
X=1ʱ�����ab=01����ô����00100~00199��100������ + ab100~ab1cd���cd������
X>=2ʱ�����ab=01����ô����00100~00199��100������ + 01100~01199��100������
     **/
   
    public int NumberOf1Between1AndN_Solution3(int n) {
	    int res = 0;
	    int cur = 0, before = 0, after = 0;
	    int i = 1;
	    while(i<=n){
	        before = n/(i*10);
	        cur = (n/i)%10;
	        after = n - n/i*i;
	        if(cur == 0){
	            // ���Ϊ0. ����1�Ĵ����ɸ�λ����,���ڸ�λ���� * ��ǰλ��
	            res += before * i;
	        }else if(cur == 1){
	            // ���Ϊ1, ����1�Ĵ����ɸ�λ�͵�λ����,��λ*��ǰλ+��λ+1
	            res += before * i + after + 1;
	        }else{
	            // �������1, ����1�Ĵ����ɸ�λ����,����λ����+1��* ��ǰλ��
	            res += (before + 1) * i;
	        }
	        i *= 10;
	    }
	    return res;
    }
}
