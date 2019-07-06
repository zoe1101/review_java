package ����2019;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
����N���㡢N-1���ߵ�������ͨͼ���ڵ��1��N��ţ�ÿ���ߵĳ��Ⱦ�Ϊ1��
�������1�ڵ����������������нڵ㣬��ô��·�������Ƕ��٣� 
���룺 
��һ�а���һ������N��1��N��105105 
������N-1�У�ÿ�а�����������X��Y����ʾX�Žڵ��Y�Žڵ�֮����һ���ߣ�1��X,Y��N 
����� 
�����·�̵���Сֵ 
�������룺 
4 
1 2 
1 3 
3 4 
��������� 
4 
��ʾ�� 
��1->2->1->3->4��·�߱������нڵ㣬��·��Ϊ4

 */
//������ȱ���
//����N���ڵ㣬N-1�ߣ����һ�����ͨͼ�����Կ���ȷ�����ͼ��ʵ������һ����������
//ͬʱ����Ϊ���������Կ϶�û�л��� 
//��n�����������ȱ���ʱ����ȥ�������·�������ı�ֻ��һ��֮�⣬����ÿ���߾������Ρ�
//����ֻ��Ҫ�ҳ���������·���Ϳɣ��������·������ΪL����·��Ϊ2*��n-1��-L��
public class ͼ�ı��� {
	private static int maxpath=0;
	private static int temp=0;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		List<Integer>[] list=new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i]=new ArrayList<Integer>();
		}
		for (int i = 1; i < n; i++) {
			 int key = scanner.nextInt();
             int value = scanner.nextInt();
             list[key].add(value);
		}
		dfs(1,list); //�õ��·��
		System.out.println(2*(n-1)-maxpath);
		scanner.close();
	}

	public static void dfs(int n,List <Integer> [] list) {
    	if(list[n].size()==0) {
    		if(temp>maxpath)
    			maxpath=temp;
    		return;
    	}else {
    		for (int i = 0; i < list[n].size(); i++) {
				temp++;
				dfs(list[n].get(i),list);
				temp--;
			}
    	}
    }

}
