package ����;
/*
����һλ�о������ı����ô��������飨�����ô����ǷǸ��������������Ѿ������������С�
��дһ��������������о��ߵ� h ָ����
h ָ���Ķ���: ��h ���������ô�������high citations����һ��������Ա�� h ָ����ָ���������� ��N ƪ�����У�
������h ƪ���ķֱ����������� h �Ρ�������� N - h ƪ����ÿƪ�����ô��������� h �Ρ���"

ʾ��:
����: citations = [0,1,3,5,6]
���: 3 
����: ���������ʾ�о����ܹ��� 5 ƪ���ģ�ÿƪ������Ӧ�ı������� 0, 1, 3, 5, 6 �Ρ�
     �����о����� 3 ƪ����ÿƪ���ٱ������� 3 �Σ�������ƪ����ÿƪ�����ò����� 3 �Σ��������� h ָ���� 3��
 
˵��:
��� h �ж����ֿ��ܵ�ֵ ��hָ�������������Ǹ���
 */
//����ʵ��
public class Hָ��II {
	/*
	������Ҫ��һ��mid����mid��ʼ��������������ΪpaperCnt����Щpaper�������������
	Ҫ���ڵ���paperCnt��hIndex���壩����ô����ֻ����͵����������Ƿ����paperCnt�����ˣ�
	Ҳ����ֻ��citations[mid]�ǲ��Ǵ��ڵ���paperCnt�����ˡ�
	 */
    public int hIndex(int[] citations) {
    	int len=citations.length;
        int left=0;
        int right=len-1;
        int res=0;
  
        while(left<=right){
        	int mid=(left+right)>>1;
        	int paperCnt = len - mid;
        	if (paperCnt <= citations[mid]) {
                res = paperCnt;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }
}
