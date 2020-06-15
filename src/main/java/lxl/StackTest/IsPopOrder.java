package lxl.StackTest;

import java.util.Stack;

/**
 * Created by lanxiaoli on 2020/6/15.
 * 栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 */
public class IsPopOrder {
    Stack<Integer> stack=new Stack<>();
    public boolean isPopOrder(int[] pushA,int[] popB){
        if(pushA.length==0) return false;
        int index=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popB[index]){
                stack.pop();//弹出栈顶
                index++;//指针后移一位，进行下一轮比较
            }
        }
        return stack.isEmpty();
    }

}
