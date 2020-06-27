import java.util.Arrays;

public class FindKthNumber {

    // 简化为m个有序数组的合并，时间复杂度k*m
    public int findKthNumber(int m, int n, int k) {
        int res = -1;
        int[] pos = new int[m];
        Arrays.fill(pos, 1);
        int start = 0;
        while (start < k) {
            res = findMin(pos, m, n);
            start ++;
        }
        return pos[res]-- * (res + 1);
    }

    int findMin(int[] arr, int m, int n) {
        int min = arr[0];
        int index = 0;
        for (int i = 0; i <= m && arr[i] <= n; i++) {
            if (arr[i] * (i + 1) < min) {
                index = i;
            }
        }
        arr[index]++;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthNumber().findKthNumber(3, 7, 5));
    }
}
