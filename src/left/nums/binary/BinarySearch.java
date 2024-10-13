package left.nums.binary;

/**
 * @author: ZhangX
 * @createDate: 2024/10/13
 * @description: 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3,4,6};
        System.out.println(findLeft(nums, 3));
    }

    /**
     * @description: 寻找大于target最左边的数
     * @param: [nums, target]
     * @return: int
     * @date: 2024/10/13 9:40
     */
    public static int findLeft(int[] nums, int target) {
        int res = -1,left = 0,right = nums.length -1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    /**
     * @description: 寻找峰值
     * @param: [nums]
     * @return: int
     * @date: 2024/10/13 10:12
     */
    public static int findPeakElement(int[] nums) {
        int n = nums.length,ans = -1;
        if(n==1)return 0;
        if(nums[0] > nums[1])return 0;
        if(nums[n-1]> nums[n-2])return n-1;
        int left = 1,right = n-2;
        while(left <= right) {
            int mid = left + ((right-left)>>1);
            if(nums[mid] < nums[mid +1]) {
                left = mid +1;
            }else if(nums[mid] < nums[mid-1]){
                right = mid -1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
