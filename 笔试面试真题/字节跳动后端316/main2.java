package �ֽ��������316;

import java.util.ArrayList;
import java.util.Scanner;
/*
�ڶ���:
	1.����ͬ������ĸ����һ��һ����ƴд����ȥ��һ���ͺ��ˡ�����:helllo --> hello
	2.����һ������ĸ(AABB��)����һ��һ����ƴд����ȥ���ڶ��Եĵ�һ����ĸ������:helloo --> hello
	3.����Ĺ������ȡ������ҡ�ƥ�䣬�������AABBCC�ͣ�Ӧ���ȿ����޸�AABBΪAABCC��
*/
//����˼·��ɨ�裬��ǰ��󲻶ϸ��£�ƥ������Ժ�ȥ����ĸ�Ϳ���
public class main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine()); //��Ҫ�������ַ�������
        for (int i = 0; i <num; i++) {

            System.out.println(modify(s.nextLine()));
        }

    }
    public static String modify(String s) {
        ArrayList<Character> list = new ArrayList<>(); //���ö�̬����洢
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int size = list.size();
            if (size <1 ||  list.get(size - 1) != c) list.add(c); //ǰһ���ַ��뵱ǰ�ַ���ͬ,�����ַ���ǰ�����ַ�ʱ
            else {
               if (list.get(size - 2) == c) {//����AABB��

               } else {
                   if (size == 2 || list.get(size - 2) != list.get(size - 3)) 
                       list.add(c);
               }
            }
        }
        String ans = "";
        for (int i = 0; i <list.size(); i++) {
            ans += list.get(i);
        }
        return ans;
    }

}
