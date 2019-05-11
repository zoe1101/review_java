package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * ����n���������ҳ�������С��K������
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * @author zoe
 *
 */
public class ��С��K���� {
//	�ȶ���������Ȼ��ȡ��ǰk��
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(input==null || k<=0 || input.length<k) {
        	return res;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++) {
        	res.add(input[i]);
        }
        return res;
    }
    
//    �������ѱ�����k������ÿ��ֻ�ͶѶ��ȣ�����ȶѶ�С��ɾ���Ѷ���������ѡ�
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
    	ArrayList<Integer> res=new ArrayList<Integer>();
        if(input==null || k<=0 || input.length<k) {
        	return res;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(k,new Comparator<Integer>() {
        	public int compare(Integer e1,Integer e2) {
				return e2-e1;
			}
        });
        for (int i = 0; i < input.length; i++) {
			if(maxHeap.size()!=k) {
				maxHeap.offer(input[i]);
			}else {
				if(maxHeap.peek()>input[i]) {
					maxHeap.poll();
					maxHeap.offer(input[i]);
				}
			}
		}
    	for(Integer i:maxHeap) {
    		res.add(i);
    	}
    	return res;
    }
}
