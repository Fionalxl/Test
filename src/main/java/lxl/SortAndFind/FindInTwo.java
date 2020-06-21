package lxl.SortAndFind;

/**
 * Created by lanxiaoli on 2020/6/18.
 * 在二维数组中查找特定数，数组是从左到右递增，从上到下递增
 */
public class FindInTwo {
    public boolean findInTwo(int[][] array,int target){
        if(array==null) return false;
        int rows=0;
        int cols=array[0].length-1;
        while (rows<array[0].length-1&&cols>=0){
            if(array[rows][cols]==target){
                return true;
            }
            else if (array[rows][cols]<target){
                rows++;
            }
            else {
                cols--;
            }
        }
        return false;
    }
}
