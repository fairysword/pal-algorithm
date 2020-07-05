package binsearch;

import java.util.Arrays;

public class SmallestK {

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 基于swap的分区
    private static int partition(int[] unsorted, int low, int high) {
        int pivot = unsorted[low];
        int i = low; int j = high + 1;
        while (true) {
            while (i < high && unsorted[++i] <= pivot); // ++i还是i++看初始值
            while (j > low && unsorted[--j] >= pivot);
            if (i >= j) {
                break;
            }
            swap(unsorted, i, j);
        }
        // 由于pivot右侧的值是大于等于pivot的，因此交换的位置必须是小于等于pivot一侧的位置，否则可能把大于pivot的值交换到low的位置，就不符合
        // 划分的逻辑了
        swap(unsorted, low, j); // 必须是j 把中轴元素swap到哪个index上，即返回此index
        return j; // 必须是j，即i-1
    }

    // 使用快排
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int piv = -1;
        int low = 0, high = arr.length -1;
        while ((piv = partition(arr, low, high)) != k-1) {
            if (piv < k -1) {
                low = piv + 1;
            } else {
                high = piv;
            }
        }
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallestK().smallestK(new int[] {1,2,3}, 0)));
    }
}
