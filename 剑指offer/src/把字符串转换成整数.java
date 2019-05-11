package src;
/*
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 */
public class ���ַ���ת�������� {

    public int StrToInt(String str) {
        if(str==null || str.length()==0) {
        	return 0;
        }
        int symbol=1;
        int res=0;
        char[] chas=str.toCharArray();
        if(chas[0]=='+') {
        	symbol=1;
        	chas[0]='0';// ����Ϊ0ʵ�����Ƿ������
        }
        if(chas[0]=='-') {
        	symbol=-1;
        	chas[0]='0';
        }
        for(int i=0;i<chas.length;i++) {
        	//�ж������ǲ��ǺϷ���
        	if(chas[i]<'0' || chas[i]>'9') {
        		res=0;
        		break;
        	}
        	res=res*10+chas[i]-'0';// ת������,��ֹ�н�λ
        }
        return res*symbol;  // ���ֻ��������Ҳ���0
    }
}
