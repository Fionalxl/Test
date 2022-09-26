package lxl;

/**
 * Created by lanxiaoli on 2022/4/20.
 */
public class CharTest {
    public static void main(String[] args) {
        char ch = '\u9999';
        System.out.println(ch);
        char zhong = '疯';
        int zhongw=zhong;
        System.out.println(zhongw);
        char c=97;
        System.out.println(c);
        for(int i=0;i<3;i++){
            System.out.println(i);
            if(i==1){
                return;
            }
            System.out.println("1111");
        }
    }

}
