package src;
/**
 *ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 *ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 *���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 *Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * @author zoe
 *
 */
public class ��ת����˳���� {
	//�����巴ת,���Կո�Ϊ�з�,��ÿ�����ʽ��з�ת��
    public String ReverseSentence(String str) {
        if(str==null || str.trim().length()==0) {
        	return str;
        }
        char[] chas=str.toCharArray();
        reverse(chas, 0, chas.length-1);
        
        int start = 0;//��¼ÿ�����ʵ���ʼλ��
        for(int i=0;i<chas.length;i++) {
        	if(chas[i]==' ') {
        		reverse(chas, start, i-1);
        		start=i+1;
        	}else if (i==chas.length-1) {
				reverse(chas, start, chas.length-1);
			}
        }
        return new String(chas);
        
    }
    
    private static void reverse(char[] chas,int start,int end) {
		while (start<end) {
			swap(chas, start, end);
			start++;
			end--;
		}
	}
    private static void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
      }
}
