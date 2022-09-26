package lxl.SortAndFind;

import java.util.Arrays;

/**
 * Created by lanxiaoli on 2020/6/17.
 * 调整数组顺序使奇数位于偶数前面
 * 维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动；第二个指针初始化时指向数组的最后一个数字，它指向前移动。
 * 在两个指针相遇之前，第一个指针总是位于第二个指针的前面。如果第一个指针的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换两个数字。
 */
public class RecorderOddEven {
    public static int[] recorderOddEven(int[] array){
        if(array==null||array.length<=0){
            return null;
        }
        int begin=0;
        int end=array.length-1;
        while (begin<end){
            while (!isEven(array[begin])&&begin<end){ //向后指针，直到指向偶数
                begin++;
            }
            while (isEven(array[end])&&begin<end){////向前指针，直到指向奇数
                end--;
            }
            if(begin<end){
                int tmp=array[end];
                array[end]=array[begin];
                array[begin]=tmp;
            }
        }
        return array;

    }
    public static  boolean isEven(int num){
        if(num%2==0) return true;
        return false;
    }
    public static void main(String[] args){
        int[] a={4,3,4,2,5,2,5};
        System.out.println(Arrays.toString(recorderOddEven(a)));

    }
}
