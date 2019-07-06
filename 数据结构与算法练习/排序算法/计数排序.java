package �����㷨;

public class �������� {
	
	public static void countSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		int max=arr[0];
		int min=arr[0];
		//�ҵ������е����ֵ����Сֵ
		for (int i = 1; i < arr.length; i++) { 
			if (arr[i]<min) {
				min=arr[i];
			}
			if (arr[i]>max) {
				max=arr[i];
			}
		}
		
		int[] help=new int[max-min+1]; //��¼ A ��ĳԪ�س��ֵĴ���
		for (int i = 0; i < arr.length; i++) {
			help[arr[i]-min]++;
		}
		int index=0;
		for (int i = 0; i < max-min+1; i++) {
			while (help[i]>0) {
				arr[index]=min+i;
				index++;
				help[i]--;
			}
		}
	}
	
	
	
	/**
	 * ����Ԫ�ض���0-k����
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] countSort(int[] arr,int k) {
		int[] C=new int[k+1];//����C���飬ͳ��[0,k]��ÿ��Ԫ�س��ֵĴ���
		int length=arr.length; //��ȡA�����С���ڹ���B����  
		int sum=0;
        int[] B=new int[length];//����B����,�洢����������
        
        for(int i=0;i<length;i++)
        {
            C[arr[i]]+=1;// ͳ��A�и�Ԫ�ظ���������C����
        }
        
        for(int i=0;i<k+1;i++)//�޸�C����
        {
            sum+=C[i];
            C[i]=sum;   //C[i]:��¼[0,i]��Χ��Ԫ�صĸ���
        }
        
        for(int i=length-1;i>=0;i--)//����A���飬����B����
        {
            B[C[arr[i]]-1]=arr[i];//��A�и�Ԫ�طŵ����������B��ָ����λ��
            C[arr[i]]--;//��C�и�Ԫ��-1����������һ��ͬ����С��Ԫ��
            
        }
        return B;//������õ����鷵�أ��������
        
    }
    public static void main(String[] args)
    {
        int[] A=new int[]{2,5,3,7,2,3,0,3};
        countSort(A);
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }

}
