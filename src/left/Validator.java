package left;

/**
 * @author: ZhangX
 * @createDate: 2024/6/24
 * @description: 对数器
 */
public class Validator {

    // 生成随机数组
    public static int[] randomArr(int x, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * x) + 1;
        }
        return arr;
    }

    // 比较两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
