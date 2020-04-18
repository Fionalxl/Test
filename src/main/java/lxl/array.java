package lxl;
import java.util.* ;
/**
 * Created by lanxiaoli on 2018/8/30.
 */
public class array {
    public static void main(String args[]) throws Exception {
        int array[] = {2, 5, -2, 6, -3, 8, 0, -7, -9, 4};
        Arrays.sort(array);
        for(int i=0;i<10;i++){
            System.out.print(array[i]+" ");
        }
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");
    }
}