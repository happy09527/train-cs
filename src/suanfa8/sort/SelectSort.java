package suanfa8.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] res = sort(nums);
        for (int i : res) System.out.println(i);
    }

    public static int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            swap(nums, index, i);
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
