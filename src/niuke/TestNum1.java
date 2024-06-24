package niuke;

import java.util.*;

/**
 * @author: ZhangX
 * @createDate: 2023/7/16
 * @description:
 */
//class Test {
//    public static void hello() {
//        System.out.println("hello");
//    }
//}
//public class TestNum1 {
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Test test=null;
//        test.hello();
//    }
//}

public class TestNum1 extends Thread {
    static String name = "adsad";
    String age = "!2";

    public static void test1() {
        System.out.println();
    }

    public static void main(String[] args) {
//        TestNum1 b = new TestNum1();
//        b.run();
    Map<Character,Integer> map = new HashMap<>();
    map.clear();
        int i = 1;
        int temp = i;
        i++;
        i = temp;
        System.out.println(i);
        int[][] obs = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        uniquePathsWithObstacles(obs);
        integerBreak(10);
        String a = "Asd";
        a.toCharArray();
        ArrayDeque deque = new ArrayDeque();
        ArrayList aa = new ArrayList();
    }

    public static int integerBreak(int n) {
        int mid = n / 2;
        if (n == 2) return 1;
        int[] dp = new int[n];
        int res = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= mid; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[mid];
    }

    public void start() {
        System.out.println(name);
        for (int i = 0; i < 10; i++) {
            System.out.println("Value of i = " + i);
        }
        StringBuilder sb = new StringBuilder();
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}