package �ַ���;

import java.util.HashMap;
import java.util.Map;

/*
����һ������� (ransom) �ַ�����һ����־(magazine)�ַ�����
�жϵ�һ���ַ���ransom�ܲ����ɵڶ����ַ���magazines������ַ����ɡ�
������Թ��ɣ����� true �����򷵻� false��

(��Ŀ˵����Ϊ�˲���¶������ּ���Ҫ����־������������Ҫ����ĸ����ɵ����������˼��)

ע�⣺

����Լ��������ַ�����ֻ����Сд��ĸ��

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

 */
public class ����� {
    public boolean canConstruct(String ransomNote, String magazine) {
    	int[] hash =new int[26];
    	char[] r=ransomNote.toCharArray();
    	char[] m=magazine.toCharArray();
        for(int i = 0;i<m.length;++i){
            hash[m[i]-'a'] += 1;
        }
        for(int i = 0;i<r.length;++i){
            hash[r[i]-'a'] -= 1;
            if(hash[r[i] - 'a'] < 0) {
            	return false;
            }
        }
        return true;
    }
}
