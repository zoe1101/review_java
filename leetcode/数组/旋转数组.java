package ����;
/*
����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����

ʾ�� 1:

����: [1,2,3,4,5,6,7] �� k = 3
���: [5,6,7,1,2,3,4]
����:
������ת 1 ��: [7,1,2,3,4,5,6]
������ת 2 ��: [6,7,1,2,3,4,5]
������ת 3 ��: [5,6,7,1,2,3,4]
 */
//�Ѷ�: easy
public class ��ת���� {
	//����k��
    /* ˫��ѭ��
           * ʱ�临�Ӷȣ�O(kn)
           * �ռ临�Ӷȣ�O(1)
    */
    public static void rotate1(int[] nums, int k) {
		
    	int n=nums.length;
    	k=k%n;
    	
		if(k==0)
			return;
        for(int i=0;i<k;i++) {
    		int temp=nums[n-1];
    		for(int j=n-1;j>0;j--) {
        		nums[j]=nums[j-1];
        	}
    		nums[0]=temp;
        }
    }

	//������ʱ�ռ�
    public static void rotate2(int[] nums, int k) {
		
    	int n=nums.length;
    	k=k%n;
    	int[] temp=new int[k]; //��ʱ�ռ�
    	
		if(k==0)
			return;
        for(int i=0;i<k;i++) {
    		temp[i]=nums[n-k+i];
        }
        for(int i=n-1;i>=k;i--) {
        		nums[i]=nums[i-k];
        	}
        for(int i=0;i<k;i++) {
        	nums[i]=temp[i];
        }
    }
  /**
     * ��ת
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
    public static void rotate3(int[] nums, int k) {
		
    	int n=nums.length;
    	k=k%n;
    	
		if(k==0) return;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
       
    }
    
    private static int[] reverse(int[] nums,int start,int end) {
    	while (start<end) {
			int temp=nums[start];
			nums[start++]=nums[end];
			nums[end--]=temp;
		}
    	return nums;
		
	}

	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		int k=3;
		rotate2(nums, k);
		

	}

}
