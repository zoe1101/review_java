package ����;
/*
��������Ϊ n ���������� nums������ n > 1������������� output ��
���� output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���

ʾ��:
����: [1,2,3,4]
���: [24,12,8,6]
˵��: �벻Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
 */
/*
˼·��ÿһ���������������������ĳ˻�������������ĳ˻� ���� �ұ����ĳ˻���
������[1,2,3,4] , ������˻�n1=[1,1,2,6] ,�ұ����˻�n2=[1,4,12,24] ,���ؽ������[1*24 , 1*12 , 2*4 , 6*1]��
 */
public class ��������������ĳ˻� {
	public static int[] productExceptSelf(int[] nums) {
		int n=nums.length;
		int right=1;
		int[] product=new int[n];
		product[0]=1;
		for(int i=1;i<n;i++) { //ǰ�����
			product[i]=nums[i-1]*product[i-1];
		}
		for(int i=n-1;i>=0;i--) {//�������
			product[i]*=right;
			right*=nums[i];
		}
		return product;
    }
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		int[] prod=productExceptSelf(nums);
		for(int e:prod) {
		System.out.print(e+" ");
		}
	}

}
