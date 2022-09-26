package lxl.HuaWei;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanxiaoli on 2022/7/30.
 * 一维数组，找到最小路径走到最后一个，输出最小步数
 * 要求1：1=<第一步步长<=len/2;要求2：从第二步开始，只能跳它所属数值的步长；要求3：每一步步长>=1
 * 输入7, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9
 * 输出2
 * 输入1, 2, 3, 7, 1, 5, 9, 3, 2, 1
 * 输出-1
 */
public class Q1 {
    public static void main(String[] args) {
         int[] arr = {7, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9};
//        int[] arr = {1, 2, 3, 7, 1, 5, 9, 3, 2, 1};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list;
        for (int i = arr.length - 2; i >= 1; i--) {
            if (arr.length - 1 - i == arr[i]) {
                list = new ArrayList<>();
                dp(i, arr.length - 1, arr, result, list);
            }
        }
        int min = arr.length;
        for (List<Integer> l : result) {
            min = Math.min(min, l.size());
        }
        System.out.println(min != arr.length ? min : -1);
    }

    public static void dp(int index, int target, int[] arr, List<List<Integer>> result, List<Integer> list) {
        if (target - index != arr[index] && index != 0) {
            return;
        }
        if (index == 0) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(index);
            result.add(temp);
            return;
        }
        list.add(index);
        for (int i = index - 1; i >= 0; i--) {
            dp(i, index, arr, result, list);
        }
        list.remove(list.size() - 1);
    }

}