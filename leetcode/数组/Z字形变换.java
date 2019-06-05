package ����;
/**
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
L   C   I   R
E T O E S I I G
E   D   H   N
֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
 * @author zoe
 *
 */

/*
 �ҹ��ɣ�
1��ÿһ��Z�ֵ�����ĸ�numRows*2-2 λ��
2����ȥ��β���У�ÿ�� Z����������ĸ�������Ź�ϵΪ��һ��Ϊ i����һ��Ϊ numsRows*2-2-i
 */
//������ʵ��N����
public class Z���α任 {
	public String convert1(String s, int numRows) {
        //�ַ���ת��������
        char[] c = s.toCharArray();
        //�����ַ�������
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        int len = c.length;
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++)
                sb[idx].append(c[i++]);
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--)
                sb[idx].append(c[i++]);
        }
        //ƴ�������ַ���
        for(int idx = 1;idx < numRows;idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
	
	/*�Է���1���Ż�
	 �������򣬶��ַ���������ÿ��һ�β�����Ӧ���ַ��� 
	ͨ������һ�����ַ���������ȵ����� chas ���ڴ洢ת������ַ�˳��
	����һ������ΪnumRows������洢ÿһ����һ�εĲ����±ꡣ
	�����ʼ�±�֮�����β����ַ����ɡ�
	*/
    public String convert2(String s, int numRows) {
        if (numRows==1) {
			return s;
		}
        int[] rowIndex=new int[numRows];//��¼ÿһ�е���ʼ����ֵ
        char[] chas=new char[s.length()];
        int n=0;
        int burketSize=numRows*2-2; //����N������ĸ�Ĳ�ֵ
        int burketNum = chas.length/burketSize;  //�ж��ٸ�������N
        int rem = chas.length % burketSize; //���һ����������N�а������ַ���
        for(int i = 1; i < numRows; i ++){
        	int flag=i==1?1:2;
        	//n:��i-1�е���ĸ����
        	n=flag*burketNum+(rem >= i ? ( 1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
        	rowIndex[i] = rowIndex[i-1] + n; //��i������ĸ������ֵ
        }
        int flag=-1;
        int curRow = 0;
        for(char c : s.toCharArray()){
        	chas[rowIndex[curRow]] = c;
        	rowIndex[curRow] = rowIndex[curRow] + 1;
        	 if (curRow == 0 || curRow == numRows - 1) flag = -flag;
             curRow += flag;
        }
        return new String(chas);
    }
}
