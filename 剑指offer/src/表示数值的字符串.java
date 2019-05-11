package src;
/*
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 *  ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
public class ��ʾ��ֵ���ַ��� {
	
//����ָOFFER��һ��ķ����������ֵ���ʽ�ܽ�Ϊ��(A.B E/e A) ,
//��˳������жϣ�A���������������B������������������
    public boolean isNumeric(char[] str) {
        if (str==null || str.length==0) {
			return false;
		}
        int[] index = new int[1];
        index[0] = 0; // ���ڼ�¼��ǰ�ַ�λ��
       //���ж�A
        boolean isNumeric; //���ڼ�¼�Ƿ���������
        isNumeric=isInteger(str, index);
       // �ж�B
        if (index[0] < str.length && (str[index[0]] == '.')) {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B��A.��A.B��ʽ������
        }
        // �ж�e�����A
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length)
            return true;
        else
            return false;
    }
    
//��Ƿ���
/*����������־���ֱ��¼��+/-������e/E���͡�.���Ƿ���ֹ���
** ���ڡ�+/-���� �����������ǵ�һ�γ��ֵĻ�Ӧ�ó������ַ����ĵ�һ��λ�ã�
	�������һ�γ����ڲ����ַ�����λ����������ǰ��Ҳ���ǡ�e/E�����ǾͲ����Ϲ���
	����ǵڶ��γ��֣���ô����Ӧ�ó����ڡ�e/E���ĺ��棬�����+/-����ǰ�治�ǡ�e/E������Ҳ�����Ϲ���
** ���ڡ�e/E���� ������ĺ��治���κ����֣��Ͳ����Ϲ���������ֶ����e/E��Ҳ�����Ϲ���
** ���ڡ�.���� ���ֶ����.���ǲ����Ϲ���ġ����С�e/E�����ַ������֡�.��Ҳ�ǲ����Ϲ���ġ�
ͬʱ��Ҫ��֤�����ַ���Ϊ 0-9 ֮������֡�
 */
    public boolean isNumeric2(char[] str) {
    	int len = str.length;
    	boolean sign = false; //�����ų��ִ������
    	boolean decimal = false;  //��.�����ִ������
    	boolean hasE = false;  //e/E���ִ������
    	for (int i = 0; i < len; i++) {
			if (str[i]=='+' ||str[i]=='-') {
				if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E') {//��һ�γ���������
					return false;
				}
				if(sign && str[i-1]!='e' && str[i-1]!='E') { //�ڶ��γ���������
					return false;
				}
				sign=true;
			}else if (str[i] == 'e' || str[i] == 'E') {
				if(i==len-1) {
					return false;
				}
				if (hasE) {//ǰ���Ѿ����ֹ�E��
					return false;
				}
				hasE=true;
			}else if (str[i]=='.') {
				if(hasE || decimal) { //e�����˻����Ѿ��й���.����
					return false;
				}
				decimal=true;
			}else if (str[i]<'0' || str[i]>'9') {
				return false;
			}
		}
    	return true;
    }
    
    private boolean isInteger(char[] str, int[] index) { // ��int[]���ܴ�ֵ��int�Ļ���Ҫ����indexΪȫ�ֱ���
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        return isUnsignedInteger(str, index);
    }
 
    private boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index[0]++;
        if (index[0] > start)
            return true;
        else
            return false;
    }
}
