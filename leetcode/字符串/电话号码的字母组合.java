package �ַ���;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1����Ӧ�κ���ĸ��
���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
//��������
//����˼·: �����㷨,�ݹ����
public class �绰�������ĸ��� {
    public static ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> list=new ArrayList<String>();
    	if (digits.length()==0) {
    		return list;
    	}
    	String string=new String();
    	backtracking(list, string, digits,0 );
    	return list;
    }
    
    public static void backtracking(ArrayList<String> list,String string,String digits,int flag) {
    	 String[] numberstring = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    	 if(flag>=digits.length()) { //������
    		 list.add(string);
    		 return;
    	 }
    	 String chars=numberstring[digits.charAt(flag)-'0']; //��ǰ����
    	 for(int i=0;i<chars.length();i++) {   //����һ�����ֶ�Ӧ��������ĸ
    		 backtracking(list, string+chars.charAt(i), digits, flag+1);//������һ�����ֶ�Ӧ��������ĸ
    	 }//��������
    	 
	}
    

	public static void main(String[] args) {

		String digits="34";
		System.out.println(letterCombinations(digits));

	}

}
