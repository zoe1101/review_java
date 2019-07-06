package �ַ���;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string, we can "shift" each of its letter to its successive letter, 
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, 
group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class ��λ�ַ������� {
/*
ͬ����λstring��ӵ����ͬ����λ���룬����abc, bcd, xyz ������λ��1�����롣
����������ԣ����ǿ��԰�bcd �� xyz �ָ��� abc��

����HashMap������ԭʼ�� ��λstring ����key���ѿ��Իָ��� ԭʼ�Ĺ�λstring
�� ����strings��List������value ����map��
 */
	 public List<List<String>> groupStrings(String[] strings) {
	     List<List<String>> res = new ArrayList<>();
	     HashMap<String, List<String>> map = new HashMap<>();
	     
	     // store original string as key; (List) strings come from same original one as value
	     for(String str: strings){
	         int offset = str.charAt(0) - 'a'; //����ĸ����ĸa�ľ��룬һ��������
	         String key = "";
	         for(int i=0; i<str.length(); i++){
	        	//�ж���ǰ��ĸ��ʲô
	             char c = (char) (str.charAt(i) - offset); 
	             if(c < 'a') { //
	                 c += 26;
	             }
	             key += c;
	         }
	          
	         if(!map.containsKey(key)) {
	             map.put(key, new ArrayList<String>());
	         }
	         map.get(key).add(str);
	         
	     }
	     
	     // add each key's value into res
	     for(String key: map.keySet())
	     {
	         res.add(map.get(key));
	     }
	     
	     return res;
	 }
}
