package lxl.Others;

/**
 * Created by lanxiaoli on 2022/8/22.
 * 一、输入字符串"I am a student."，则输出"student. a am I"。
 * 二、左旋字符串
 */
public class ReverseString {
    //输入字符串"I am a student."，则输出"student. a am I"。
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return str;
        if (str.trim().length() == 0)
            return str;
        StringBuilder sb = new StringBuilder();
        String re = reverse(str);
        String[] s = re.split(" ");
        for (int i = 0; i < s.length - 1; i++) {
            sb.append(reverse(s[i]) + " ");
        }
        sb.append(reverse(s[s.length-1]));
        return String.valueOf(sb);
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }
    public static void main(String[] args){
        ReverseString reverseString=new ReverseString();
        String sb=reverseString.ReverseSentence("you to yi pp");
        System.out.println(sb);
        System.out.println(reverseString.LeftRotateString("ADDDFF",2));
    }

   //左旋字符串
    public String LeftRotateString(String str,int n) {
        if (str == null || n < 0 || n > str.length()) return null;
        StringBuilder sb = new StringBuilder(str);
        sb.append(sb.substring(0, n));
        return sb.substring(n, sb.length());
    }

}
