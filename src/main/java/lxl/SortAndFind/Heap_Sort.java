package lxl.SortAndFind;

/**
 * Created by lanxiaoli on 2022/8/3.
 */
public class Heap_Sort {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    /**
     * 堆排序(宇宙无敌的JAVA)
     *  第一步: 构建大顶堆
     *  第二步: 交换堆点元素(堆点元素与当前处理的二叉树最后一个元素交换)
     *  第三步: 去除二叉树最后一个节点, 对二叉树根节点堆化(heapify)
     *  第四步: 重复第二、第三步直至结束
     */
    private void heapSort(int[] nums) {
        int len = nums.length;
        //第一步: 构建大顶堆
        buildMaxHead(nums, len);
        //第四步: 重复第二、第三步直至结束
        for (int i = len - 1; i >= 1; i--) {
            //第二步: 交换堆点元素(堆点元素与当前处理的二叉树最后一个元素交换)
            swap(nums, i, 0);
            //第三步: 去除二叉树最后一个节点, 对二叉树根节点堆化(heapify)
            //  元素少于两个没有必要再处理, 这里不特殊判断处理
            heapify(nums, i, 0);
        }
    }

    /**
     * 构建大顶堆
     */
    private void buildMaxHead(int[] nums, int len) {
        //从倒数第二层数的节点开始, 一直到二叉树根节点, 进行堆化(heapify)
        //  求取最后一个节点的父节点, 父节点索引为 int parentIndex = (i - 1) / 2
        int lastNodeIndex = ((len - 1) - 1) / 2;
        for (int i = lastNodeIndex; i >= 0; i--) {
            heapify(nums, len, i);
        }
    }

    private void heapify(int[] nums, int len, int cur) {
        if (cur >= len){
            return;
        }
        //第一个子节点的索引位置 int c1 = 2 * i + 1
        //第二个子节点的索引位置 int c2 = 2 * i + 2
        int c1 = 2 * cur + 1;
        int c2 = 2 * cur + 2;
        //求最大值的索引
        int maxIndex = cur;
        if (c1 < len && nums[c1] > nums[maxIndex]){
            maxIndex = c1;
        }
        if (c2 < len && nums[c2] > nums[maxIndex]){
            maxIndex = c2;
        }
        //当前节点cur不是该堆的最大值, 交换元素值, 并递归被交换点进行堆化(heapify)
        if (cur != maxIndex){
            swap(nums, cur, maxIndex);
            heapify(nums, len, maxIndex);
        }
    }

    /**
     * 交换元素值
     */
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public static void main(String[] args){
        int[] num={1,12,2,23,34,13,4,5,3};
        Heap_Sort heap_sort=new Heap_Sort();
        heap_sort.sortArray(num);
        for(int i=0;i<num.length-1;i++){
            System.out.println(num[i]+" ");
        }
    }

}
