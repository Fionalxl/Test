package lxl.SortAndFind;

import java.util.HashMap;

/**
 * Created by lanxiaoli on 2022/7/8.
 * 数字在排序数组中出现的次数
 */
public class GetNumberOfK {
    //方法1
    public int GetNumberOfK1(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0;i<array.length;i++) {
            int a = array[i];
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            }else{
                map.put(a, 1);
            }
        }
        if (map.get(k) != null) {
            result = map.get(k);
        }
        return result;
    }
    //方法2
    public int GetNumberOfK2(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        if (k < array[0]) return 0;
        int first = binarySearch(array, k);
        int last = binarySearch(array,k+1);
        return (first==array.length || array[first]!=k)?0:last-first;
    }

    /*二分查找算法 --  输入数组中该数值的第一个位置*/
    public static int binarySearch(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] a={1,2,2,3,5,6,7,7,7};
        GetNumberOfK getNumberOfK=new GetNumberOfK();
        System.out.println(getNumberOfK.GetNumberOfK1(a,8));

    }


}
