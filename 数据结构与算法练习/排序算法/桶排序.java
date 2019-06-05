package �����㷨;

import java.util.ArrayList;
import java.util.Collections;

public class Ͱ���� {
	public static void buckeSort(int[] arr) {
		int max = Integer.MIN_VALUE; //�����е����ֵ
	    int min = Integer.MAX_VALUE;  //�����е���Сֵ
	    for(int i = 0; i < arr.length; i++){
	        max = Math.max(max, arr[i]);
	        min = Math.min(min, arr[i]);
	    }
	    
	    int bucketNum = (max - min) / arr.length + 1;//Ͱ��
	    ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum); //Ͱ����
	    for(int i = 0; i < bucketNum; i++){
	        bucketArr.add(new ArrayList<Integer>());
	    }
	    
	    //��ÿ��Ԫ�ط���Ͱ
	    for(int i = 0; i < arr.length; i++){
	        int num = (arr[i] - min) / (arr.length); //��Ԫ��������һ��Ͱ
	        bucketArr.get(num).add(arr[i]); //ѹ���ӦͰ
	    }
	    
	    //��ÿ��Ͱ��������
	    for(int i = 0; i < bucketArr.size(); i++){
	        Collections.sort(bucketArr.get(i));
	    }
	    
	    System.out.println(bucketArr.toString());
	}
	public static void main(String[] args)
    {
		int[] arr= {1,2,3,6,2,7,4,6};
		buckeSort(arr);
    }
	

}
