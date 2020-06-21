package lxl.Others;

/**
 * Created by lanxiaoli on 2020/4/19.
 * 二进制中1的个数
 */
public class binaryTest {
    public static void main(String args[]){
        binaryTest binaryTest=new binaryTest();
        int count= binaryTest.numberOf1(9);
        System.out.print(count);

    }
    private  int numberOf1(int n){
        int count=0;
        if(n!=0){
            count++;
            n=(n-1)&n;
        }

        return count;

    }

}
