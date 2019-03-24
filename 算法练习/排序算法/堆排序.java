package �����㷨;

import java.util.Arrays;

public class ������ {

    //test
    public static void main(String[] args) {
        int[] num = {10, 23, 17, 88, 39, 13, 11, 109, 108, 383, 100, 1, 10, 14};
        initBuildHeap(num, 0, num.length - 1);
        System.out.println("��ʼ������ѣ�" + Arrays.toString(num));
        for (int i = num.length - 1; i >= 0; i--) {
            swap(num, 0, i);
            rebuildHeap(num, 0, i);
        }
        System.out.println("����������" + Arrays.toString(num));
    }

    //������ʼ������� �˲���ʱ�临�Ӷ��ǣ�N��logN��
    private static void initBuildHeap(int[] num, int index, int end) {

        if (num == null || index > end) {
            return;
        }
        for (int i = end; i >= index; i--) {
            int parent = (i - 1) / 2;
            if (num[i] > num[parent]) {
                swap(num, i, parent);
                initBuildHeap(num, index, i);
            }
        }
    }

    //ά���µĴ���ѽṹ
    private static void rebuildHeap(int[] num, int index, int end) {
        if (num == null || index > end) {
            return;
        }
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < end && num[index] < num[left]) {
            swap(num, index, left);
            rebuildHeap(num, left, end);
        }
        if (right < end && num[index] < num[right]) {
            swap(num, index, right);
            rebuildHeap(num, right, end);
        }
    }

    //���������� num[left] �� num[right] λ��
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}