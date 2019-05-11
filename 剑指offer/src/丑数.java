package src;
/**
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * ϰ�������ǰ�1�����ǵ�һ��������
 * �󰴴�С�����˳��ĵ�N��������
 * @author zoe
 *
 *��������������һ����������2��3����5�õ���
 */
public class ���� {
	//ʱ�临�Ӷȹ���,������Ҫ��
   public int GetUglyNumber_Solution(int index) {
	   if(index<=0) {
		   return 0;
	   }
	   int n=0;
       int uglyCount=0;
       while (uglyCount<index) {
    	   n++;
    	   if(isUgly(n)) {
    		   uglyCount++;
    	   }
       }
       return n;
    }
   
   
   public int GetUglyNumber_Solution2(int index) {
	   if(index<=0) {
		   return 0;
	   }
	   //����һ������,������������ź���ĳ���,ÿһ����������ǰ��ĳ�������2,3����5�õ��ġ�
	   int[] uglyNumbers = new int[index];
	   uglyNumbers[0] = 1;
       int nextUglyIndex = 1;
       int multiply2 = 0;
       int multiply3 = 0;
       int multiply5 = 0;
       int min = 0;
       /*
	       �ѵõ��ĵ�һ����������2�Ժ�õ��Ĵ���M�Ľ����ΪM2��
	       ͬ�������ǰ����е�ÿһ����������3��5���ܵõ���һ������M�Ľ��M3��M5��
	       ��ôM�������һ������Ӧ����M2,M3��M5���е���Сֵ��Min(M2,M3,M5)��
	       ���罫���������е����ְ���С�������2��ֱ���õ���һ������M����Ϊֹ��
	       ��ôӦ����2*2=4<M��3*2=6>M������M2=6��
	       ͬ��M3=6��M5=10��������һ������Ӧ����6��
       */
       while (nextUglyIndex<index) {
    	   //M2/M3/M5������������С��
    	   min=MininThreeNum(
    			   uglyNumbers[multiply2]*2, 
    			   uglyNumbers[multiply3]*3, 
    			   uglyNumbers[multiply5]*5);
    	   uglyNumbers[nextUglyIndex]=min;
    	   while (uglyNumbers[multiply2] * 2 <= uglyNumbers[nextUglyIndex]){
               multiply2++;
           }
    	   while (uglyNumbers[multiply3] * 3 <= uglyNumbers[nextUglyIndex]){
               multiply3++;
           }

           while (uglyNumbers[multiply5] * 5 <= uglyNumbers[nextUglyIndex]){
               multiply5++;
           }
           nextUglyIndex++;
           }
       int result = uglyNumbers[index - 1];
       return result;
   }
   //�������е���Сֵ
   public int MininThreeNum(int num1, int num2, int num3)
   {
       int min = num1 < num2 ? num1 : num2;
       min = min < num3 ? min : num3;

       return min;
   }
   
   /*
Step1.���һ�����ܹ���2��������ô������������2��
Step2.���һ�����ܹ���3��������ô������������3��
Step3.���һ�����ܹ���5��������ô������������5��
Step4.�������������Ϊ1����ô��������ǳ����������ǡ�
    */
	public boolean isUgly(int n) {
		 while (n%2==0) {
			   n/=2;
		 }
		 while (n%3==0) {
			n/=3;
		 }
		 while (n%5==0) {
			n/=5;
		 }
		 return n==1;
		
	}		
}
