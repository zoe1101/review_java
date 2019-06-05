package ������Ŀ;
//���ֲ���
public class ��������ת�������ҵ���Сֵ {
	public static int getMin(int[] arr) {
		int low=0;
		int high=arr.length-1;
		while (low<high) {
			if (low==high-1) {
				break;
			}
			if (arr[low]<arr[high]) { //����arr[low:high]��Χ������ģ���Сֵ����arr[low]
				return arr[low];
			}
			int mid=(high+low)/2;
			if (arr[low]>arr[mid]) { //��Сֵ��arr[low:mid]��Χ��
				high=mid;
				continue;
			}
			if (arr[mid]>arr[high]) { //��Сֵ��arr[mid:high]��Χ��
				low=mid;
				continue;
			}
			//��arr[low]=arr[mid]=arr[high]ʱ
			while (low<mid) {
				if (arr[low]==arr[mid]) {
					low++;
				}else if (arr[low]<arr[mid]) {
					return arr[low];
				}else {
					high=mid;
					break;
				}
			}
		}
		return Math.min(arr[low], arr[high]);
	}

}
