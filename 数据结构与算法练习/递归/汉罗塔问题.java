package �ݹ�;


/*
  * α�㷨(Ҫ�ƶ����ӵ�����ΪA,�����Ľ�������ΪB,�ƶ���Ŀ������ΪC.
  * ���������Ϊ1����ֱ�ӽ����Ӵ�A�����Ƶ�C���ӡ�
  * ����
  *     step1:��A�����ϵ�N-1�����ӽ�����C�����ƶ���B�����ϡ�
  *     step2:��A�����ϵĵ�N������ֱ���ƶ���C�����ϡ�
  *     step3:��B�����ϵ�N-1�����ӽ���A�����ƶ���C�����ϡ�
 */
public class ���������� {
	public static void hannoi(int n,char from,char in,char to) {
		if(n==1) {
			System.out.println("�����Ϊ"+n+"�����Ӵ�"+from+"�ƶ���"+to);
		}else {
			hannoi(n-1,from,to,in);  //�����С��n�������ƶ����м�
			System.out.println("�����Ϊ"+n+"�����Ӵ�"+from+"�ƶ���"+to); //�����Ϊn�������Ӵ�����ƶ����ұ�
			hannoi(n-1, in, from, to); //�����С��n�����Ӵ��м��ƶ����ұ�
		}
		
	}

	public static void main(String[] args) {
		int n=3;
		hannoi(n, 'A', 'B', 'C');

	}

}
