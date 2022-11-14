package suanfa8.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] res = sort(nums);
        for (int i : res) System.out.println(i);
    }

    public static int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}