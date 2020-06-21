package lxl.Others;

import java.util.ArrayList;

/**
 * Created by lanxiaoli on 2020/6/17.
 * 顺时针打印矩阵
 */
public class PrintMatrixClockwisely {
    public ArrayList<Integer> printMatrixClockwisely(int[][] nums){
        ArrayList<Integer> list=new ArrayList<>();
        int row=nums.length;
        int col=nums[0].length;
        if(nums==null||row<=0||col<=0){
            return null;
        }
        int start=0;
        while (col>start*2&&row>start*2){
            printMatrixInCircle(list,nums,col,row,start);
            ++start;
        }
        return list;
    }
    private void printMatrixInCircle(ArrayList<Integer> list, int[][] nums,
                                     int cols, int rows, int start){
        int EndX=cols-1-start;
        int EndY=rows-1-start;
        //从左到右打印一行
        for(int i=start;i<=EndX;i++){
            int number=nums[start][i];
            list.add(number);
        }
        //从上到下打印一行
        if(start<EndY) {
            for (int i=start+1;i<=EndY;i++){
                int number=nums[i][EndX];
                list.add(number);
            }
        }
        //从右到左打印一行
        if(start<EndX&&start<EndY){
            for(int i=EndX-1;i>=start;i--){
                int number=nums[EndY][i];
                list.add(number);
            }
        }
        //从下到上打印一行
        if(start<EndX&&start<EndY-1){
            for(int i=EndY-1;i>=start+1;i--){
                int number=nums[i][start];
                list.add(number);
            }
        }
    }

}
