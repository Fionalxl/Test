package lxl.Others;

/**
 * Created by lanxiaoli on 2020/6/16.
 * 连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    //常规方法
    public int findGreatestSumOfSubArray(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        // 用currentSum记录当前的和
        int currentSum = 0;
        // 用finalGreatSum记录历史最佳
        int finalGreatSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(currentSum<=0){
                currentSum=array[i];
            }else{
                currentSum+=array[i];//当array[i]为正数时，加上之前的最大值并更新最大值
            }
            // 如果currentSum>finalGreatSum则替换finalGreatSum
            if(finalGreatSum<currentSum){
                finalGreatSum=currentSum;
            }
        }
        return finalGreatSum;
    }
    //动态规划
    public int findGreatestSumOfSubArray_1(int[] array){
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max = array[0]; //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }

}
