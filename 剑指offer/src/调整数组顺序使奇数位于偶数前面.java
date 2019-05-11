package src;
/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 * @author zoe
 *
 */

public class ��������˳��ʹ����λ��ż��ǰ�� {
	/**
	 * ���Ӷȣ�O(n^2)
	 * @param array
	 * @return
	 */

	//����ð������,ǰż����ͽ���
	public static int[] reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++) {
        	for(int j=array.length-1;j>i;j--) { //�Ӻ���ǰ��������Ȼ�����
        		if(array[j]%2==1 && array[j-1]%2==0) { 
        			int tmp=array[j];
        			array[j]=array[j-1];
        			array[j-1]=tmp;
        		}
        	}
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        arr = reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
