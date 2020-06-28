package binsearch;

public class FindKthNumber {

    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n; // 将值域定义为一个有序数组
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) { // 这里的解题思路和最小K个数的思路一样，最主要的就是将值域定义为有序数组这个设定
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthNumber().findKthNumber(3, 7, 5));
    }
}
