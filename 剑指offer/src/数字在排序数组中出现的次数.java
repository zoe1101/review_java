package src;

import java.lang.annotation.Retention;

/**
 * ͳ��һ�����������������г��ֵĴ�����
 * @author zoe
 *���ֲ���
 */
public class ���������������г��ֵĴ��� {
	//��Ҫ�ҵ������еĵ�һ��k�����һ��k���ֵ�λ�á�
    public static int GetNumberOfK(int [] array , int k) {
        if (array==null || array.length==0) {
			return 0;
		}
       int first=GetFirstK(array, k, 0, array.length-1);
       int last=GetLastK(array, k, 0, array.length-1);
       System.out.println(first+" "+last);
       if(first!=-1 && last!=-1) {
    	   return last-first+1;
       }
        return 0;
    }
    //�ҵ������е�һ��k���±ꡣ��������в�����k������-1
    public static int GetFirstK(int[] arr, int k, int start, int end) {
    	while (start<=end) {
    		int mid=(start+end)/2;
        	if(arr[mid]==k) {
        		if((mid>0 && arr[mid-1]!=k) || mid==0) { //��һ��k���ֵ�λ��
        			return mid;
        		}else {
    				end=mid-1;
    			}
        	}else if (arr[mid]>k) {//k��mid���
    			end=mid-1;
    		}else {//k��mid�ұ�
    			start=mid+1;
    		}
		}
    	return -1;
    }
    
  //�ҵ����������һ��k���±ꡣ��������в�����k������-1
    public static int GetLastK(int[] arr, int k, int start, int end) {
    	while (start<=end) {
    		int mid=(start+end)/2;
        	if(arr[mid]==k) {
        		if((mid<arr.length-1 && arr[mid+1]!=k) || mid==arr.length-1) { //���һ��k���ֵ�λ��
        			return mid;
        		}else {
    				start=mid+1;
    			}
        	}else if (arr[mid]>k) {//k��mid���
    			end=mid-1;
    		}else {//k��mid�ұ�
    			start=mid+1;
    		}
		}
    	return -1;
    }
    public static void main(String[] args) {
		int[] arr= {2,3,4,5,6,6,6,6,6,7,7,8,9,9};
		System.out.println(GetNumberOfK(arr, 6));
	}
}
