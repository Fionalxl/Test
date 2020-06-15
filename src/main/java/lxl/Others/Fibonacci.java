package lxl.Others;

/**
 * Created by lanxiaoli on 2020/6/15.
 * 斐波那契数列
 * 1、递归方法（重复计算太多）
 * 2、从下往上计算，使用循环
 */
public class Fibonacci {
    //递归方法
    public int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    //从下往上计算，使用循环
    public int fibonacci1(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int first=0;
        int second=1;
        int fib=0;
        for(int i=2;i<=n;i++){
            fib=first+second;
            first=second;
            second=fib;
        }
        return fib;
    }

}
