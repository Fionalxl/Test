package lxl.Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanxiaoli on 2022/7/11.
 * 1、和为target的两个整数
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 2、和为s的所有整数序列
 */
public class SumIsS {
    //方法一，hashmap实现
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    //方法二：定义两个指针p1和p2，p1指向第一，p2指向最后。p1 + p2 大于sum，p2指针移动，p1 + p2 小于sum，p1指针移动，直到p1 + p2 = sum，返回p1和p2。
    public static ArrayList<Integer> findNumbersWithSum(int data[], int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (data == null || data.length < 2) {
            return list;
        }
        int p1 = 0; //指向数组首元素
        int p2 = data.length - 1; //指向数组末尾元素
        while (p2 > p1) {
            if (data[p1] + data[p2] == sum) {
                list.add(p1);
                list.add(p2);
            } else if (data[p1] + data[p2] > sum) {
                p2--;
            } else {
                p1++;
            }
        }
        return list;

    }

    //和为s的所有整数序列;
    // 定义两个指针p1和p2分别指向数组的第一个位置和数组的第二个位置，求序列的和，如果小于s，p2向后移动，继续就和，如果满足，打印当前p1和p2指向的序列片段，p2继续移动，此时序列的和会大于s，p1向前移动，判断序列和是否为s，如果小于s，p2向后移动，继续上面的判断，否则如果大于s，p1向前移动，在判断和，如果大于或者等于，或者小于，分别做对应的处理。等于的话：输出序列片段，p2向后移动；小于的话p2直接向后移动，再做判断；大于的话p1向后移动，再做判断。
    public static ArrayList<ArrayList<Integer>> finfContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) { //因为至少含有两个数,故1+2=3,故sum > 3
            return list;
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2; //因为至少连续2个且顺序增加，所以取中间值
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                for (int i = small; i <= big; i++) {
                    l.add(i);
                }
                list.add(l);
            }
            while (curSum > sum && small < middle) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    for (int i = small; i <= big; i++) {
                        l.add(i);
                    }
                    list.add(l);
                }
            }
            big++;
            curSum += big;
        }
        return list;
    }
}
