package test;

import java.util.Arrays;

public class Arrays����ϰ {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] array=new int[5];
		Arrays.fill(array,3); // �������,3�������ֵ
		System.out.println("������飺Arrays.fill(array, 5)��");
		printArray(array);
		// ������ĵ�2�͵�3��Ԫ�ظ�ֵΪ8
        Arrays.fill(array, 2, 4, 8);
        System.out.println("������ĵ�2�͵�3��Ԫ�ظ�ֵΪ8��Arrays.fill(array, 2, 4, 8)��");
        printArray(array);
        int[] array1 = { 7, 8, 3, 2, 12, 6, 3, 5, 4 };
        printArray(array1);
     // ������ĵ�2������6�����������������
        Arrays.sort(array1, 2, 7);
        System.out.println("������ĵ�2������6��Ԫ�ؽ��������������Arrays.sort(array,2,7)��");
        printArray(array1);
     // �����������������
        Arrays.sort(array1);
        System.out.println("�����������������Arrays.sort(array1)��");
        printArray(array1);
        // �Ƚ�����Ԫ���Ƿ����
        System.out.println("�Ƚ�����Ԫ���Ƿ����:Arrays.equals(array, array1):" + "\n" + Arrays.equals(array, array1));
        int[] array2 = array1.clone();
        System.out.println("��¡������Ԫ���Ƿ����:Arrays.equals(array1, array2):" + "\n" + Arrays.equals(array1, array2));
        // ʹ�ö��������㷨����ָ��Ԫ�����ڵ��±꣨����������õģ�����������ȷ��
        Arrays.sort(array1);
        System.out.println("Ԫ��3��array1�е�λ�ã�Arrays.binarySearch(array1, 3)��" + "\n" + Arrays.binarySearch(array1, 3));
        // ��������ھͷ��ظ���
        System.out.println("Ԫ��9��array1�е�λ�ã�Arrays.binarySearch(array1, 9)��" + "\n" + Arrays.binarySearch(array1, 9));
	}
	
	// ��ӡ��������Ԫ��
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println("");
	}

}
