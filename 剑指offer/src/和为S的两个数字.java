package src;

import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в�����������
 * ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * 
 * ��Ӧÿ�����԰����������������С���������
 * @author zoe
 *
 */
public class ��ΪS���������� {
//���ҼбƵķ�����a+b=sum,a��bԽԶ�˻�ԽС
//��Ϊ�����ǵ�������,����һͷһβ����ָ�����ڿ����ķ����ҵ��ľ��ǳ˻���С�����.
//	��ai + aj == sum�����Ǵ𰸣����ԽԶ�˻�ԽС��
//	��ai + aj > sum��˵�� aj ̫���ˣ�j ��
//	��ai + aj < sum��˵�� ai ̫С�ˣ�i ++
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(array==null || array.length<2) {
        	return res;
        }
        int i=0;
        int j=array.length-1;
        while (i<j) {
			if(array[i]+array[j]==sum) {
				res.add(array[i]);
				res.add(array[j]);
				break;
			}else if (array[i]+array[j]>sum) {
				j--;
			}else {
				i++;
			}
		}
        return res;
    }
}
