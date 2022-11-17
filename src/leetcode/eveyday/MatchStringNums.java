package leetcode.eveyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ZhangX
 * @createDate: 2022/11/17
 * @description:
 */
public class MatchStringNums {
    public static void main(String[] args) {
        MatchStringNums matchStringNums = new MatchStringNums();
        matchStringNums.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }

    public int numMatchingSubseq(String s, String[] words) {
        Set<Character> map = new HashSet<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            map.add(c);
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean flag = help(s, word, map);
            if (flag) {
                res++;
            }
        }
        return res;
    }

    public boolean help(String s, String word, Set<Character> map) {
        int j = 0;
        for (int i = 0; i < word.length() && j < s.length(); i++) {
            char c = word.charAt(i);
            if (!map.contains(c)) {
                return false;
            }
            while (j < s.length()) {
                if (s.charAt(j) != c) {
                    j++;
                } else {
                    break;
                }
            }
            if (j >= s.length() || c != s.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }
}