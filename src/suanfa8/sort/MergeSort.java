package suanfa8.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] res = sort(nums);
        for (int i : res) System.out.println(i);
    }

    public static int[] sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int hl = left;
        int hr = mid + 1;
        while (hl <= mid && hr <= right) {
            help[i++] = (nums[hl] > nums[hr]) ? nums[hr++] : nums[hl++];
        }
        while (hl <= mid) {
            help[i++] = nums[hl++];
        }
        while (hr <= right) {
            help[i++] = nums[hr++];
        }
        for (i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }
}
