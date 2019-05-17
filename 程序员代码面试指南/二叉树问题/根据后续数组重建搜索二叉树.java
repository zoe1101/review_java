package ����������;
import ����������.�ж�t1���Ƿ����t2��ȫ�������˽ṹ.Node;
public class ���ݺ��������ؽ����������� {
	//�ж������Ƿ��������������ĺ���������
	public static boolean isPostArray(int[] arr) {
		if (arr==null || arr.length==0) {
			return false;
		}
		return isPost(arr, 0, arr.length-1);
	}
	public static boolean isPost(int[] arr,int start,int end) {
		if (start==end) {
			return true;
		}
		int less=-1;//С�����һ��Ԫ�ص�λ��ָ�򣬼�¼�������һ����λ��
		int more=end; //�������һ��Ԫ�ص�λ��ָ�򣬼�¼���ǵ�һ����λ��
		for (int i = start; i < end; i++) {
			if (arr[end]>arr[i]) { //��ǰԪ��С�����һ��Ԫ��
				less=i;
			}else {
				more=more==end?i:more;//ֻ��¼��һ����λ��
			}	
		}
		if (less==-1 || more==end) {
			return isPost(arr, start, end-1);
		}
		if (less!=more-1) {//С�ڵ����һ��λ��Ӧ������ڵĵ�һ��λ������
			return false;
		}
		//С�ڲ�������ڲ��ּ����ж�
		return isPost(arr, start, less)&& isPost(arr, more, end-1);
	}
	
	//���ú��������ؽ�����������
	public static Node postArrayToBST(int[] postArr) {
		if (postArr==null) {
			return null;
		}
		return posToBST(postArr, 0, postArr.length-1);
	}
	public static Node posToBST(int[] posArr,int start,int end) {
		if (start>end) {
			return null;
		}
		Node head=new Node(posArr[end]);
		int less=-1;
		int more=end;
		for (int i = start; i < end; i++) {
			if (posArr[i]<posArr[end]) {
				less=i;
			}else {
				more=more==end?i:more;
			}
		}
		head.left=posToBST(posArr, start, less);
		head.right=posToBST(posArr, more, end-1);
		return head;
	}

}
