package lxl.DIDI;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;

/**
 * Created by lanxiaoli on 2022/8/10.
 */
public class Maxstring {
//    public String lengthOfString(String s){
//        int max=0;int start=0;
//        int[] index = new int[2];
//        HashMap<Character,Integer> map=new HashMap<>();
//        for(int end=0;end<s.length();end++){
//            char ch=s.charAt(end);
//            if(map.containsKey(ch)){
//                start=Math.max(map.get(ch)+1,start);
//            }
//            if (end-start+1 > max){
//                index[0] = start;
//                index[1] = end;
//                max = end-start+1;
//            }
//            map.put(ch,end);
//        }
//        return s.substring(index[0], index[1] + 1);
//    }


    public static String reversOfString(String str){

        if (str.isEmpty()) {
            return str;
        }
        char[] seq = str.toCharArray();
        int length = seq.length;
        // 定义两个指针记录要反转单词的起始位置
        int start = 0;
        int end = 0;
        // 这里一定要含有等于，因为要判断是否是最后一个单词，从而可以处理最后一个单词
        while (end <= length) {
            // 当已经遍历到字符串的最后一个字符，或者当前字符是空格时
            // 则对空格前的单词进行反转，即"am"反转为"ma"
            // 一定要把判断是否是结尾放在前面，否则seq[end]会报错，因为数组的有效索引是从0开始的
            // 反转后修改单词的起始指针为空格的下一个字符
            // 如果不符合条件，则移动指针继续判断下一个字符
            if (end == length || seq[end] == ' ') {
                Revese(seq, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        // 反转这个数组
        Revese(seq, 0, length - 1);
        return new String(seq);

    }
    public static void  Revese(char[] arr,int start,int end){
        if(arr==null||start<0||end>arr.length-1){
            return  ;
        }
        while(start<end){
            char temp=arr[start];
            arr[start]=arr[end];
            arr[temp]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {;
        String result = reversOfString("i am a student.");
        System.out.println(result);
    }



}
