package lxl.SortAndFind;

import java.util.Random;

/**
 * Created by lanxiaoli on 2022/8/3.
 */
public class Quick_Sort_Optimize2 {
    public int[] sortArray(int[] nums) {
        randomizeQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    //递归函数，每次找到分割点，将数组一分为二递归
    public void randomizeQuicksort(int[] nums, int left, int right) {
        //递归条件，一直递归到左右指针重合
        if (left < right) {
            //进行一趟排序并返回分割点(即枢轴位置)
            int partition = randomizePartition(nums, left, right);

            //递归每一趟下来分割得到的两数组
            randomizeQuicksort(nums, left, partition - 1);
            randomizeQuicksort(nums, partition + 1, right);

        }
    }

    //1.随机化选择枢轴
    //2.以选择的枢轴为基准，小值放左，最后将枢轴放中间，此时大值默认均在枢轴右边
    //3.返回当前枢轴位置，作为递归函数的分割点
    public int randomizePartition(int[] nums, int left, int right) {

        //随机化选出枢轴位置
        int pos = new Random().nextInt(right - left) + left;

        //将枢轴放于右边界
        swap(nums, pos, right);

        int pivot = nums[right];

        int patition = left;

        //规定left和right边界，真正的指针移动仅仅是partition
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, patition);
                ++patition;
            }
        }
        //将第一个比枢轴大的值放于最右端，枢轴放中间
        swap(nums, patition, right);
        //返回分割点
        return patition;
    }

    //无脑将两元素交换的函数
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
