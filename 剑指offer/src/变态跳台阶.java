package src;
/*
һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
�����������һ��n����̨���ܹ��ж�����������
 */

//�ݹ�����
//  f(n) = 1 ,      (n<=1 ) 
//  f(n) = 2*f(n-1), (n>=2)
public class ��̬��̨�� {
	
    public static int JumpFloorII(int target) {
    	if(target<=0) {return 0;}
    	else if(target==1) {return 1;}
    	else {return 2*JumpFloorII(--target);}
    }
    
    public static int JumpFloorII1(int target) {
    	if(target<=0) {return 0;}
    	else if(target==1) {return 1;}
    	int sum=1;
    	for(int i=1;i<target;i++) {
    		sum=2*sum;
    	}
    	return sum;
    }
    
    
   

	public static void main(String[] args) {
	    int target=3;
	    System.out.println(JumpFloorII(target));
	    System.out.println(JumpFloorII1(target));

	}

}
