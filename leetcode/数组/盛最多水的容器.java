package ����;
/**
���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
�������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
�ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��

˵�����㲻����б�������� n ��ֵ����Ϊ 2��
 * @author zoe
 *
 */
public class ʢ���ˮ������ {
    public int maxArea(int[] height) {
        int res=0;
        int left=0;
        int right=height.length-1;
        while (left<=right) {
			res=Math.max(res, (right-left)*Math.min(height[left], height[right]));
			if (height[left]<height[right]) {
				left++;
			}else {
				right--;
			}
		}
        return res;
    }
}
