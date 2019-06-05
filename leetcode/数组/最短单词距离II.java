package ����;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
��̵��ʾ��� ����չ����ͬ���������Ҫ��ε�������̵��ʾ���ĺ�����
 */
public class ��̵��ʾ���II {
/*
 * ��Ϊ���ε��ã����ǲ���ÿ�ε��õ�ʱ���ٰ����������ʵ��±��ҳ�����
 * ���ǿ�����һ����ϣ���ڴ����ַ�������ʱ���Ͱ�ÿ�����ʵ��±��ҳ�������С�
 * ������������̾���ķ���ʱ������ֻҪ�����������ʵ��±��б�����ˡ�
 * ����ıȽϷ�����������merge two list��ÿ�αȽ�����list��С������ֵ���õ�һ����ֵ��
 * Ȼ��ѽ�С���Ǹ���ȥ������Ϊ���Ǳ�����������ʱ�Ǵ�ǰ����ģ������±��б�Ҳ������ġ�
 */
	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public HashMap<String, List<Integer>> WordDistance(String[] words) {//// ͳ��ÿ�����ʳ��ֵ��±�����ϣ����
    	for (int i = 0; i < words.length; i++) {
    		List<Integer> count=map.get(words[i]);
    		if (count==null) {
				count=new ArrayList<Integer>();
			}
    		count.add(i);
    		map.put(words[i], count);
		}
    	return map;
    }
    public int shortest(String word1, String word2) {
    	List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0, j = 0;
        // ÿ�αȽ������±��б���С���±꣬Ȼ���������С���Ǹ�
        while(i < idx1.size() && j < idx2.size()){
            distance = Math.min(Math.abs(idx1.get(i) - idx2.get(j)), distance);
            if(idx1.get(i) < idx2.get(j)){
                i++;
            } else {
                j++;
            }
        }
        return distance;
    }
}
