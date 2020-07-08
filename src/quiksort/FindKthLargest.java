package quiksort;

public class FindKthLargest {

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int start = low, end = high + 1;

        while (start <= end) {
            while (start < high && nums[++start] <= pivot) {
            }
            while (end > low && nums[--end] >= pivot) {
            }
            if (start >= end) {
                break;
            }
            swap(nums, start, end);
        }
        swap(nums, low, end);
        return end;
    }

    // 使用快排
    public int findKthLargest(int[] nums, int k) {
        int index;
        int low = 0, high = nums.length - 1;
        int target = nums.length - k; // 转换成第target小的元素
        while ((index = partition(nums, low, high)) != target) {
            if (index < target) {
                low = index + 1;
            } else {
                high = index;
            }
//            if (index > target) {
//                high = index; // index - 1 是不行的，因为index这个元素在下一轮partition过程中就被忽略了
//            } else {
//                low = index + 1;
//            }
        }
        return nums[target];
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
