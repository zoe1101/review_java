package �ַ���;

public class ɾ�������ַ��õ��ֵ�����С���ַ��� {
	public static String removeDuplicateLetters(String s) {
		char[] str=s.toCharArray();
		int[] map=new int[26]; //��26����ĸ������Ƶͳ��
		for (int i = 0; i < str.length; i++) {
			map[str[i]-'a']++;
		}
		char[] res=new char[26];
		int index=0; //��ǰ�ַ������ֵ��е�����λ��
		//��str[i..r]���ҵ���С���ַ���Ϊ��ǰ�ַ�
		int l=0;
		int r=0;
		while (r!=str.length) {
			if (map[str[r]-'a']==-1 || --map[str[r]-'a']>0) {
				r++;
			}else {
				int pick=-1;
				for (int i = l; i <= r; i++) {
					if (map[str[i]='a']!=-1 && (pick==-1 || str[i]<str[pick])) {
						pick=i;
					}
				}
				res[index++]=str[pick];
				for (int i = pick+1; i <= r; i++) {
					if (map[str[i]='a']!=-1) {
						map[str[i]-'a']++;
					}
					
				}
				map[str[pick]-'a']=-1; //��ǰ�ַ���ʹ�ú���Ϊ-1�����������ٿ���
				l=pick+1; //�ڵ�ǰ�ַ�������λ�õĺ�벿�ֲ�����һ���ַ�
				r=l;
			}
		}
		return String.valueOf(res,0,index);
	}

}
