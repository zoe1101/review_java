package ������Ŀ;

import java.util.HashSet;

//С����ƴ�ɴ����
public class �ܷ�������ƴ�ɾ��� {
	//��λ��
	public static boolean isRectCover(int[][] matrix) {
		if (matrix==null || matrix.length==0 || matrix[0].length==0) {
			return false;
		}
		int mostLeft=Integer.MAX_VALUE; //��¼����ߵĵ��xֵ
		int mostRight=Integer.MIN_VALUE;//��¼���ұߵĵ��xֵ
		int mostUp=Integer.MIN_VALUE; //��¼���ϱߵĵ��yֵ
		int mostDown=Integer.MAX_VALUE; //��¼���±ߵĵ��yֵ
		HashSet<String> set =new HashSet<String>(); //��¼ÿ����ĳ��ִ���
		int area=0;
		for (int[] rect:matrix) { //һ��С���������½ǵ�����Ͻǵ���ɣ����ĸ�ֵ
			mostLeft=Math.min(mostLeft, rect[0]);
			mostDown=Math.min(mostDown, rect[1]);
			mostRight=Math.max(mostRight, rect[2]);
			mostUp=Math.max(mostUp, rect[3]);
			area+=(rect[2]-rect[0])*(rect[3]-rect[1]); //���˿�
			String leftDown=rect[0]+","+rect[1];
			String leftUp=rect[0]+","+rect[3];
			String rightDown=rect[2]+","+rect[1];
			String rightUp=rect[2]+","+rect[3];
			if (!set.add(leftDown)) { //���leftDown������Ѿ������ˣ��᷵��false
				set.remove(leftDown); //����ͨ���Ƴ���������ж��Ƿ����ż����
			}
			if (!set.add(leftUp)) {
				set.remove(leftUp);
			}
			if (!set.add(rightDown)) {
				set.remove(rightDown);
			}
			if (!set.add(rightUp)) {
				set.remove(rightUp);
			}
		}
		//�ж������ң��ϣ��µĵ��Ƿ�ֻ����һ�Σ��ұ�֤���������ż����
		if (   !set.contains(mostLeft+","+mostDown)
			|| !set.contains(mostLeft+","+mostUp)
			|| !set.contains(mostRight+","+mostDown)
			|| !set.contains(mostRight+","+mostUp)
			|| set.size()!=4) {
			return false;
		}
		return area==(mostRight-mostLeft)*(mostUp-mostDown)?true:false;
	}
	

}
