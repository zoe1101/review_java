package �ַ���;
/*
 ��дһ�������������ַ��������е������ǰ׺��

��������ڹ���ǰ׺�����ؿ��ַ��� ""��

ʾ�� 1:
����: ["flower","flow","flight"]
���: "fl"
 */
public class �����ǰ׺ {
    public String longestCommonPrefix(String[] strs) {
    	if (strs==null || strs.length==0) {
			return "";
		}
    	if (strs.length == 1){
            return strs[0];
        }
    	StringBuilder sb = new StringBuilder();
    	int len=strs[0].length();
    	//�ѵ�һ���ַ���������׼�ַ�����Ȼ�����������ַ������αȽ�
    	for (int i = 0; i <len; i++) { 
    		char cur = strs[0].charAt(i);
    		for (int j = 1; j < strs.length; j++) {
    			if (strs[j].length()<=i ||strs[j].charAt(i) != cur) {
                    return sb.toString();
                }
    			if (strs[j].charAt(i) == cur && j == strs.length - 1) {
                    sb.append(cur);
                }
    				
			}
		}
    	return sb.toString();
	}

}
