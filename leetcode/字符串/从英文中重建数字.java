package �ַ���;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import test.hashmap;
import �ֽ��������316.main1;

/*
����һ���ǿ��ַ��������а�����ĸ˳����ҵ�Ӣ�ĵ��ʱ�ʾ������0-9�����������ԭʼ�����֡�

ע��:

����ֻ����СдӢ����ĸ��
���뱣֤�Ϸ�������ת��Ϊԭʼ�����֣�����ζ���� "abc" �� "zerone" �������ǲ�����ġ�
�����ַ����ĳ���С�� 50,000��
ʾ�� 1:

����: "owoztneoer"
���: "012" (zeroonetwo)
ʾ�� 2:

����: "fviefuro"
���: "45" (fourfive)

 */
public class ��Ӣ�����ؽ����� {
/*
 *һЩ�����ǱȽ�����ģ�����ͨ��ͳ���ض���ĸ�ĳ��ָ�����ͳ�Ƶ�������
�ȶ�ÿ����ĸ����Ƶ��ͳ�ƣ�Ȼ�������ĸ�������飬���δ�ԭ��ĸƵ��ͳ���б��м����õ�������ĸƵ����С
����ĸƵ�����������ƴ���ַ�������󣬶Եõ��Ľ���������򼴿ɡ�
ע�⣬ɾ�������бȽ��ϸ��˳������ɾ��eight��Ϊֻ��eight��g,ͬ������ɾ��six��zero��two,ɾ����two֮���
����ɾ��three�ˣ���Ϊtwoɾ�꣬��t��ĸ��ֻ��three�ˣ�֮���˳��Ҳ�ǰ���ͬ���ķ�ʽ��������
 */
    public static String originalDigits(String s) {
    	 int[] nums={0,2,4,6,1,5,3,7,8,9};
         char[] indicates={'z', 'w', 'u', 'x', 'o', 'f', 'r', 'v', 'h', 'e'};
         String[] strs={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
         char[] chas=s.toCharArray();
         Map<Character, Integer> charMap=new HashMap<Character, Integer>();
         for(char c : chas) {
        	 charMap.put(c, charMap.getOrDefault(c, 0)+1);
         }
 
         StringBuilder sb=new StringBuilder();
         for(int i=0; i<nums.length; i++){ //��������
             if(charMap.containsKey(indicates[i]) && charMap.get(indicates[i]) != 0){
                 int count = charMap.get(indicates[i]); //��ĸ���ִ���
                 for(char c : strs[nums[i]].toCharArray()){
                	 if (charMap.containsKey(c)) {
                		 charMap.put(c, charMap.get(c)-count);
					}
                 }
                 for (int j = 0; j < count; j++) {
                	 sb.append('0'+nums[i]);
				}
             }
         }
         Arrays.sort(sb.toString().toCharArray());
         return sb.toString();
    }
    public static void main(String[] args) {
		String string="owoztneoer";
		System.out.println(originalDigits(string));
		
	}
}
