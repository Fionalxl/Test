package lxl.SortAndFind;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lanxiaoli on 2022/7/19.
 * 最小的k个数
 */
public class LeastK {
//    方法一：快排，O（n）的算法，只有当我们可以修改输入的数组是可用
    public ArrayList<Integer> getLeastNumbers(int nums[], int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int lens = nums.length;
        if (nums == null || lens == 0 || k > lens || k <= 0) {
            return list;
        }
        int start = 0;
        int end = lens - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        return list;

    }
    private int partition(int[] nums, int start, int end) { //快排
        int privotKey = nums[start];
        while (start < end) {
            while (start < end && privotKey <= nums[end]) {
                --end;
            }
            swap(nums, start, end);//交换位置，使大于privotkey的值位于数组右边

            while (start < end && privotKey >= nums[start]) {
                ++start;
            }
            swap(nums, start, end);//交换位置，使小于privotkey的值位于数组左边
        }
        return start;

    }

    private void swap(int[] nums, int start, int end) { //交换数组元素位置
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    //方法二：O（nlogk）的算法，特别适合处理海量数据
    public static ArrayList<Integer> getLeastNumbersI(int []nums, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int lens = nums.length;
        if (nums == null || lens == 0 || k > lens || k <= 0) {
            return list;
        }
        TreeSet<Integer> kSet = new TreeSet<Integer>();
        for (int i = 0; i < lens; i++) {
            if (kSet.size() < k) {
                kSet.add(nums[i]);
            } else if (nums[i] < kSet.last()) {
                kSet.remove(kSet.last());
                kSet.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = kSet.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
    //最大的k个数，使用PriorityQueue实现
    public static ArrayList<Integer> getLeastNumbersII(int []nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        ArrayList<Integer> list=new ArrayList<>();
        int lens = nums.length;
        if (nums == null || lens == 0 || k > lens || k <= 0) {
            return list;
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
        while (k-- > 0) {
            list.add(priorityQueue.poll());
        }
        return list;

    }
    //最小的k个数，使用PriorityQueue实现
    public static ArrayList<Integer> getLeastNumbersIII(int []nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new com());
        ArrayList<Integer> list=new ArrayList<>();
        int lens = nums.length;
        if (nums == null || lens == 0 || k > lens || k <= 0) {
            return list;
        }
        for(int i = 0; i < lens; i++) {
            if(priorityQueue.size()<k){
                priorityQueue.add(nums[i]);
            }else if(nums[i]<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
//        Iterator<Integer> iterator = priorityQueue.iterator();
//        while (iterator.hasNext()) {
//            list.add(iterator.next());
//        }
        while (k-- > 0) {
            list.add(priorityQueue.poll());
        }
        return list;

    }

    static class com implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) { //测试
        int nums[] = {4, 5, 9, 6, 2, 7, 3, 8};
        LeastK m = new LeastK();
        ArrayList<Integer> list = m.getLeastNumbersIII(nums, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        String[] arr = {"1", "2", "3", "4", "5", "3", "5", "2", "5"};
        System.out.println(topKString(arr, 2));

    }


    // 字符串频次topK
    static class StrObj {
        public String str;
        public int count;

        public StrObj(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }


    public static List<String> topKString(String[] arr, int k) {
        Map<String, StrObj> map = new HashMap<>();
        for (String str : arr) {
            if (map.containsKey(str)) {
                map.get(str).count++;
            } else {
                map.put(str, new StrObj(str, 1));
            }
        }

        PriorityQueue<StrObj> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        for (StrObj strObj : map.values()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(strObj);
            } else if (strObj.count > priorityQueue.peek().count) {
                priorityQueue.poll();
                priorityQueue.add(strObj);
            }
        }

        return priorityQueue.stream().map(strObj -> strObj.str).collect(Collectors.toList());
    }



}
