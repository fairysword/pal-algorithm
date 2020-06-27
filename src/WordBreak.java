import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 还是用回溯法，时间复杂度
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    // 回溯法，先看第一个单词是哪个，再看第二个单词是哪个，增加memo数组，降低时间复杂度
    public boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
//        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//        System.out.println(new WordBreak().wordBreak("cbca", Arrays.asList("bc", "ca")));
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));

    }

}
