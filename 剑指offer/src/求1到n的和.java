package src;
/*
��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 */

//
//�ݹ�
//�����߼���Ķ�·����ʵ�ֵݹ���ֹ
//��n==0ʱ��(n>0)&&((sum+=Sum_Solution(n-1))>0)ִֻ��ǰ����жϣ�Ϊfalse��Ȼ��ֱ�ӷ���0
//��n>0ʱ��ִ��sum+=Sum_Solution(n-1)��ʵ�ֵݹ����Sum_Solution(n)

// f(n)=n+f(n-1)
public class ��1��n�ĺ� {
    public int Sum_Solution(int n) {
        int sum=n;
        boolean flag= (n>0) && (sum+=Sum_Solution(n-1))!=0;
        return sum;
    }
}
