package lxl.Others;

/**
 * Created by lanxiaoli on 2022/7/11.
 * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 请找出数组中任意一个重复的数字。
 注意：如果某些数字不在 0∼n−1 的范围内，或数组中不包含重复数字，则返回 -1；
 */
public class DuplicateInArray {
    public int duplicateInArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        //提前遍历判断"如果某些数字不在 0∼n−1 的范围内,则返回 -1"
        for (int i=0; i<n; i++) {
            if (!(nums[i] >= 0 && nums[i] < n)) return -1;
        }

        for (int i=0; i<n; i++) {
            //循环将当前位置的元素放到对应的槽去
            while (nums[i] != nums[nums[i]]) swap(nums, i, nums[i]);

            //当前元素应该放到对应位置，但该位置的数字跟当前的一样，即重复了
            if (nums[i] != i && nums[i] == nums[nums[i]]) return nums[i];
        }

        return -1;
    }

    //交换数组两个元素
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
