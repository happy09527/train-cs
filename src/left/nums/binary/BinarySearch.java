package left.nums.binary;

import java.util.HashMap;

/**
 * @author: ZhangX
 * @createDate: 2024/10/13
 * @description: 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,3,3,4,6};
//        System.out.println(findLeft(nums, 3));
        int[] nums = new int[]{1,1,6,5,6,6,1,1,1,1};
        System.out.println(totalFruit(nums));
    }
    public static int totalFruit(int[] fruits) {
        int res = 0;
        if(fruits.length==1)return 1;
        int n=fruits.length,first=0,second = 0,left=0;
        for(int i=1;i<n;i++) {
            if(fruits[i]!=fruits[first]){
                second = i;
                break;
            }
        }
        for(int i=0;i<n;i++) {
            if(fruits[i] == fruits[first]) {
                first = i;
            }else if( fruits[i] == fruits[second]) {
                second = i;
            }else {
                left=first+1;
                first = second;
                second = i;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
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
