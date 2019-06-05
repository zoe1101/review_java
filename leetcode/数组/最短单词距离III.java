package ����;
/*
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = ��makes��, word2 = ��coding��, return 1. 
Given word1 = "makes", word2 = "makes", return 3.
Note: You may assume word1 and word2 are both in the list.

�����I��һ���ģ�Ψһ��ͬ���Ƕ���word1��word2��ͬ��ʱ������Ҫ���ֵ�һ�������͵ڶ�����������ʡ�
���������һ��turns���������ͬ���ʵĻ���ÿ������һ������turn��1���������Ը���turn���ж��Ƿ�Ҫswitch��
 */
public class ��̵��ʾ���III {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int idx1=-1;
		int idx2=-1;
		int distance=Integer.MAX_VALUE;
		int turns=0;
		int inc= (word1.equals(word2) ? 1 : 0); //word1��word2�Ƿ���ͬ
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) && turns%2==0) { //word1������
				idx1=i;
				if (idx2!=-1) { //ǰ���Ѿ���word2
					distance=Math.min(distance,idx1-idx2);
				}
				turns+=inc;
			}else if(words[i].equals(word2)){//word2������
				idx2=i;
				if (idx1!=-1) { //ǰ���Ѿ���word1
					distance=Math.min(distance,idx2-idx1);
				}
				turns+=inc;
			}
		}
		return distance;
		
	}

}
