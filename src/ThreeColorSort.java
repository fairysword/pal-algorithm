import java.util.Arrays;

/**
 * 三色排序算法
 * 扩展：K色排序算法
 *   思路：这道题是三颜色排序的进化版本，k颜色排序题，总体还是采用双指针法，重复部分不再复述。假设当前排序考虑的颜色范围是[c_min，c_max]，则它们初始值为c_min = 0、c_max = k - 1。
 * 一轮排序之后，两种颜色c_min = 0、c_max = k - 1已经处理完毕（分别交换至数组两端），接下来考虑[c_min + 1 = 1，c_max - 1 = k - 2]范围内的颜色排序，并重复该步骤直到c_min >= c_max，退出该循环。
 * 时间复杂度为O(n * k)。
 */

public class ThreeColorSort {

    private static final int R = 0;
    private static final int G = 1;
    private static final int B = 2;


    private static void sort(int[] unsorted) {
        int left = 0, cur = 0, right = unsorted.length - 1;
        while (cur <= right) { // 这里必须是小于等于
            if (unsorted[cur] == 2) {
                Utils.swap(unsorted, cur, right--);
            } else if (unsorted[cur] == 0) {
                Utils.swap(unsorted, cur++, left++);
            } else {
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{R, B, B, G, R, B, G, G, B, G, R, R, B};
        Utils.shuffle(unsorted);
        sort(unsorted);
        System.out.println("" + Arrays.toString(unsorted));
    }


}
