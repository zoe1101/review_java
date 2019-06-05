package ������Ŀ;

public class �ж�һ�����Ƿ��ھ����ڲ� {
	/*
	 һ�����ο�����4��������ʾ��
	 (x1,y1)Ϊ����ĵ㣬��x1��x����С
	 (x2,y2)Ϊ���ϵĵ㣬��y2��y�����
	 (x3,y3)Ϊ���µĵ㣬��y3��y����С
	 (x4,y4)Ϊ���ҵĵ㣬��x4��x�����
	 */
	public static boolean isInside(double x1,double y1,double x2,double y2,double x3,double y3,
									double x4,double y4,double x,double y) {
		//���α�ƽ����x���y��
		if (y1==y2) {
			return isInside(x1, y1, x2, x4, y4, x, y);
		}
		//����任���Ѿ���ת��ƽ�У����е���Ŷ�
		double l=Math.abs(y4-y3);
		double k=Math.abs(x4-x3);
		double s=Math.sqrt(k*k+l*l);
		double sin=l/s;
		double cos=k/s;
		double x1R=cos*x1+sin*y1;
		double y1R=-sin*x1+cos*y1;
		double x4R=cos*x4+sin*y4;
		double y4R=-sin*x4+cos*y4;
		double xR=cos*x+sin*y;
		double yR=-sin*x+cos*y;
		 //��ת��ɣ����ƽ�е����
		return isInside(x1R, y1R, x2, x4R, y4R, xR, yR);
	}
	//������ƽ���������ᣨx��y����
	 //Ĭ��:1��������,4��������
	public static boolean isInside(double x1,double y1,double x2,double x4,double y4,double x,double y) {
		if (x<=x1) { //�ھ����²�
			return false;
		}
		if (x>=x4) { //�ھ����ϲ�
			return false;
		}
		if (y>=y1) { //�ھ����ϲ�
			return false;
		}
		if (y<=y4) { //�ھ����²�
			return false;
		}
		return true;
	}

}
