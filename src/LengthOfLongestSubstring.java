import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstringA(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
                System.out.println("start = " + start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    // 以 abcdecgcbe 为例，当left = 0, end = 5时，遇到第一个重复字符，即c，此时要移动left，可以很明显看到
    // 为了寻找下一个无重复字符的串的起始位置, a[0] 直到 a[2]都是不满足要求的，因为中间有一个a[2]，即重复字符c
    // 所以要移动到重复字符的下一个位置，即a[3]
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 这里之所以需要max，主要时防止left往回走，比如第一次的重复字符时c，第二次的重复字符时b，而b的位置在c的左侧
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstringA("abcdecgcbe"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcdecgcbe"));
    }
}
