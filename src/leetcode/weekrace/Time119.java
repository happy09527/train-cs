package leetcode.weekrace;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangX
 * @createDate: 2023/12/9
 * @description:
 */
public class Time119 {
    public static int removeAlmostEqualCharacters(String word) {
        char[] cs = word.toCharArray();
        int len = word.length();
        int res = 0, i = 0;
        while (i < len) {
            if (i == len - 1) {
                return res;
            } else if (i == 0 && Math.abs(cs[i] - cs[i + 1]) < 2) {
                res++;
                cs[i + 1] = '0';
                i++;
            } else if (i > 0 && i < len - 1 && Math.abs(cs[i] - cs[i - 1]) < 2 || Math.abs(cs[i] - cs[i + 1]) < 2) {
                res++;
                cs[i + 1] = '0';
            }
            i++;
        }
        return res;
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], map.getOrDefault(map.get(nums[i]), 0) + 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            while (left <= i && map.get(nums[i]) > k) {
                left++;
                map.put(nums[left], map.get(nums[left]) - 1);
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubarrayLength(new int[]{1, 2, 2, 1}, 1));
//        System.out.println(findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}}));
//        System.out.println(divideArray(new int[]{1,3,4,8,7,9,3,5,1},2));
//        System.out.println(minimumCost(new int[]{10, 12, 13, 14, 15}));
//        System.out.println(largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
//        System.out.println(incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
//        System.out.println(maximumLength("aaaa"));[29,30,31,32,33,34,35,36,37]
//        System.out.println(missingInteger(new int[]{29,30,31,32,33,34,35,36,37}));
//        System.out.println(Integer.toBinaryString(5));
//        System.out.println(minOperations(new int[]{2, 1, 3, 4}, 1));
        System.out.println(Integer.bitCount(3));
    }
    public static int minimumOperationsToMakeEqual(int x, int y) {
        int res = 0, temp = 0;
        if(y>=x){
            return y-x;
        }
        while(x != y){
            if(x>5*y && x%11 < x%5){
                res += x%5;
                x -= x%5;
            }
            while(x% 11 ==0 && x > y*11){
                x /=11;
                res++;
            }
            while(x%5==0&& x > y*5){
                y /= 5;
                res++;
            }

            while(y>x){
                y--;
                res++;
            }
        }
        return res;
    }
    public static int minOperations(int[] nums, int k) {
        int record = 0, res = 0;
        for (int i : nums) {
            res ^= i;
        }
        String bin = Integer.toBinaryString(res);
        String kb = Integer.toBinaryString(k);
        int len1 = bin.length(), len2 = kb.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (bin.charAt(len1 - i - 1) != kb.charAt(len2 - i - 1)) {
                record++;
            }
        }
        if (len1 > len2) {
            for (int i = 0; i < Math.abs(len1 - len2); i++) {
                if (bin.charAt(i) == '1') {
                    record++;
                }
            }
        } else {
            for (int i = 0; i < Math.abs(len1 - len2); i++) {
                if (kb.charAt(i) == '1') {
                    record++;
                }
            }
        }
        return record;
    }

    public static int missingInteger(int[] nums) {
        int sum = 0, max = 0, left = 0, maxsum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i - 1];
            if (nums[i - 1] != nums[i] - 1) {
                maxsum = 1;
                break;
            }

        }
        if (maxsum == 0) {
            sum += nums[nums.length - 1];
        }
        Arrays.sort(nums);
        for (int i = sum; i < 2600; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return sum;
    }

    public static int maximumLength(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len - 1; j++) {
                String cur = s.substring(i, j + 1);
                boolean record = true;
                for (int k = 1; k < cur.length(); k++) {
                    if (cur.charAt(k) != cur.charAt(k - 1)) {
                        record = false;
                    }
                }
                if (!record) {
                    continue;
                }
                int m = 0;
                for (int k = 0; k + (j - i) < len; k++) {
                    if (s.substring(k, k + j - i + 1).equals(cur)) {
                        m++;
                    }
                }
                if (m >= 3) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res == 0 ? -1 : res;
    }

    public static int aa(String s) {
        int res = 0;
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, nums[i]);
        }
        if (max < 3) {
            return -1;
        } else if (max >= 3 && max < 6) {
            return 1;
        }
        for (int i = 0; i < 26; i++) {
            if (nums[i] >= 6) {
                for (int j = 0; j < s.length(); j++) {
                    for (int k = j; k < s.length(); k++) {
//                        if(s.charAt())
                    }
                }
            }
        }
        return 0;
//        int max = 0;
//        for(int i=0;i<26;i++){
//            max = Math.max(max,nums[i]);
//        }
//        if(max<3){
//            return -1;
//        }else if(max>=3 && max<6){
//            return 1;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (nums[i] >= 6) {
//                int record = 0;
//                int[] records = new int[s.length()];
//                for (int j = 1; j < s.length(); j++) {
//                    if(s.charAt(j)=='a' && s.charAt(j)==s.charAt(j-1)){
//                        record++;
//                        records[j] = record;
//                    }else{
//                        record=0;
//                    }
//                }
//                Arrays.sort(records);
//                res = Math.max(res, records[2]);
//            }
//        }

    }

    public static boolean hasTrailingZeros(int[] nums) {
        int os = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                os++;
            }
        }
        return os >= 2;
    }

    public static int incremovableSubarrayCount(int[] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (func(nums, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean func(int[] nums, int left, int right) {
        if (left == 0 || right == nums.length - 1) {
            return true;
        }
        if (nums[left - 1] < nums[right + 1]) {
            return true;
        }
        return false;
    }

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
        }
        if (sum > nums[n - 1]) {
            return sum + nums[n - 1];
        }
        int right = n - 1;
        while (right >= 2 && sum <= nums[right]) {
            right--;
            sum -= nums[right];
            if (sum > nums[right]) {
                return sum + nums[right + 1];
            }
        }
        return -1;
    }

    public static long minimumCost(int[] nums) {
        long res = 0;
        long l = 0, r = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int middle = nums[n / 2];
        int[] hw = huiwen(middle);
        int left = hw[0], right = hw[1];
        for (int i = 0; i < nums.length; i++) {
            l += Math.abs(left - nums[i]);
            r += Math.abs(right - nums[i]);
        }
        return Math.min(l, r);
    }

    public static int[] huiwen(int middle) {
        int[] res = new int[2];
        for (int i = middle; i > 0; i--) {
            if (isPalindrome(i)) {
                res[0] = i;
                break;
            }
        }
        for (int i = middle; i < 1000000000; i++) {
            if (isPalindrome(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int num = 0;
        while (x > num) {
            num = x % 10 + num * 10;
            x /= 10;
        }
        return x == num || x == num / 10;
    }


    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        int left = 0, j = 0;
        for (int i = 2; i < n; i += 3) {
            if (nums[i] - nums[left] <= k) {
                for (int m = 0; m < 3; m++) {
                    res[j][m] = nums[left++];
                }
                j++;
            } else {
                return new int[][]{};
            }
        }
        return res;
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int n = grid.length;
        int[] record = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (record[grid[i][j]] != 0) {
                    res[0] = grid[i][j];
                }
                record[grid[i][j]] = grid[i][j];
            }
        }
        for (int i = 1; i < n * n + 1; i++) {
            if (record[i] == 0) {
                res[1] = record[i];
                return res;
            }
        }
        return res;
    }
}
