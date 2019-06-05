package �����㷨;

public class �������� {
	public static void radixSort(int[] array) {
		int max;
		max = array[0]; //�����е����ֵ
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int exp=1;// ����ָ�����������鰴��λ��������ʱ��exp=1����ʮλ��������ʱ��exp=10;
		 // �Ӹ�λ��ʼ��������a��"ָ��"��������
		for (exp = 1; max/exp > 0; exp *= 10) {
			countSort(array, exp);
		}
	}
	
	//�Ե�expλ����Ͱ����
	private static void countSort(int[] a, int exp) {
         int[] output = new int[a.length];    // �洢"����������"����ʱ����
         int[] buckets = new int[10];

         // �����ݳ��ֵĴ����洢��buckets[]��
         for (int i = 0; i < a.length; i++)
            buckets[ (a[i]/exp)%10 ]++;
 
         // ����buckets[i]��Ŀ�����ø��ĺ��buckets[i]��ֵ���Ǹ�������output[]�е�λ�á�
         for (int i = 1; i < 10; i++)
             buckets[i] += buckets[i - 1];

        // �����ݴ洢����ʱ����output[]��
         for (int i = a.length - 1; i >= 0; i--) {
             output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
            buckets[ (a[i]/exp)%10 ]--;
        }
 
         // ������õ����ݸ�ֵ��a[]
         for (int i = 0; i < a.length; i++)
            a[i] = output[i];

         output = null;
         buckets = null;
     }
	
	public static void main(String[] args)
	{
	    int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
	    radixSort(A);
	    for(int num:A)
	    {
	        System.out.println(num);
	    }
	}

}
