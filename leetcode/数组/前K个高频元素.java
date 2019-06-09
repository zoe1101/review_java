package ����;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�

����: nums = [1,1,1,2,2,3], k = 2
���: [1,2]
 */
public class ǰK����ƵԪ�� {
    public List<Integer> topKFrequent(int[] nums, int k) {
       List<Integer> res=new ArrayList<Integer>();
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int num:nums) {
    	   map.put(num, map.getOrDefault(num, 0) + 1);
       }
       PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {
    	   public int compare(Integer  a,Integer  b) {
			return map.get(a)-map.get(b);
		}
       });
       for (int key:map.keySet()) {
    	   if (queue.size()<k) {
    		   queue.add(key);
    	   }else if (map.get(key)>map.get(queue.peek())) {
    		   queue.remove();
    		   queue.add(key);
    	   }
       }
       while (!queue.isEmpty()) {
    	   res.add(queue.remove());
       }
       return res;
       
    }
}
