package ���ֲ���;

/*
����������һ����������Ϸ�� ��Ϸ�������£�
�Ҵ� 1 �� n ѡ��һ�����֡� ����Ҫ����ѡ�����ĸ����֡�
ÿ����´��ˣ��һ��������������Ǵ��˻���С�ˡ�
�����һ��Ԥ�ȶ���õĽӿ� guess(int num)�����᷵�� 3 �����ܵĽ����-1��1 �� 0����
-1 : �ҵ����ֱȽ�С (ָ���ǲµ����ֱ�ʵ�ʵĴ�)
 1 : �ҵ����ֱȽϴ� (ָ���ǲµ����ֱ�ʵ�ʵ�С)
 0 : ��ϲ����¶��ˣ�

����: n = 10, pick = 6
���: 6
 */
public class �����ִ�С {
    public int guessNumber(int n) {
        int left=1,right=n;
        while(left<=right){
            int mid=left+(right-left)/2;
            int t=guess(mid); //Ԥ�ȶ���õĽӿ� guess(int num)
            if(t==0){
                return mid;
            }else if(t==1){//���Ҳ�,��С��
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

}
