package �ַ���;

import java.util.HashMap;
import java.util.Map;

/*
����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��

����:

s = "leetcode"
���� 0.

s = "loveleetcode",
���� 2.
 */
public class �ַ����еĵ�һ��Ψһ�ַ� {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map=new HashMap<>();
        char[] chas=s.toCharArray();
        for (char c:chas) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
		}
        for (char i = 0; i < chas.length; i++) {
			if (map.get(chas[i])==1) {
				return i;
			}
		}
        return -1;
        
    }
}
