package �ݹ��붯̬�滮;

import java.util.Arrays;
import java.util.Comparator;

/**����˹�����ŷ�
����һЩ����˿�Ⱥ͸߶ȵ��ŷ⣬��Ⱥ͸߶�����������ʽ (w, h) ���֡�
����һ���ŷ�Ŀ�Ⱥ͸߶ȶ�������ŷ���ʱ������ŷ�Ϳ��ԷŽ���һ���ŷ����ͬ����˹����һ����

�����������ж��ٸ��ŷ������һ�顰����˹���ޡ��ŷ⣨�����԰�һ���ŷ�ŵ���һ���ŷ����棩��
��������ת�ŷ⡣
 * @author zoe
 *
 */
public class �ŷ�Ƕ������ {
	public static class Envelope {
		public int len; //�ŷⳤ
		public int wid; //�ŷ��
		public Envelope(int length,int widtth) {
			this.len=length;
			this.wid=widtth;
		}
	}
	
	//�Զ���Ƚ���
	//һ����ͨ���ؼ���implements�����Լ�ʹ��һ�����߶���ӿڡ�
	//Comparator���Ƚ���,  �Բ�ͬ���͵Ķ����������(��Ȼ�������ݻ��ǻ�������)
	public static class EnvelopeComparator implements Comparator<Envelope>{
		//��дcompare����
		//���Ȳ���ʱ���س��ȵĲ�ֵ,���򷵻ؿ�Ĳ�ֵ
		public int compare(Envelope o1,Envelope o2) {
			return o1.len!=o2.len?o1.len-o2.len:o2.wid-o1.wid;
		}
	}
/**
 * �ȸ��ŷ����򣬰��ŷ�ĳ��ȴ�С�����ţ��������ʱ����ȴӴ�С����
 * ����ͼ��˳����ҿ�������е�����������С�
 * @param matrix
 * @return
 */
	public static Envelope[] getSortedEnvelopes(int[][] matrix) {
		Envelope[] res=new Envelope[matrix.length];
		for(int i=0;i<matrix.length;i++) {
			res[i]=new Envelope(matrix[i][0], matrix[i][1]);
		}
		Arrays.sort(res,new EnvelopeComparator()); //ʵ�ּ�������,��ͨ����װ��������,�������������ǲ��е�
		return res;
	}
	
	public static int maxEnvelope(int[][] matrix) {
		Envelope[] envelopes=getSortedEnvelopes(matrix); //�õ�������ŷ�
		//���ö��ַ��������������
		int[] ends=new int[matrix.length];
		ends[0]=envelopes[0].wid;
		int right=0;
		int l=0;
		int r=0;
		int m=0;
		for(int i=1;i<envelopes.length;i++) {
			l=0;
			r=right;
			while (l<=r) {
				m=(l+r)/2;
				if(envelopes[i].wid>ends[m]) {
					l=m+1;
				}else {
					r=m-1;
				}
			}
			right=Math.max(right, l);
			ends[l]=envelopes[i].wid;
		}
		return right+1;
	}
	public static void main(String[] args) {
		int[][] matrix= {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelope(matrix));

	}

}
