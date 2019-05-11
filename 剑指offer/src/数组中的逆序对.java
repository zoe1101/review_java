package src;

import java.time.chrono.MinguoChronology;

/**
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007
 * 
 * ��Ŀ��֤�����������û�е���ͬ������
����:
1,2,3,4,5,6,7,0
���:
7
 * @author zoe
 *
 *���ù鲢�����˼·
 */
public class �����е������ {
	int count=0;
    public int InversePairs(int [] array) {
    	if (array==null || array.length<=1) {
			return 0;
		}
    	mergeUp2Down(array, 0, array.length-1);
    	return count;
    }
    public void mergeUp2Down(int [] a,int start,int end){
    	if(start>=end) {
    		return;
    	}
    	int mid=(start+end)>>1;
    	mergeUp2Down(a, start, mid);
    	mergeUp2Down(a, mid+1, end);
    	merge(a, start, mid, end);
    }
    public void merge(int [] a,int start,int mid,int end){
    	int[] temp=new int[end-start+1];
    	int i=start;//i��ʼ��Ϊǰ��ε�һ�����ֵ��±�
    	int j=mid+1;//j��ʼ��Ϊ���ε�һ�����ֵ��±�
    	int index=0; 
    	while (i<=mid && j<=end) {
			if(a[i]>a[j]) { //�����
				temp[index++]=a[j++];
				count+=mid-i+1;
				count=count>1000000007?count%1000000007:count;
			}else { 
				temp[index++]=a[i++];
			}
		}
    	while(i<=mid) {
    		temp[index++]=a[i++];
    	
    	}
        while(j<=end) {
        	temp[index++]=a[j++];
        }
        for(int k=0;k<temp.length;k++) {
        	a[start+k]=temp[k];
        }
    }
}
