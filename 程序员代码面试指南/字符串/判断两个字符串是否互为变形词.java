package �ַ���;
/**
���������ַ���s1,s2,���s1��s2�г��ֵ��ַ�������ַ�����һ���࣬��s1��s2��Ϊ���δʣ�ʵ�ֺ����ж������ַ����Ƿ�Ϊ���δʡ�

��
s1=��123��,s2=��321�� ,return true;
s1=��123��,s2=��2113��,return false;

 * @author zoe
 *
 */
public class �ж������ַ����Ƿ�Ϊ���δ� {
	public static boolean isDeformation(String s1,String s2) {
		if(s1==null || s2==null ||s1.length()!=s2.length()) {
			return false;
		}
		int[] map=new int[256]; //asscii������0-255��Χ��,��ÿһ���ַ����м���
		char[] str1=s1.toCharArray();
		char[] str2=s2.toCharArray();
		for(int i=0;i<str1.length;i++) {
			map[str1[i]]++;
		}
		
		for(int i=0;i<str2.length;i++) {
			if(map[str2[i]]--==0) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		String A = "abcabcabc";
		String B = "bcacbaacc";
		System.out.println(isDeformation(A, B));

	}

}
