package src;
/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * @author zoe
 *
 */
public class ���θ��� {
	/**
	 * ���η�
	 * �����һ��������䣬��ô������Ĺ�ģ������Ϊ����ʣ���2����number-1���Ĵ���ε���䡣
	 * �����һ��������䣬��ڶ��ŵ�ǰ������С����Ҳֻ�������䣬��ô������Ĺ�ģ������Ϊ����ʣ���2����number-2���Ĵ���ε����.
	 * ��n����2ʱ��rectCover(number)=rectCover(number-1)+rectCover(number-2)
	 * ��ʵ��һ��쳲���������
	 * @param target
	 * @return
	 */
    public int RectCover(int target) {
    	if(target<=0) {
    		return 0;
    	}else if(target==1 || target==2) {
    		return target;
    	}else {
    		return RectCover(target-1)+RectCover(target-2);
		}
    }

}
