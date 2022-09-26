package lxl.SortAndFind;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by lanxiaoli on 2020/6/17.
 * 无序数组第k大的一个数
 */
public class Find_MaxK {
    //快排实现
    public int sort(int[] num,int low,int high){
        int temp=num[low];
        if(num==null||num.length<=0){
            return 0;
        }
        while (low<high){
            while (num[high]<=temp&&high>low){//从后半部分开始扫描
               --high;
            }
            num[low]=num[high];
            while (num[low]>temp&&high>low){//从前半部分扫描
                ++low;
            }
            num[high]=num[low];
        }
        num[high]=temp;
        return high;
    }
    public void find_k(int k,int[] num,int low,int high){
        int k_temp=sort(num,low,high);
        if(k_temp==k-1){
            System.out.println("第"+k+"大的数字"+num[k_temp]);
        }else if(k_temp>k-1){
            find_k(k,num,low,k_temp-1);
        }else {
            find_k(k-k_temp,num,k_temp+1,high);
        }
    }
    //快排优化取随机数
    Random rand=new Random();
    public int findKthLargest3(int[] nums, int k) {

        return quickSort(nums,k,0,nums.length-1);
    }
    private int quickSort(int[] nums,int k,int left,int right){
        int index=rand.nextInt(right-left+1)+left;
        int flag=nums[index];
        nums[index]=nums[left];
        int i=left,j=right;
        while (i<j){
            while (i<j&&nums[j]<=flag) j--;
            nums[i]=nums[j];
            while (i<j&&nums[i]>=flag) i++;
            nums[j]=nums[i];
        }
        nums[i]=flag;
        if (i==k-1) return nums[i];
        else if (i<k-1) return quickSort(nums,k,i+1,right);
        else return quickSort(nums,k,left,i-1);
    }

    public static void main(String[] args){
        int[] num={2,13,3,1,7,10,14,5};
        Find_MaxK k=new Find_MaxK();
        k.find_k(1,num,0,num.length-1);
        getLeastNumbersII(num,1);
    }

    //堆排序实现，大根堆，做 k - 1次删除操作后堆顶元素就是我们要找的答案
    public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildMaxHeap(nums, heapSize);
            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
                swap(nums, 0, i);
                --heapSize;
                maxHeapify(nums, 0, heapSize);
            }
            return nums[0];
        }

    public void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2; i >= 0; --i) {
                maxHeapify(a, i, heapSize);
            }
        }

    public void maxHeapify(int[] a, int i, int heapSize) {
            int l = i * 2 + 1, r = i * 2 + 2, largest = i;
            if (l < heapSize && a[l] > a[largest]) {
                largest = l;
            }
            if (r < heapSize && a[r] > a[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(a, i, largest);
                maxHeapify(a, largest, heapSize);
            }
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    //采用PriorityQueue实现
    public static void getLeastNumbersII(int []nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        int lens = nums.length;
        if (nums == null || lens == 0 || k > lens || k <= 0) {
            return;
        }
        for(int i = 0; i < lens; i++) {
            if(priorityQueue.size()<k){
                priorityQueue.add(nums[i]);
            }else if(nums[i]>priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
//        Iterator<Integer> iterator = priorityQueue.iterator();
//        while (iterator.hasNext()) {
//            list.add(iterator.next());
//        }
        System.out.println(priorityQueue.peek());

    }

}
