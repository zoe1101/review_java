package src;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������?
 *  Good Luck!
 *  
 *  ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * @author zoe
 *
 */
public class ��ΪS�������������� {
	/*
* �������ڵķ��������������� start �� end �ֱ��ʾ���е���Сֵ�����ֵ��
* ���Ƚ� start ��ʼ��Ϊ1��end ��ʼ��Ϊ2��
* �����start��end�ĺʹ���sum�����Ǿʹ�������ȥ����С��ֵ(������start),
�෴��ֻ��Ҫ����end��

��ֹ����Ϊ��һֱ����start��(1+sum)/2����endС��sumΪֹ
	 */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	if(sum<3) { //û������Ҫ�����
    		return res;
    	}
    	int start=1;
    	int end=2;
    	int mid=(1+sum)/2;
    	while (start<mid) {
    		int curSum = totalSum(start, end); //��start��end���ĺ�
			if(curSum==sum) {
				res.add(getSequence(start, end));
				end++;
			}else if (curSum<sum) {
				end++;
			}else if (curSum>sum) {
				start++;
			}
		}
    	return res;
    }
    
    public int totalSum(int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        return sum;
    }
    
    public ArrayList<Integer> getSequence(int start, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = start; i <= end; i++){
            temp.add(i);
        }
        return temp;
    }
        
    	
}
