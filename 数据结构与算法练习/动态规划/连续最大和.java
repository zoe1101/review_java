package ��̬�滮;

import java.lang.instrument.IllegalClassFormatException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
��Ŀ��һ�������� N ��Ԫ�أ�����������������͡� ���磺[-1,2,1]������������������Ϊ[2,1]�����Ϊ 3 
��������: 
����Ϊ���С� 
��һ��һ������n(1 <= n <= 100000)����ʾһ����n��Ԫ�� 
�ڶ���Ϊn��������ÿ��Ԫ��,ÿ����������32λint��Χ�ڡ��Կո�ָ���

�������: 
���������������к�����ֵ��

��������: 
3 
-1 2 1 
�������: 
3 
*/
public class �������� {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int[] arr = {6,-3,-2,7,-15,1,2,2};
		System.out.println(maxSubSum(arr));
		
	}
	
	public static Map<String, Integer> maxSubSum(int[] arr) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int maxSum=0; //�洢������Ԫ�غ͵����ֵ,����ֵΪ0
		int curSum=0;  //�洢��ǰ����n��ĺ�
		int newbegin=0; //��¼��ʼλ��
		int newend=0;  //��¼����λ��
		int tempbegin=0;//��¼�ݴ濪ʼλ��
		for(int i=0;i<arr.length;i++) {
			curSum+=arr[i];  
			if(curSum<0) {//�����֮��Ϊ0��ֵ����ֱ������
				tempbegin=i+1;
				newend=i+1;
				curSum=0;
			}
			else {  //���֮ǰ����֮��Ϊ�����������
				if(curSum>maxSum) { //ÿ�θı�curSum��ֵ������maxSum���бȽ�
					newbegin=tempbegin;
					newend=i+1;
					maxSum=curSum;
			}
			
			}
		}
		map.put("maxsum", maxSum);
		map.put("start", newbegin);
		map.put("end", newend);
		return map;
//		System.out.println("maxsum="+maxSum+",start:"+newbegin+",end="+newend);
	}

}
