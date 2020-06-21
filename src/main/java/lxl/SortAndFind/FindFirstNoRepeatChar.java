package lxl.SortAndFind;

import java.util.HashMap;

/**
 * Created by lanxiaoli on 2020/6/17.
 * 第一个只出现一次的字符
 */
public class FindFirstNoRepeatChar {
    public static  Character findFirstNoRepeatChar(String str){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        str=str.toLowerCase();
        int len=str.length();
        int count=0;
        if(str.length()==0||str==null){
            return '0';
        }
        for(int i=0;i<len;i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                count=hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i),++count);
            }else {
                hashMap.put(str.charAt(i),1);
        }
        }
        for(int i=0;i<len;i++){
            if(hashMap.get(str.charAt(i))==1){
                return str.charAt(i);
            }
        }
        return '0';

    }
    public static void main(String[] args){
        char c=findFirstNoRepeatChar("abbbbceddd");
        System.out.println(c);
    }
}
