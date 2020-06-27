public class Merge {



    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >=0) {
            nums1[pos--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j+1);
        System.out.println(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        System.out.println(nums1);
    }

    public static void main(String[] args) {
        new Merge().merge(new int [] {0}, 0, new int[] {1}, 1);
        new Merge().merge2(new int [] {0}, 0, new int[] {1}, 1);

    }
}
