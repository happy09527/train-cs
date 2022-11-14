package leetcode.eveyday;

/**
 * @author: ZhangX
 * @createDate: 2022/11/13
 * @description: num 791
 */
public class CustomStringSort {
    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }

    public static String customSortString(String order, String s) {
        int[] record = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (record[c - 'a'] != 0) {
                for (int j = 0; j < record[c - 'a']; j++) {
                    sb.append((char) (c - 'a' + 97));
                }
                record[c - 'a'] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                for (int j = 0; j < record[i]; j++) {
                    sb.append((char) (i + 97));
                }
            }
        }
        return sb.toString();
    }

}
