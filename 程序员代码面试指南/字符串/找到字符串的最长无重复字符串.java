package �ַ���;

public class �ҵ��ַ���������ظ��ַ��� {
	//���ù�ϣ��ʵ��
	public static int maxUnique(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int[] map=new int [256]; //256��ascii�����ַ��������һ�γ��ֵ�λ��
		for (int i = 0; i < chas.length; i++) {
			map[i]=-1;
		}
		int len=0; //����ظ��ַ����ĳ���
		int pre=-1; //����ظ��ַ�����ʼλ�õ�ǰһ��λ��
		int cur=0; //��ǰ���ظ��ַ����ĳ���
		for (int i = 0; i < chas.length; i++) {
			pre=Math.max(pre, map[chas[i]]);
			cur=i-pre;
			len=Math.max(len, cur);
			map[chas[i]]=i;
		}
		return len;		
	}

}
