package src;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * @author zoe
 *
 *������Ŀ��Ҫ����������m��n��ƴ������mn��nm�����mn<nm����ô����Ӧ�ô�ӡ��mn����mӦ������n��ǰ�棬���Ǵ�ʱ����mС��n��
 *��֮�����nm<mn�����Ƕ���nС��m�����mn=nm�����Ƕ���m����n��
 *��ע�����ŵ�<��>, =�ǳ����������ֵ��С�������ֵġ����ڡ�����С�ڡ��������ڡ���ʾ�¶���Ĵ�С��ϵ����
����ڴ������⣬�����ǰ�����ת��Ϊ�ַ��������������m������nƴ�������õ�mn��nm��
���ǵ�λ���϶�����ͬ�ģ���˱Ƚ����ǵĴ�Сֻ��Ҫ�����ַ�����С�ıȽϹ���Ϳ����ˡ�

 */
public class �������ų���С���� {
    public static String PrintMinNumber(int [] numbers) {
    	if(numbers==null || numbers.length==0) {
    		return "";
    	}
    	int len = numbers.length;
    	String[] strings=new String[len];
    	StringBuffer stringBuffer=new StringBuffer();
    	for(int i=0;i<len;i++) {
    		strings[i]=String.valueOf(numbers[i]);
    	}
    	//��������Լ�������������,�µ��������,����ȡ���ֵ��~c1.compareTo(c2)
    	Arrays.sort(strings,new Comparator<String>(){ 
    		public int compare(String str1,String str2) {
    			String c1=str1+str2;
    			String c2=str2+str1;
    			return c1.compareTo(c2);
    		}
    	
		});
    	for(int i = 0; i < len; i++){
    		stringBuffer.append(strings[i]);
    	}
    	return stringBuffer.toString();
    }
    public static void main(String[] args) {
		int a[] = {3, 32, 321};
		System.out.println(PrintMinNumber(a));
		
	}
}
