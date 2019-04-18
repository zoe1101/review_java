package �ַ���;

import java.awt.List;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;

import javax.naming.InitialContext;

/*
���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
���磬���� n = 3�����ɽ��Ϊ��
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
//����˼·: ���ݷ�
//��дn�������ţ�Ȼ���д�����ţ�ÿ�����һ��֮�󣬾Ͱ��ַ�����������
//Ȼ���ٵ��˲��赽д��n-1�������ţ�Ȼ��д�����ţ���д�����ţ���ȫд�����š�
//���λ��ݵݹ飬ÿ���һ�˾ͻص����ٸı��λ�á�
public class �������� {
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<String>();
        String string=new String();
        generate(list,string,n,n);
        return list;
        
    }
    public static void generate(ArrayList<String> list,String str,int left,int right) {
    	//�ж�ʣ�������������Ƿ�Ϊ0
    	if(left==0 && right==0) { //�������Ŷ����ú���
    		list.add(str); //��ʱֻҪ���ϲ�ݹ鴫�������Ѿ�����õ������ַ���str��ӵ�list�С�
    		return;
    	}
    	if(left>0) {//����ʣ�������������
    		generate(list,str+'(',left-1,right); //��ԭ���źõ������ϵ����'('���ٵݹ顣
    	}
    	if(right>left) { //����ʣ�������������,��ʣ��δ��ӵ������Ų�����Ŀ�����ʣ�������ŵĶ࣬��֤���ŵĳɶ���Ч
    		generate(list,str+')',left,right-1); //��ԭ���źõ������ϵ����')'���ٵݹ顣
    	}
		
	}

	public static void main(String[] args) {
		int n=3;
		System.out.println(generateParenthesis(n));

	}

}
