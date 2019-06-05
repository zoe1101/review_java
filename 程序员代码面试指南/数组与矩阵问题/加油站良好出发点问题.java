package �������������;

import java.util.Arrays;

public class ����վ���ó��������� {
	//����ÿ�����Ƿ������Ϊ�����������
	public static boolean[] stations(int[] dis,int[] oil) {
		 //��Ч����
		if (dis==null || oil==null || dis.length<2 || dis.length!=oil.length) {
			return null;
		}
		int init=changeDisArrayGetInit(dis, oil); //�õ���������dis��ͬʱ�õ���Ч������init
		return init==-1?new boolean[dis.length]:enlargeArea(dis,init);
	}
	
	//�޸�dis���飬ͬʱ�õ���Ч������init
	public static int changeDisArrayGetInit(int[] dis,int[] oil) {
		int init=-1;
		for (int i = 0; i < dis.length; i++) {
			dis[i]=oil[i]-dis[i]; //��dis�����Ϊoil�����ԭdis����
			//oil[i]-dis[i]����ʾ��iλ���ߵ���һ��λ�ã�����û�м�����һ��λ�õ�����֮ǰ��ʣ������
			if (dis[i]>=0) {//ֻ���޸ĺ��dis[i]���ڵ���0�ĵ�ſ�����Ϊ������
				init=i;
			}
		}
		return init;
	}
	//��󻯴�init��������ͨ����
	//��ͨ����ʾΪ[start,end)
	public static boolean[] enlargeArea(int[] dis,int init){
		boolean[] res=new boolean[dis.length];
		int start=init;
		int end=nextIndex(init, dis.length);
		int need=0; //��startλ��˳ʱ��������ͨ����Ҫ��
		int rest=0; //��endλ����ʱ��������ͨ������Դ
		do {
			//��ǰ������start�Ѿ�����ͨ�����У�����ȷ�������Ŀ�ʼ��һ���޷�ת��һȦ
			if (start!=init && start==lastIndex(end, dis.length)) {
				break;
			}
			//��ǰ������start������ͨ�����У���������ͨ����
			if (dis[start]<need) { //�ӵ�ǰstart�������޷�����initinal��
				need-=dis[start];
			}else { //�ӵ�ǰstart���������Ե���initinal�㣬������ͨ����Ľ�����
				rest+=dis[start]-need;
				need=0;
				while (rest>=0 && end!=start) {
					rest+=dis[end];
					end=nextIndex(end, dis.length);
				}
				if (rest>=0) {
					res[start]=true;
					connectGood(dis,lastIndex(start, dis.length),init,res);
					break;
				}
			}
			start=lastIndex(start, dis.length);
		} while (start!=init);
		return res;
	}
	public static void connectGood(int[] dis,int start,int init,boolean[] res){
		int need=0;
		while (start!=init) {
			if (dis[start]<need) {
				need-=dis[start];
			}else {
				res[start]=true;
				need=0;
			}
			start=lastIndex(start, dis.length);
		}
	}
	//ǰһ��λ�ã�˳ʱ��
	public static int lastIndex(int index,int size) {
		return index==0?size-1:index-1;
	}
	//��һ��λ�ã���ʱ��
	public static int nextIndex(int index,int size) {
		return index==size-1?0:(index+1);
	}
	
	public static void main(String[] args) {
		int[] dis= {1,9,1,2,6,0,2,0};
		int[] oil= {4,5,3,1,5,1,1,9};
		System.out.println(Arrays.toString(stations(dis, oil)));

	}

}
