package ������Ŀ;

//���ֲ���
public class ��������ת�������ҵ�һ���� {
	public static boolean isContains(int[] arr,int num) {
		int low=0;
		int high=arr.length-1;
		while (low<=high) {
			int mid=(low+high)/2;
			if (arr[mid]==num) { //�ҵ���
				return true;
			}
			//��������ȣ�num��������ߣ�Ҳ�������ұߣ����Ҫ��������arr[low:high]���顣
			if (arr[low]==arr[mid] && arr[mid]==arr[high]) {
				while (low!=mid && arr[low]==arr[mid]) { //���arr[low:mid]����
					low++;
				}
				if (low==mid) { //����num��arr[mid:high]֮��
					low=mid+1;
					continue;
				}
			}
			//�����Ҳ������
			
			if (arr[low]!=arr[mid]) {//��߲������м�
				if (arr[mid]>arr[low]) {//�������
					if (num>=arr[low]&&num<arr[mid]) { //�����
						high=mid-1;
					}else { //���ұ�
						low=mid+1;
					}
					
				}else {//�ұ�����
					if (num>arr[mid] &&num<=arr[high]) {
						low=mid+1;
					}else {
						high=mid-1;
					}	
				}
			}else {
					if (arr[mid]<arr[high]) {//�ұ�����
						if (num>arr[mid] &&num<=arr[high]) {
							low=mid+1;
						}else {
							high=mid-1;
						}
					}else {
						if (num>=arr[low] && num<arr[mid]) {
							high=mid-1;
						}else {
							low=mid+1;
						}
					}
			}
		}
		return false;
	}
	public static  void main(String[]args)
    {
        int arr[]={4,5,6,7,1,2,3};
        System.out.println(isContains(arr,5));
    }

}
