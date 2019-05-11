package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 *  �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 *   {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� 
 *   {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */


public class �������ڵ����ֵ {
	
//	��˫�˶���ʵ��
/*
 * ���е�һ��λ�ñ��浱ǰ���ڵ����ֵ�������ڻ���һ�Σ� �жϵ�ǰ���ֵ�Ƿ�
 * ���ڣ���ǰ���ֵ��λ���ǲ����ڴ���֮�⣩�������ӵ�ֵ�Ӷ�β��ʼ�Ƚϣ������б���С��ֵ������
 * ʱ�临�Ӷ�ΪO(n)
 */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	if(num==null || num.length==0 || size<=0) {
    		return res;
    	}
    	Deque<Integer> deque=new ArrayDeque<Integer>(); //˫�˶���
    	int left=0;
    	for (int i = 0; i < num.length; i++) {
			left=i-size+1;
			if (deque.isEmpty()) {
				deque.offerLast(i);
			}else if (left>deque.peekFirst()) {
				deque.pollFirst();
			}
			while (!deque.isEmpty() && num[deque.peekLast()]<=num[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
			if (left>=0) {
				res.add(num[deque.peekFirst()]);
			}
		}
    	return res;
    }
    
    public ArrayList<Integer> maxInWindows2(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        if(num==null || num.length == 0 || size <= 0)
            return res;
        
        for(int i = 0; i < num.length; i++){ 
        	//��ͷ�浱ǰ���ڵ����ֵ
            if(!deque.isEmpty() && deque.peekFirst() <= i - size)
                deque.poll();
            while(!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.removeLast();
            deque.offerLast(i);
            if(i + 1 >= size)
                res.add(num[deque.peekFirst()]);
        }
        return res;
    }
}
