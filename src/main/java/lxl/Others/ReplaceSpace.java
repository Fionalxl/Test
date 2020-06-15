package lxl.Others;

/**
 * Created by lanxiaoli on 2020/6/15.
 * 替换空格
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str){
        int num=0;
        int j=str.length()-1;
        for(int i=0;i<j;i++){
            if(str.charAt(i)==' '){
                num++;
            }
        }
        StringBuffer newStr=new StringBuffer();
        int newLength=str.length()+2*num;
        int i=newLength-1;
        str.setLength(newLength);
        while (i >= 0 && j >= 0 && i>=j){
            if(str.charAt(j) == ' ') {
                str.setCharAt(i--, '0');
                str.setCharAt(i--, '2');
                str.setCharAt(i--, '%');
            }else {
                str.setCharAt(i--, str.charAt(j));
            }
            j--;
        }
        return str.toString();
    }

}
