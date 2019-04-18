package 排序算法;

import java.util.Arrays;

public class 堆排序 {

    //test
    public static void main(String[] args) {
        int[] num = {10, 23, 17, 88, 39, 13, 11, 109, 108, 383, 100, 1, 10, 14};
        initBuildHeap(num, 0, num.length - 1);
        System.out.println("初始化大根堆：" + Arrays.toString(num));
        for (int i = num.length - 1; i >= 0; i--) {
            swap(num, 0, i);
            rebuildHeap(num, 0, i);
        }
        System.out.println("堆排序结果：" + Arrays.toString(num));
    }

    //构建初始化大根堆 此步骤时间复杂度是：N（logN）
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

    //维护新的大根堆结构
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

    //交互数组中 num[left] 和 num[right] 位置
    private static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}