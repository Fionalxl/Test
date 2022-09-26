package lxl.Others;

/**
 * Created by lanxiaoli on 2022/4/22.
 * 求两个整数和，不用四则运算符
 */
public class AddTest {
    public int add(int num1,int num2){
        int sum,carry;
        do{
            sum=num1^num2;
            carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
        }while(num2!=0);
        return num1;
    }
    public static void main(String[] args){
        AddTest addTest=new AddTest();
        System.out.print( addTest.add(3,4));
    }
}
