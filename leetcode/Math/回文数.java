package Math;

//�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
public class ������ {
	public static boolean isPalindrome(int x) { 
		if(x<0||( x%10==0&& x!=0)) {//����Ǹ��������������λΪ0���򷵻�false��0���⣩
			return false;
		}
		int rev=0;//��¼��ת��һ��
		while (x>rev) {
			rev=rev*10+x%10;
			x=x/10;
		}
	     return (rev==x||x==rev/10);  //rev==x:żλ����x==rev/10����λ��
    }
	public static void main(String[] args) {
		int x=12321;
		System.out.println(isPalindrome(x));

	}

}
