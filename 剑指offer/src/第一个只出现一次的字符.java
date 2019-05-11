package src;

import java.util.Arrays;
import java.util.HashMap;

/*
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, 
 * ���û���򷵻� -1����Ҫ���ִ�Сд��.
 */
public class ��һ��ֻ����һ�ε��ַ� {
    public static int FirstNotRepeatingChar(String str) {
    	char[] chas=str.toCharArray();
    	int[] hastTable=new int[58]; //��Сд��ĸ��58��

    	//ͳ���ַ����ֵĴ���������hastTable��
    	for (int i = 0; i < chas.length; i++)
        {
            hastTable[chas[i]-'A']++;
        }
    	//��˳����б���,�����ֵĴ˴�Ϊ1���ַ���ӡ����
        for (int i = 0; i < chas.length; i++)
        {
            if (hastTable[chas[i]-'A'] == 1)
            {
                return i;
            }
        }
        return -1;
    }
    
    //�ù�ϣ��ķ�ʽ����ͳ���ַ����ֵ�������ʱ�临�Ӷ�O(n)
    private int printFirstLetter2(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
             if (hashMap.containsKey(str.charAt(i))){
                 int value = hashMap.get(str.charAt(i));
                 hashMap.put(str.charAt(i), value+1);
             }else {
                 hashMap.put(str.charAt(i), 1);
             }
        }

        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1){
            	return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
	    String string="abbaccdeff";
	    System.out.println(FirstNotRepeatingChar(string));

	}

}
