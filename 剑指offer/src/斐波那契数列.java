package src;
/*
��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 */
public class 쳲��������� {
    public static int Fibonacci(int n) {
    	if(n<2) {
    		return n;
    	}
        int[] array=new int [n+1];
        array[0]=0;
        array[1]=1;
        for(int i=2;i<=n;i++){
            array[i]=array[i-1]+array[i-2];
         }
        return array[n];
    }
	public static void main(String[] args) {
	    int n=3;
	    System.out.println(Fibonacci(n));
	}
}
