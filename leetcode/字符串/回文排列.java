package �ַ���;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
����һ���ַ������жϸ��ַ������Ƿ����ͨ������������ϣ��γ�һ�������ַ�����

ʾ�� 1��
����: 
"code"
���: false

ʾ�� 2��
����: 
"aab"
���: true
 */
public class �������� {
/*
���ַ����ĸ�������ż����������ۣ������ż���Ļ������ڻ����ַ��������ԣ�
ÿ����ĸ���ֵĴ���һ����ż���Σ����ַ�������������ʱ��ֻ��һ����ĸ���ֵĴ����������������Ϊż����
��ô��������������ǾͿ��Խ��⣬���ǽ���ÿ����ĸ������ִ�����ӳ�䣬
Ȼ�����Ǳ��� HashMap��ͳ�Ƴ��ִ���Ϊ��������ĸ�ĸ�������ôֻ����������ǻ�������
��һ����û�г��ִ���Ϊ��������ĸ����һ�������ַ�������Ϊ��������ֻ��һ�����ִ���Ϊ��������ĸ
 */
	public static boolean canPermutePalindrome(String s) {
		int len=s.length();
		char[] str=s.toCharArray();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for (char c:str) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int oddcount=0;
		for (Entry<Character, Integer> entry:map.entrySet()) {
			int count=entry.getValue();
			if (count%2==1) {
				oddcount++;
			}
		}
		return oddcount==0 || (len%2==1 && oddcount==1);
	}
	public static void main(String[] args) {
		String s="add";
		System.out.println(canPermutePalindrome(s));
	}
}
