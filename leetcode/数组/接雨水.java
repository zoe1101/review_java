package ����;
/*
 ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 ����: [0,1,0,2,1,0,1,3,2,1,2,1]
���: 6
 */
public class ����ˮ {
    public int trap(int[] height) {
        if (height==null || height.length<3) {
			return 0;
		}
        int res=0;
        int leftMax=height[0];
        int rightMax=height[height.length-1];
        int L=1;
        int R=height.length-2;
        while (L<=R) {
			if (leftMax<=rightMax) {
				res+=Math.max(0, leftMax-height[L]);
				leftMax=Math.max(leftMax, height[L++]);
			}else {
				res+=Math.max(0, rightMax-height[R]);
				rightMax=Math.max(rightMax, height[R--]);
			}
		}
        return res;
    }
}
