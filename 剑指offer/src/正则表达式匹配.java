package src;
/*
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
 * ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */

/*
 ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
2������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��

����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
������3��ƥ�䷽ʽ��
1��ģʽ����2�ַ����൱��x*�����ԣ�
2���ַ�������1�ַ���ģʽ����2�ַ���x*�൱��ֻƥ��һ���ַ���
3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
 */
public class ������ʽƥ�� {
//	�ݹ鷨
   public boolean match(char[] str, char[] pattern){
        if (str==null || pattern==null) {
			return false;
		}
        return patternmatch(str, pattern, 0, 0);

    }
   
   public boolean patternmatch(char[] s, char[] p, int sIndex, int pIndex) {
	   if(pIndex==p.length) {//p���Ѿ��þ�
		 //��sҲ�Ѿ��þ�����ƥ��ɹ�������ƥ��ʧ��
		   return sIndex == s.length;
	   }
	 //pIndex��p���һ���ַ������� pIndex��һ��Ԫ�ز���'*',��ֻ���ǽ�s[sIndex]�� p[pIndex]ƥ��
	   if (pIndex + 1 == p.length || p[pIndex + 1] != '*') {
		   return 	sIndex != s.length && 
				   (s[sIndex] == p[pIndex] || p[pIndex] == '.') && 
				   patternmatch(s, p, sIndex + 1, pIndex + 1);
	   }
	 //��pIndex��һ��Ԫ��Ϊ *������Ҫ���Ƕ��s[sIndex]�� p[pIndex]ƥ��������ö��
       //���� a*bb �� aaaaab���������i������ͣ����b��λ�ô�
       while (sIndex != s.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.')) {
           if (patternmatch(s, p, sIndex, pIndex + 2)) {
               return true;
           }
           sIndex++;
       }
       //patternmatch(s, p, sIndex, pIndex + 2) ��ʾ * ֮ǰ��Ԫ��Ϊ0�������� a*aaa �� aaa ����ƥ��
       return patternmatch(s, p, sIndex, pIndex + 2);
   }
   
   ����ɣ���Ҫ�ٴ����
}
