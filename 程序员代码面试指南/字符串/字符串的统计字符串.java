package �ַ���;

public class �ַ�����ͳ���ַ��� {
	/**
	 * ��Դ�ַ���ת��Ϊͳ���ַ���
	 * @param string
	 * @return
	 */
	public static String getCountString(String string) {
		if(string==null ||string.length()==0) {
			return "";
		}
		char[] chars=string.toCharArray();
		String res=String.valueOf(chars[0]);
		int num=1;
		for(int i=1;i<chars.length;i++) {
			if(chars[i]!=chars[i-1]) {
				res=res+"_"+num+"_"+chars[i];
				num=1;
			}else {
				num++;
			}
		}
		return res+"_"+num;
	}
	/**
	 * ��ͳ���ַ����е�֪Դ�ַ����е�index�ַ���ʲô
	 * @param string
	 * @param index
	 * @return
	 */
	public static char getCharAt(String string, int index) {
		if(string==null ||string.length()==0) {
			return 0;
		}
		char[] chars=string.toCharArray();
		boolean stage=true; //true��ʾĿǰ���������ַ��Ľ׶Σ�false��ʾĿǰ�������������ַ�ͳ�ƵĽ׶�
		char cur=0;//����һ�������ַ��׶�ʱ����������cur�ַ� �� 0��ʾ���ַ�
		int num=0;//����һ�����������ַ�ͳ�ƵĽ׶�ʱ���ַ����ֵ�����
		int sum=0;//Ŀǰͳ���ַ�����λ���൱��Դ�ַ�����ʲôλ��
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='_') { //ת�׶���
				stage=!stage;
			}else if(stage) {
				sum+=num;
				if(sum>index) {
					return cur;
				}
				num=0;
				cur=chars[i];
			}else {
				num=num*10+chars[i]-'0';
			}
		}
		return sum+num>index?cur:0;
	}
	public static void main(String[] args) {
		String string="aaabbadddffc";
		System.out.println(getCountString(string));
		
	}


}
