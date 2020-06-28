package binsearch;

// https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
public class NextGreatestLetter {

    /**
     * 二分法
     */
    private static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target < letters[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return letters[l % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }

}
