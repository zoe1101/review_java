package �ַ���;

import java.util.Stack;

////����˼·�����Ǳ����ַ����飬���������ţ���������������������ջ������*�ţ���������starջ��
//�����������ŵ�ʱ����������ȴ������ų�ջ�����������ջ���ˣ��ٴ�starջ��ջ.���򷵻�false��
//����ж��Ǻ��ܷ���������š�
public class ��Ч�������ַ��� {
	public static boolean checkValidString(String s) {
		if(s.isEmpty()) return true;
		int count_left=0,count_star=0,count_right=0;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='(') {
				count_left++;
			}else if(c=='*') {
				count_star++;
			}else {
				if(count_left>0) {//����������ƥ��������
					count_left--;
				}else if(count_star>0) {//����������ƥ���Ǻ�
					count_star--;
				}else {//��������ź��Ǻ�Ҳ������,ֱ�ӷ���false���������ж��
					return false;
				}
			}
		}
		count_left=0;
		count_star=0;
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			if (c==')') {//������
				count_right++;
			}else if(c=='*') { //�Ǻ�
				count_star++; 
			}else { //������
				if(count_right>0) {//������ƥ��������
					count_right--;
				}else if(count_star>0) { //������ƥ���Ǻ�
					count_star--;
				}else { //��������ź��Ǻ�Ҳ������,ֱ�ӷ���false�������Ż��ж��
					return false;
				}
			}
			
		}
		return true;
	}
	public static boolean checkValidString1(String s) {
		 if(s==null||s.length()==0)
	            return true;
	   Stack<Character> leftParenthesis=new Stack<Character>(); //�������������
	   Stack<Character> starParenthesis=new Stack<Character>(); //��������Ǻ�
	   for(int i=0;i<s.length();i++) {
		   char c=s.charAt(i);
		   if(c=='(') {//������
			   leftParenthesis.push(c);
		   }else if(c=='*'){//�Ǻ�
			   starParenthesis.push(c);
		   }else { //������
			   if(!leftParenthesis.isEmpty()) { //������ջ�д��
				   leftParenthesis.pop();
			   }else { //�����ſ��ˣ���ʼ��starջ��
				   if(!starParenthesis.isEmpty()) {//*��ջ�����ջ�ˣ��������������� 
//					   starParenthesis.pop();
				   }else {//���*ջҲ����,ֱ�ӷ���false
					   return false;
				   }
			   }
		   }
	   }
	   //�������ַ��������Ҫ�ж�������ջ����*ջ�ˡ����*���������,��������*�ŵ��ұ�
	   while (!leftParenthesis.isEmpty() && !starParenthesis.isEmpty()) {//�ж��Ǻ��ܷ���������š�
		   if(leftParenthesis.peek()>starParenthesis.peek()) { //peek()��������ջ����Ԫ�أ�����������ջ��Ԫ�ء�
			   return false;
		   }
		   leftParenthesis.pop();
		   starParenthesis.pop();
	   }
	   //���ֻ��Ҫ�ж��������Ƿ���ʣ�ࡣ�Ͼ�������ʣ�µĶ���***,�Ƕ�����Ч���ſ��ַ�
	   return leftParenthesis.isEmpty();
	}

	public static void main(String[] args) {
		String string="(*()";
		System.out.println(checkValidString(string));
	}

}
