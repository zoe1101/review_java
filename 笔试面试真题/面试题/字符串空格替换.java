package ������;

/*
��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����

���ַ���ΪWe Are Happy.
�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class �ַ����ո��滻 {
	
	public static String replaceSpace1(StringBuffer str) {
		String reString=str.toString();
		if(reString.contains(" ")) {
			while (str.indexOf(" ")!=str.lastIndexOf(" ")) {
				int index=str.indexOf(" ");
				str.replace(index, index+1, "%20");
			//StringBuffer��indexOf�����Ҳ���ʱ����ֵΪ-1	
			}
			int index=str.indexOf(" ");
			str.replace(index, index+1, "%20");
			reString=str.toString();
			return reString;
		}else {
			return reString;
		}
	}
	
	public static String replaceSpace2(StringBuffer str) {
		int index=str.indexOf(" ");
		while (index!=-1) {//StringBuffer��indexOf�����Ҳ���ʱ����ֵΪ-1	
			str.replace(index, index+1, "%20");
			index=str.indexOf(" ",index);//������һ���ո�
		}
		
		String reString=str.toString();
		return reString;
	}
	
	
//������replace�ķ���
//	��ǰ�����滻��������ַ�Ҫ���������ƶ���Ҫ����ƶ�������Ч�ʵ���
//  �Ӻ���ǰ���ȼ�����Ҫ���ٿռ䣬Ȼ��Ӻ���ǰ�ƶ�����ÿ���ַ�ֻΪ�ƶ�һ�Σ�����Ч�ʸ���һ�㡣
	public static String replaceSpace3(StringBuffer str) {
		int len=str.length();//�ַ����ĳ���
		int space_count=0;//�ո�ĸ���
		for(int i=0;i<len;i++) {
			if(str.charAt(i)==' ') {//�ո����
				space_count++;
			}
		}
		int new_len=len+2*space_count;//�µ��ַ�������
		int index_old=len-1;
		int index_new=new_len-1;
		str.setLength(new_len);
		while(index_old>=0 && index_new>index_old) {
			if(str.charAt(index_old)!=' ') {
				str.setCharAt(index_new--, str.charAt(index_old));
			}else {//����ǿո� 
				str.setCharAt(index_new--, '0');
				str.setCharAt(index_new--, '2');
				str.setCharAt(index_new--, '%');
			}
			index_old--;
		}
		return str.toString();
		
//		char[] char_str=new char[new_len];
//		while(index_old>=0) {
//			if(str.charAt(index_old)!=' ') {
//				char_str[index_new--]=str.charAt(index_old);
//			}else {//����ǿո� 
//				char_str[index_new--]='0';
//				char_str[index_new--]='2';
//				char_str[index_new--]='%';
//			}
//			index_old--;
//		}
//		return String.valueOf(char_str);//���ַ�����תΪString���ͺ󷵻� 
	}
	public static void main(String[] args) {
		StringBuffer stringBuffer=new StringBuffer("We Are Happy");
		System.out.println(replaceSpace3(stringBuffer));

	}

}
