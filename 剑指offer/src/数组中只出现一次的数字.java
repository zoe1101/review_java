package src;
/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ�
 * ��д�����ҳ�������ֻ����һ�ε����֡�
 * @author zoe
 *
 */
public class ������ֻ����һ�ε����� {
	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
	//���ҵ���һ��ֻ����һ�ε����֣�Ȼ��������з�������
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length==0) {
        	return;
        }
        if(array.length<2) {
        	num1[0]=0;
        	num2[0]=0;
        	return;
        }
        int temp=array[0];
        for (int i = 1; i < array.length; i++) {
			temp=temp^array[i];
		}
        int firstBit =0;
        while ((temp&1)==0 && firstBit<32) {//�ҵ���һ��ֻ����һ�ε��������ڵ�λ��
			firstBit++;
			temp=temp>>1;
		}
    	num1[0]=0;
    	num2[0]=0;
    	for (int i = 0; i < array.length; i++) {
			if(isBit(array[i], firstBit)) {
				num1[0]=num1[0]^array[i];
			}else {
				num2[0]=num2[0]^array[i];
			}
			
		}
    }
    public boolean isBit(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}
}
