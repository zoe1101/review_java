package �ݹ��붯̬�滮;

public class ��Ծ��Ϸ {
	public static int jump(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int jump=0; //Ŀǰ��Ծ�Ĳ���
		int cur=0; //���ֻ����jump�����Ե������Զ����
		int next=0; //�������һ����jump+1�������Ե������Զ����
		for (int i = 0; i < arr.length; i++) { //������λ��i
			if (cur<i) { //����û������i����Ҫ����һ��
				jump++;
				cur=next;
			}
			next=Math.max(next, i+arr[i]);
		}
		return jump;
	}

}
