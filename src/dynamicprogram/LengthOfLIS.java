package dynamicprogram;

/**
 * 最长上升子序列
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
 */
public class LengthOfLIS {

    /**
     * 时间复杂度为O(NxN)，空间复杂度O(N)
     */
    public int lengthOfLIS(int[] nums) {
        int[] lts = new int[nums.length];
        int lts_max = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(lts[j], max);
                }
            }
            lts[i] = max + 1; // 状态转移表达式
            lts_max = Math.max(lts_max, lts[i]);
        }
        return lts_max;
    }

    // 找到dest大于的第一个位置
    public int binSearch(int dest, int[] arr, int low, int high) {
        if (low > high) {
            return -1; // 没找到
        }
        int mid = (low + high) / 2;
        if (arr[mid] < dest) {
            low = mid + 1;
        } else {
            if ((mid > 0 && arr[mid - 1] < dest) || mid == 0) {
                return mid;
            }
            high = mid - 1;
        }
        return binSearch(dest, arr, low, high);
    }

    // 改进版本算法，状态数组时单调递增的，因此可以用二分查找搜索
    public int lengthOfLIS2(int[] nums) {
        // tails[k]即长度为k+1的子序列的尾部最小值
        int[] tails = new int[nums.length];
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            // 查找num[i]对应的值在tails中的位置
            int idx = binSearch(nums[i], tails, 0, end - 1);
            if (idx == -1) {
                tails[end++] = nums[i];
            } else {
                tails[idx] = nums[i];
            }
        }
        return end;
    }

    // 最直观的解法就是两个指针，依次遍历
    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS2(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
