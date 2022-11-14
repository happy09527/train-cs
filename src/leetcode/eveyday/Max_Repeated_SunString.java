package leetcode.eveyday;


import java.util.ArrayList;
import java.util.List;

public class Max_Repeated_SunString {
    public static void main(String[] args) {
//        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
        System.out.println(getPos("001"));
    }

    public static List<String> getPos(String s) {
        List<String> pos = new ArrayList<String>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            pos.add(s);
        }
        for (int p = 1; p < s.length(); ++p) {
            if ((p != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                continue;
            }
            pos.add(s.substring(0, p) + "." + s.substring(p));
        }
        return pos;
    }

    public static int maxRepeating(String sequence, String word) {
        int sLen = sequence.length();
        int wLen = word.length();
        int ans = 0;
        for (int i = 0; i < sLen; i++) {
            if (sequence.charAt(i) != word.charAt(0)) {
                continue;
            }
            int j = 0;
            while (i + j < sLen && sequence.charAt(i + j) == word.charAt(j % wLen)) {
                j++;
            }
            ans = Math.max(ans, j / wLen);
        }
        return ans;
    }
}
