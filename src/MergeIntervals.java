import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();

        for (int[] a : intervals) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                int[] arr = stack.pop();
                if (arr[1] >= a[0]) {
                    int[] combine = {arr[0], Math.max(arr[1], a[1])};
                    stack.push(combine);
                } else {
                    stack.push(arr);
                    stack.push(a);
                }
            }
        }

        return stack.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

}
