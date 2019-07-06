package ����2019;

import java.util.Scanner;

/*
����һ��01�ַ����������=�ô����������1�ĳ��ȣ�������������K�λ��ᣬ
ÿ�λ�����Խ����е�ĳ��0�ĳ�1�����������Ŀ��ܴ�

��������:
�����һ����������N,K����ʾ�ַ������Ⱥͻ������

�ڶ�������N����������ʾ���ַ�����Ԫ��

( 1 <= N <= 300000
, 0 <= K <= N )

�������:
���һ�б�ʾ��

��������1:
10 2 
1 0 0 1 0 1 0 1 0 1

�������1:
5
 */
public class �ȫ1�� {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] arr=new int[n+1];
		int[] sum=new int[n+1];
		for (int i = 1; i <= n; i++) {
			int temp=scanner.nextInt();
			if (temp!=0 && temp!=1) {
				System.out.println("��������");
				break;
			}
			arr[i]=temp;
			sum[i] = sum[i-1] + temp;
		}
		int r=1;
		int l=1;
		int ans=0;
		while (r<=n) { // ˫ָ���ȡ��һ��  ���������ƽ�һ�¾�����
			if ((r-l+1)-(sum[r]-sum[l-1])<=k) { // ������ȥ1�ĸ�������0�ĸ���
				ans = Math.max(ans,r - l + 1);
				r++;
			}else if (l<r) {
				l++;
			}else {
				l++;
				r++;
			}
		}
		System.out.println(ans);
		scanner.close();
	}

}
