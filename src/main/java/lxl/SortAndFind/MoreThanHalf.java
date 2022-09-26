package lxl.SortAndFind;

/**
 * Created by lanxiaoli on 2022/7/8.
 * 数组中次数超过一半的数字
 * 数组中有一个数字出现的次数操作数组长度的一半，即它的出现次数比其他所有数字出现的次数的总和还要多。
 * 因此，我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，
 * 如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1.如果次数为0，
 * 我们需要保存下一个数字，并把次数设置为1.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设置为1时对应的数字。
 * O(n)
 */
public class MoreThanHalf {
    public int moreThanHalfNum(int nums[]) {
        int lens = nums.length;
        if (nums == null || lens == 0) {
            return 0;
        }
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < lens; ++i) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (nums[i] == result) {
                ++times;
            } else {
                --times;
            }
        }
        if (checkMoreThanHalf(nums, result)) { //判断一下result出现的次数是否超过result，超过返回结果否则返回0
            return result;
        } else {
            return 0;
        }

    }
    private boolean checkMoreThanHalf(int nums[], int result) {
        int times = 0;
        int lens = nums.length;
        for (int i = 0; i < lens; i++) {
            if (result == nums[i]) {
                ++times;
            }
        }
        if (times * 2 > lens) {
            return true;
        }
        return false;

    }
    public static void main(String[] args) { //测试
        MoreThanHalf m1 = new MoreThanHalf();
        int nums[] = {1, 2, 3, 2, 2, 3, 2, 4,2, 2};
        int num = m1.moreThanHalfNum(nums);
        System.out.println(num);
    }
}
