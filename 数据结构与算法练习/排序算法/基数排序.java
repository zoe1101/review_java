package 排序算法;

public class 基数排序 {
	public static void radixSort(int[] array) {
		int max;
		max = array[0]; //数组中的最大值
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int exp=1;// 排序指数。当对数组按个位进行排序时，exp=1；按十位进行排序时，exp=10;
		 // 从个位开始，对数组a按"指数"进行排序
		for (exp = 1; max/exp > 0; exp *= 10) {
			countSort(array, exp);
		}
	}
	
	//对第exp位进行桶排序
	private static void countSort(int[] a, int exp) {
         int[] output = new int[a.length];    // 存储"被排序数据"的临时数组
         int[] buckets = new int[10];

         // 将数据出现的次数存储在buckets[]中
         for (int i = 0; i < a.length; i++)
            buckets[ (a[i]/exp)%10 ]++;
 
         // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
         for (int i = 1; i < 10; i++)
             buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
         for (int i = a.length - 1; i >= 0; i--) {
             output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
            buckets[ (a[i]/exp)%10 ]--;
        }
 
         // 将排序好的数据赋值给a[]
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
