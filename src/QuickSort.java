import java.util.Arrays;

public class QuickSort {


    // 返回轴元素的index，填坑法
    private static int partition(int[] unsorted, int low, int high) {
        int pivot = unsorted[low];
        while (low < high) {
            while (low < high && unsorted[high] > pivot) {
                high--;
            }
            unsorted[low] = unsorted[high];
            while (low < high && unsorted[low] <= pivot) {
                low++;
            }
            unsorted[high] = unsorted[low];
        }
        unsorted[low] = pivot;
        return low;
    }

    // 基于swap的分区
    private static int partitionV2(int[] unsorted, int low, int high) {
        int pivot = unsorted[low];
        int i = low; int j = high + 1;
        while (true) {
            while (i < high && unsorted[++i] < pivot); // ++i还是i++看初始值
            while (j > low && unsorted[--j] >= pivot);
            if (i >= j) {
                break;
            }
            Utils.swap(unsorted, i, j);
        }
        // 由于pivot右侧的值是大于等于pivot的，因此交换的位置必须是小于等于pivot一侧的位置，否则可能把大于pivot的值交换到low的位置，就不符合
        // 划分的逻辑了
        int t = i == j ? i : i -1; // i和j不同是，交换的位置j即i-1，总之是j
        Utils.swap(unsorted, low, t); // 必须是j 把中轴元素swap到哪个index上，即返回此index
        return t; // 必须是j，即i-1或者i
    }


    private static void quickSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        // partition to a & b
        int m = partitionV2(arr, l, h);
        // quickSort a
        quickSort(arr, l, m - 1);
        // quickSort b
        quickSort(arr, m + 1, h);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 6, 2, 5, 8, 4, 7};
        quickSort(a, 0, 7);
        System.out.println(Arrays.toString(a));
    }

}
