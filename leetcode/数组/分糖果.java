package ����;

import java.util.HashSet;

/*
����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ���
����Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á�
�������ÿ��Ի�õ�����ǹ�����������

����: candies = [1,1,2,3]
���: 2
����: ���û���ǹ�[2,3],�ܻܵ���ǹ�[1,1]�����������ֲ�ͬ���ǹ����ܵ�ֻ��һ�֡�
����ʹ�����ÿ��Ի�õ��ǹ���������ࡣ
*/
public class ���ǹ� {
    public int distributeCandies(int[] candies) {
    	HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int candy : candies) {
            if (set.size() < candies.length / 2 && set.add(candy)) {
                ans++;
            }
        }
        
        return ans;
    }
}
