package �ַ���;

import java.util.HashMap;
import java.util.Map;

import test.hashmap;

/*
����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ��ĳ��ȡ�

ʾ�� 1:
����: "abcabcbb"
���: 3 
����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��

��ս��O(n) ʱ�� 
 */
//���Ҫʵ��O(n) ʱ�䣬����һ�α����ַ����� 
//��HashMap<�ַ���λ��>����ÿ���ַ���λ�ã���temp��¼��ǰ�ַ������ȡ�
public class ���ظ��ַ�����Ӵ� {
	//hash
    public static int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> posMap=new HashMap<Character, Integer>();
    	char[] ss=s.toCharArray();
    	int max=0;
		int temp=0;  //��¼��ǰ�ַ�������
    	for(int i=0;i<s.length();i++) { //�ַ�������, i�ǵ�ǰ�ַ�λ��
    		if(!posMap.containsKey(ss[i])) { //δ�����ظ��ַ�
    			posMap.put(ss[i], i);
    			temp++;
    		}else { //�����ظ��ַ�
    			
    			if(posMap.get(ss[i]) + temp < i){ //�ַ���һ�γ���λ�ò��ڵ�ǰ�ַ�����
                    temp++;                
                }else {
	    			max=Math.max(max, temp);
	    			temp=i-posMap.get(ss[i]);  
                }
    			posMap.put(ss[i], i); //����key����Ӧ��ֵ
    		}
    	}
    	 max=Math.max(max, temp);
    	 return max;

    }
	public static void main(String[] args) {
		String s= "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));

	}
   

}
