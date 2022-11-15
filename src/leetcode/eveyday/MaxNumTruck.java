package leetcode.eveyday;

import java.util.Arrays;

/**
 * @author: ZhangX
 * @createDate: 2022/11/15
 * @description:
 */
public class MaxNumTruck {
    public static void main(String[] args) {
        System.out.print(maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 4));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        int i = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            if (truckSize > boxTypes[i][0]) {
                res += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
                i--;
            } else {
                res += truckSize * boxTypes[i][1];
                truckSize = 0;
            }

        }
        return res;
    }
}
