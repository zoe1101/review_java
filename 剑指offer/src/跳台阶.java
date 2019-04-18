package src;
/*
һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
�����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 */

//�����һ��������һ�ף���ôʣ�µ�n-1��̨�ף�������f(n-1)
//�����һ�����������ף���ôʣ�µ�n-2��̨�ף�������f(n-2)
//���������ּ���ɵã�f(n) = f(n-1) + f(n-2)
//��ʵ�������֪��f(1) = 1��f(2) = 2
//�ݹ�����:  쳲���������
/*
f(n)   =     1��                                        n = 1
f(n)   =     2,                n = 2
f(n)   =     f(n-1) + f(n -2), n >2
*/
public class ��̨�� {
	//�ݹ�ķ���, ����ʱ�����
    public static int JumpFloor(int target) {
    	if(target<=0) return 0;
    	else if(target<=2) return target;
    	else return JumpFloor(target-1)+JumpFloor(target-2);

    }
    
	//��̬�滮�ķ���, ���Ч�ʡ�
    public static int JumpFloor2(int target) {
        if(target<=0) return 0;
        else if(target<=2)  return target;
    	int[] result=new int[target];
    	result[0]=1;
    	result[1]=2;
    	for(int i=2;i<target;i++) {
    		result[i]=result[i-1]+result[i-2];
    	}
    	return result[target-1];
    }
    	
	public static void main(String[] args) {
	    int target=3;
	    System.out.println(JumpFloor2(target));

	}
}
