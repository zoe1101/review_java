package ����;
/*
����һλ�о������ı����ô��������飨�����ô����ǷǸ�����������дһ��������������о��ߵ� h ָ����
h ָ���Ķ���: ��h ���������ô�������high citations����һ��������Ա�� h ָ����ָ���������� ��N ƪ�����У�
������ h ƪ���ķֱ����������� h �Ρ�������� N - h ƪ����ÿƪ�����ô��������� h �Ρ�����

����: citations = [3,0,6,1,5]
���: 3 
����: ���������ʾ�о����ܹ��� 5 ƪ���ģ�ÿƪ������Ӧ�ı������� 3, 0, 6, 1, 5 �Ρ�
�����о����� 3 ƪ����ÿƪ���ٱ������� 3 �Σ�������ƪ����ÿƪ�����ò����� 3 �Σ��������� h ָ���� 3��

��� h �ж��ֿ��ܵ�ֵ��h ָ�������������Ǹ���
 */

public class hָ�� {
    public int hIndex(int[] citations) {
        int len=citations.length;
        int max=len; //h�����ֵ
        int min=0; //h����Сֵ
        int res=0;//���յĽ��
        while (min<=max) {
			int mid=(min+max)/2;
			int low=0;//��¼���ô������ڵ���mid�εĴ���
			int high=0; //��¼���ô���С��mid�εĴ���
			for (int i = 0; i < len; i++) {
				if (citations[i]>=mid) {
					high++;
				}else {
					low++;
				}
			}
			if (high>=mid && low<=len-mid) {
				if (mid>res) {
					res=mid;
				}
				min=mid+1;
			}else {
				max=mid-1;
			}
		}
        return res;
    }
}
