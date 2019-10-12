import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 */
public class MaxGap {

    /**
     * 桶定义
     */
    static class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    private static int maxGap(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        IntSummaryStatistics statistics = Arrays.stream(arr).summaryStatistics();
        int max = statistics.getMax();
        int min = statistics.getMin();

        int bucketSize = Math.max(1, (max - min) / (arr.length - 1)); // 向下取整
        int bucketNum = (max - min) / bucketSize + 1;

        Bucket[] buckets = new Bucket[bucketNum];

        for (int num : arr) {
            int bucketIdx = (num - min) / bucketSize;                          // locating correct bucket
            Bucket bucket = buckets[bucketIdx];
            if (bucket == null) {
                bucket = new Bucket();
                buckets[bucketIdx] = bucket;
            }
            bucket.max = Math.max(num, bucket.max);
            bucket.min = Math.min(num, bucket.min);
        }

        int prevBucketMax = min, maxGap = 0;
        for (Bucket buk : buckets) {
            if (buk == null) {
                continue;
            }
            maxGap = Math.max(maxGap, buk.min - prevBucketMax);
            prevBucketMax = buk.max;
        }

        return maxGap;
    }


    public static void main(String[] args) {
        System.out.println(maxGap(new int[]{3, 6, 9, 1}));
    }

}
