package ������Ŀ;

public class �ۼӳ�������Χ���е������ٻ���Ҫ������ {
	public static int minNeeds(int[] arr,int range) {
		int needs=0; //��Ҫ���ĸ���
		long touch=0; //��ʾ��ǰ�Ѿ������1~touch��Χ�ϵ���
		for (int i = 0; i < arr.length; i++) {
			while (arr[i]>touch+1) { //��Ҫ���[1,arr[i]-1]����
				touch+=touch+1; //touch+1Ϊ��Ҫ��ӵ�������Ӻ����touch
				needs++;
				if (touch>=range) {
					return needs;
				}
			}
			touch+=arr[i];
			if (touch>=range) {
				return needs;
			}
		}
		while (range>=touch) {
			touch+=touch+1; //touch+1Ϊ��Ҫ��ӵ�������Ӻ����touch
			needs++;
		}
		return needs;
	}

}
