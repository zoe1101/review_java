package ������;
/*
һ��ѭ���������飨�磺3,4,5,6,7,8,9,0,1,2������֪������Сֵ��λ�ã�Ҫ������һ��ֵ��λ�á�
�ҵ��Ļ������±꣬û�ҵ�����-1��

Ҫ���㷨ʱ�临�Ӷ�Ϊlog2(n)��
 */
//����˼·: ���ֲ���

public class ѭ�����������еĶ��ֲ��� {
	
//	�ǵݹ鷨
    public static int bisearch1(int[] arr,int target){
    	int left=0;
    	int right=arr.length-1;
    	while (left<=right) {
    		int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
    		if(target==arr[mid]) {
    			return mid;
    		}
            // A[left], A[mid], A[right]  
            // 6 1 5 
    		if (arr[mid]<=arr[left]) {//ת�۵���mid����࣬��mid��right�������������
    			if(target>arr[mid] && target<=arr[right]) {//��mid���ұ�
    				left=mid+1;
    			}else {//��mid�����
    				right=mid-1;
    			}
			// 3 6 2
    		}else {//ת�۵���mid���Ҳ࣬��left��mid�������������
        			if(target>=arr[left] && target<arr[mid]) {//��mid�����
        				right=mid-1;
        			}else {//��mid���ұ�
        				left=mid+1;
        			}
    		}

		}
    	return -1;	
    }
    
//	�ݹ�д��
    public static int bisearch2(int[] arr,int left, int right,int target){
    	while (left<=right) {
    		int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
    		if(target==arr[mid]) {
    			return mid;
    		}
            // A[left], A[mid], A[right]  
            // 6 1 5 
    		if (arr[mid]<=arr[left]) {//ת�۵���mid����࣬��mid��right�������������
    			if(target>arr[mid] && target<=arr[right]) {//��mid���ұ�
    				return bisearch2(arr, mid+1, right, target);
    			}else {//��mid�����
    				return bisearch2(arr, left, mid-1, target);
    			}
			// 3 6 2
    		}else {//ת�۵���mid���Ҳ࣬��left��mid�������������
        			if(target>=arr[left] && target<arr[mid]) {//��mid�����
        				return bisearch2(arr, left, mid-1, target);
        			}else {//��mid���ұ�
        				return bisearch2(arr, mid+1, right, target);
        			}
    		}

		}
    	return -1;	
    }
    
//    true or false
    public static boolean bisearch3(int[] A, int left, int right, int target)  
    {  
        if(left > right)  
            return false;  
        int mid=left+(right-left)/2;  //Ϊ�˷�ֹ��ֵ���
        if(target == A[mid])  
            return true;  
        // A[left], A[mid], A[right]  
        // 1 3 5  
        if(A[mid] > A[left] && A[mid] < A[right]) //��ͨ����  
        {  
            if(target < A[mid])  
                return bisearch3(A, left, mid-1, target);  
            else  
                return bisearch3(A, mid+1, right, target);  
        }  
        // 5 1 3  
        else if(A[mid] < A[left] && A[mid] < A[right]) //ת�������  
        {  
            if(target > A[mid] && target <= A[right])  
                return bisearch3(A, mid+1, right, target);  
            else  
                return bisearch3(A, left, mid-1, target);  
        }  
        // 3 5 1  
        else if(A[mid] > A[left] && A[mid] > A[right]) //ת�����Ҳ�  
        {  
            if(target < A[mid] && target >= A[left])  
                return bisearch3(A, left, mid-1, target);  
            else  
                return bisearch3(A, mid+1, right, target);  
        }  
        // 3 3 3  
        else //ֻ�����������Ҷ���ȵ������û�а취�ж�  
        {  
            return bisearch3(A, left, mid-1, target) || bisearch2(A, mid+1, right, target);  
        }  
    }  


	public static void main(String[] args) {
        int[] arr = new int[]{23,24,26,27,27,4,4,4,8,13,20};
        System.out.println(bisearch1(arr, 4));
        System.out.println(bisearch2(arr, 0,arr.length,4));
	}
}
