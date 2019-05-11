package src;
/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author zoe
 *
 *
 *����������������������ʣ�
 *�������һ�������Ǹ��ڵ㣬����ʣ�ಿ�ֳַ������֣�ǰһ����������������һ��������������
 */


public class �����������ĺ���������� {
	
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) {
        	return false;
        }
        return verifySquenceOfBST(sequence, 0,sequence.length-1); //�ݹ�ʵ��
    }
    
    public boolean verifySquenceOfBST(int[] sequence,int start,int end){
    	if(start>=end) return true;
    	int root=sequence[end];
    	
    	// ������������,���ж����������͸��ڵ�Ĺ�ϵ
    	int i=start;
    	while (sequence[i]<root) { //������
			i++; 
		}
    	int j=i;
    	while (j<end) {//������
			if(sequence[j]<root) { //һ���������г��ֱȸ��ڵ�С����,�����޷����ɶ���������
				return false;
			}
			j++;
		}
    	
    	boolean left=verifySquenceOfBST(sequence, start, i-1);// �ж��������ǲ��Ƕ���������
    	boolean right=verifySquenceOfBST(sequence, i, end-1); //�ж��������ǲ��Ƕ���������
    	return left&&right;
    }
}
