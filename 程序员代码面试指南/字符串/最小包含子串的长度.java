package �ַ���;
//�����ַ���str1��str2,��str1���Ӵ��к���str2�����ַ�����С�Ӵ�����)
public class ��С�����Ӵ��ĳ��� {
	public static int minLength(String str1,String str2) {
		if (str1==null ||str2==null || str1.length()<str2.length()) {
			return 0;
		}
		char[] chas1=str1.toCharArray();
		char[] chas2=str2.toCharArray();
		int[] map=new int[256]; //ʹ��һ�����¼str2��ÿһ���ַ����ֵĴ�����
		for (int i = 0; i < chas2.length; i++) {
			map[chas2[i]]++;
		}
//		left��right��ʾstr1�Ӵ�str1[left��right]�����߽��±�
		int left=0;
		int right=0;
//		match��ʾ���Ӵ�str1[left��right]��Ŀǰһ��Ƿstr2���ٸ��ַ���
		int match=chas2.length;
		int minLen=Integer.MAX_VALUE; //��¼�������������г��ֵ���С���Ӵ����ȡ�
		
		//����str1������������right��������str2�е��ַ�ʱ����map����Ӧ��ֵ -1��ͬʱmatchҲ -1��
		//��������Ĳ���str2�е��ַ�����(str1[right]��-1)��¼��map��
		while (right!=chas1.length) {
			map[chas1[right]]--; //str2���еľ���map[chas1[right]]-1,û�еľ���0-1;����map[chas1[right]]-1
			if (map[chas1[right]]>=0) {
				match--;
			}
			//��match == 0ʱ��˵��str1[left��right]�Ѿ�������str2�е������ַ���
			//���Ǵ�ʱ���Ӵ����Ȳ�һ���Ǹ��Ӵ�����С����.
			//���Խ���������һ����������left�Ĺ��̡� 
			if (match==0) {
				//��������left,���map[str1[left]] < 0��˵����ʱ���������ַ���������
				//str1[left��right]��Ҳ����Ƿstr2�ַ������Լ�����ַ���
				while (chas1[left]<0) {
					map[chas1[left++]]++;
				}
				//���map[str1[left]] == 0��˵��һ��������ַ�����ôstr1[left��right]��Ȼ��Ƿstr2һ���ַ���
				//���Դ�ʱleft������ֹ����ʱleft��right��ֵ����һ����С�Ӵ��� 
				minLen=Math.min(minLen, right-left+1);
				match++;
				map[chas1[left++]]++;
			}
			right++;
		}
		return minLen==Integer.MAX_VALUE?0:minLen;
	}

}
