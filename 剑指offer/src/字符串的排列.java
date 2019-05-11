package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ����:�����ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 * @author zoe
 *
 *
 * ȫ���е�˼�룬��ȷ����i����Ȼ�������Ԫ�ص�ȫ���н���ƴ��
 */
public class �ַ��������� {
    public ArrayList<String> Permutation(String str) {
    	ArrayList<String> res = new ArrayList<String>();
        if(str==null || str.length()==0) {
        	return res;
        }
        char[] chas=str.toCharArray();
        findPermutation(res, chas, 0);
        Collections.sort(res);//Collections��sort�������Դ����list��������ֱ�Ӹı�ԭlist���޷���ֵ��
        return res;
        
    }
  //��chas[i~length-1]��Χ�ڵ��ַ��������ȫ���У������������res��
    public void findPermutation(ArrayList<String> res, char[] chas, int i) {
    	if(i==chas.length) {
    		res.add(new String(chas));
    		return;
    	}
    	HashSet<Character> set=new HashSet<Character>();
    	 //�ӡ�i~length-1����ö��ȷ��iλ�õ��ַ�
    	for(int j=i;j<chas.length;j++) {
    		//�����ǰδ��ѡ��
    		if(!set.contains(chas[j])) {
    			set.add(chas[j]);
    			swap(chas, i, j); //����
    			//ȷ����iλ�ã���chas[i+1~length-1]��Χ�ڵ��ַ��������ȫ����
    			findPermutation(res, chas, i+1);
    			swap(chas, i, j); //�ָ�ԭ����
    		}
    	}
    }
    public void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
    }
}
