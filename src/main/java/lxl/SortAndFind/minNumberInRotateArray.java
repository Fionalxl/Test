package lxl.SortAndFind;

/**
 * Created by lanxiaoli on 2022/7/8.
 * 1、旋转数组的最小值
 * 二分法：找到中间下标，如果数组开始值小于中间下标对应的值，则表示中间下标属于第一个递增，另开始下标等于中间下标，
 * 相反，如果中间下标对应的值小于结尾值，则表明，中间下标输入第二个递增，另结尾下标等于中间下标。直到开始下标和结尾下标相邻。
 * 2、搜索旋转数组特定值
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class minNumberInRotateArray {
    //旋转数组的最小值
    public static int minNumberInRotateArray1(int[] rotateArray) {
        if (rotateArray.length == 0)
            return 0;
        int left = 0, right = rotateArray.length - 1;

        while (left < right) {
            if (rotateArray[left] < rotateArray[right])
                return rotateArray[left];
            int mid = (left + right) >> 2;
            if (rotateArray[left] < rotateArray[mid])
                left = mid + 1;
            else if (rotateArray[right] > rotateArray[mid])
                right = mid;//防止mid处于递增序列部分的第一个值
            else
                left++;
        }
        return rotateArray[left];

    }
    public static void main(String[] args){
        int[] array={4,5,6,1,2,3};
        int a= minNumberInRotateArray1(array);
        System.out.print(a);
    }
    //给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
    public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }

}
