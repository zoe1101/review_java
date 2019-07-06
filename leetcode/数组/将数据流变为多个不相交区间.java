package ����;

import java.util.Map;
import java.util.TreeMap;

/*
����һ���Ǹ����������������� a1��a2������an����������ĿǰΪֹ�����������ܽ�Ϊ���ཻ�������б�
���磬�����������е�����Ϊ 1��3��7��2��6������ÿ�ε��ܽ�Ϊ��

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]

 */
public class ����������Ϊ������ཻ���� {
	private TreeMap<Integer, int[]> map;  //˳�򱣴�����
	//Initialize your data structure here. 
    public  ����������Ϊ������ཻ����() {
    	map = new TreeMap<>();
    }
    
    public void addNum(int val) {
    	if (map.containsKey(val)) //�������ظ�ֵ�����ù�
            return;
    	
    	//floorEntry(key):����������С�ڻ���ڸ����ļ�key��������������������ļ���null�����ļ� - ֵӳ�䡣
    	Map.Entry<Integer, int[]> leftValInterval = map.floorEntry(val);
        Map.Entry<Integer, int[]> rightValInterval = map.ceilingEntry(val);
        int[] leftInterval = leftValInterval != null ? leftValInterval.getValue() : null;
        int[] rightInterval = rightValInterval != null ? rightValInterval.getValue() : null;
        //��ֵ�Ѿ�����������
        if (leftInterval != null && leftInterval[0] <= val && leftInterval[1] >= val ||
                rightInterval != null && rightInterval[0] <= val && rightInterval[1] >= val)
            return;
        // merge left & right
        if (leftInterval != null && rightInterval != null && leftInterval[1] == val - 1 && rightInterval[0] == val + 1) {
            // keep left, remove right
            leftInterval[1] = rightInterval[1];
            map.remove(rightValInterval.getKey());
        } else if (leftInterval != null && leftInterval[1] == val - 1)
            leftInterval[1] = val;
        else if (rightInterval != null && rightInterval[0] == val + 1)
            rightInterval[0] = val;
        else
            map.put(val, new int[]{val, val});
    }
    
    public int[][] getIntervals() {
    	return map.values().toArray(new int[map.size()][]);
    }
}
