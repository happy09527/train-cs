package leetcode.eveyday;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author: ZhangX
 * @createDate: 2022/11/14
 * @description: 数组的均值分割 805
 */
public class SplitNums {
    public static void main(String[] args) {
        System.out.print(splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    /**
     * @author: ZhangX
     * @date: 2022/11/14 19:34
     * @param: [nums]
     * @return: boolean
     * @description: 暴力回溯搜索
     **/
    public static boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        for (int i = 1; i <= n / 2; i++) {
            if (fun(nums, i, sum, n, 0, 0, 0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean fun(int[] nums, int k, int sum1, int len1, int sum2, int len2, int start) {
        if (k == len2) {
            if ((double) sum1 / len1 == (double) sum2 / len2) {
                return true;
            }
        }
        for (int i = start; i < nums.length; i++) {
            sum1 -= nums[i];
            len1--;
            if (fun(nums, k, sum1, len1, sum2 + nums[i], len2++, i + 1)) {
                return true;
            }
            sum1 += nums[i];
            len1++;
        }
        return false;
    }

    public static boolean splitArraySameAverage1(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        for (int i = 1; i <= n / 2; i++) {
            if (fun(nums, i, sum, n, 0, 0, 0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean fun1(int[] nums, int k, int sum1, int len1, int sum2, int len2, int start) {
        if (k == len2) {
            if ((double) sum1 / len1 == (double) sum2 / len2) {
                return true;
            }
        }
        for (int i = start; i < nums.length; i++) {
            sum1 -= nums[i];
            len1--;
            if (fun(nums, k, sum1, len1, sum2 + nums[i], len2 + 1, i + 1)) {
                return true;
            }
            sum1 += nums[i];
            len1++;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return false;
    }


    int sumA = 0;
    int lenA = 0;
    double avg = 0;
    double Edavg = 0;
    //dfs
    public boolean splitArraySameAverage2(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        Edavg = (double) sum / nums.length;
        for (int i = nums.length / 2; i >= 1; i--) {
            if (sum * i % nums.length == 0) {
                if (sp_dfs(nums, i, 0, sum, nums.length, 0, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean sp_dfs(int[] nums, int k, int start, int sum, int len, int sum1, int len1) {
        if (len1 == k) {
            avg = (double) sum1 / len1;
            if (Edavg != avg) return false;
            if (avg == (double) sum / len) {
                return true;
            }
        }
        for (int i = start; i < nums.length; i++) {
            sumA += nums[i];
            lenA += 1;
            if (sp_dfs(nums, k, i + 1, sum - nums[i], len - 1, sumA, lenA)) {
                return true;
            }
            sumA -= nums[i];
            lenA--;
            if (lenA == k - 1) {
                //在回溯的过程中 如果 lenA == k-1
                if ((double) (sumA + nums[nums.length - 1]) / (lenA + 1) < Edavg) {
                    i = nums.length - 1;
                    continue;
                }
                while (i + 1 < nums.length && (double) (sumA + nums[i + 1]) / (lenA + 1) != Edavg) {
                    i++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return false;
    }
}
