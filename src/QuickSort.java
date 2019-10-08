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
        int pivot = unsorted[high];
        int i = low; int j = high + 1;
        while (true) {
            while (i < high && unsorted[++i] <= pivot);
            while (j > low && unsorted[--j] >= pivot);
            if (i >= j) {
                break;
            }
            swap(unsorted, i, j);
        }
        swap(unsorted, low, j);
        return j;
    }

    private static void swap(int[] arr, int i , int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        // partition to a & b
        int m = partition(arr, l, h);
        // quickSort a
        quickSort(arr, l, m - 1);
        // quickSort b
        quickSort(arr, m + 1, h);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 6, 2, 5, 8, 4, 7};
        quickSort(a, 0, 7);
        System.out.println('d');

        Arrays.sort(a);
    }

}
