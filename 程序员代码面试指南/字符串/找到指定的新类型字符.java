package �ַ���;

public class �ҵ�ָ�����������ַ� {
	public static String pointNewChar(String str,int k) {
		if (str==null || str.length()==0 || k<0 || k>str.length()) {
			return "";
		}
		char[] chas=str.toCharArray();
		int upperNum=0; //��k-1λ�õ�����Сд��ĸǰ�Ĵ�д��ĸ�ĸ���
		for (int i = k-1; i>=0; i--) {
			if (!(chas[i]>='A' && chas[i]<='Z')) { //���Ǵ�д��ĸ
				break;
			}
			upperNum++;
		}
		//upperNumΪ����,��str[k-1..k]Ϊָ�����������ַ���
		if ((upperNum&1)==1) { 
			return str.substring(k-1,k+1);
		}
		//upperNumΪż����str[k]Ϊ��д��ĸ����str[k..k+1]Ϊָ�����������ַ���
		if (chas[k]>='A' && chas[k]<='Z') { 
			return str.substring(k,k+2);
		}
		//upperNumΪż����str[k]ΪСд��ĸ����str[k]Ϊָ�����������ַ���
		return str.substring(k,k+1);
	}

}
