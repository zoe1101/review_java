package ����;
/*
�����ں���������� �����֣�Bulls and Cows����Ϸ����д��һ��������������Ѳ¡�
ÿ�����²�������һ����ʾ���������ж���λ���ֺ�ȷ��λ�ö��¶��ˣ���Ϊ��Bulls��, ��ţ����
�ж���λ���ֲ¶��˵���λ�ò��ԣ���Ϊ��Cows��, ��ţ����������ѽ��������ʾ�����£�ֱ���³��������֡�
��д��һ�������������ֺ����ѵĲ²���������ʾ�ĺ������� A ��ʾ��ţ���� B ��ʾ��ţ��

��ע���������ֺ����ѵĲ²��������ܺ����ظ����֡�

����: secret = "1807", guess = "7810"
���: "1A3B"
����: 1 ��ţ�� 3 ��ţ����ţ�� 8����ţ�� 0, 1 �� 7��
 */
//�Ѷ�: medium
//ͳ��ͬһλ����ĸ��ͬ�ĸ�����Ϊbull�ĸ�����
//��secret��guess��������µ��ַ�ʣ����Ŀ�ֱ�ͳ�ƣ���ʱȡ������Сֵ�ۼ��������ɣ�Ҳ����cowֵ��
public class ��������Ϸ {
    public String getHint(String secret, String guess) {
        int a=0;
        int b=0;
        int[]  cache1=new int[10];  //[0,9]�е����ֳ��ָ���ͳ��
        int[]  cache2=new int[10];
        for(int i=0;i<secret.length();i++) {
        	if(secret.charAt(i)==guess.charAt(i)) {
        		a++;
        	}else {// ��secret�к��е����ַ���
        		 cache1[secret.charAt(i)-'0']++; // ��secret�к��е����ַ���,����ͳ��
        		 cache2[guess.charAt(i)-'0']++;  // ��guess�к��е����ַ���,����ͳ��
			}
        }
        for (int i = 0; i < cache1.length; i++) {  // ����b�Ĵ�С
			b+=Math.min(cache1[i], cache2[i]);
        }
		return a+"A"+b+"B";
    }
}
