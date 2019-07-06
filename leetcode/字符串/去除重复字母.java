package �ַ���;

import java.util.Map;
import java.util.Stack;

import �ֽ��������316.main1;

/*
����һ��������Сд��ĸ���ַ�����ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ�
�豣֤���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���

ʾ�� 1:
����: "bcabc"
���: "abc"

ʾ�� 2:
����: "cbacdcbc"
���: "acdb"

 */
public class ȥ���ظ���ĸ {
    public static String removeDuplicateLetters(String s) {
        if (s==null || s.length()<2) {
			return s;
		}
        char[] chas=s.toCharArray();
        int[] map=new int[26]; //����26��ĸ����
        boolean[] visited = new boolean[26];//�����ĸ�Ƿ��Ѿ���ջ
        for (int i = 0; i < chas.length; i++) {
			map[chas[i]-'a']++;
		}
        Stack<Character> stack = new Stack<>();
        int index = 0;//�����ַ��ĳ���
        for (int count : map) {
            if (count > 0) index++;
        }
        char[] res = new char[index];
        for (int i = 0; i < chas.length; i++) {
            //��С�ַ�����������ǰ����ַ���С�ַ�����ͬ���ַ��ģ����ջ
            while (!stack.isEmpty() && chas[i] < stack.peek() 
            		&& map[stack.peek() - 'a'] > 1 && !visited[chas[i] - 'a']) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
                map[pop - 'a']--;
            }
            if (visited[chas[i] - 'a']) {
            	map[chas[i] - 'a']--;//�ظ����ַ������α������ƶ���������һ
                continue;
            }
            stack.push(chas[i]);
            visited[chas[i] - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            res[--index] = stack.pop();
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
		String string="bcabc";
		System.out.println(removeDuplicateLetters(string));
	}
}
