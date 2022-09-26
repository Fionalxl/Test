package lxl.StackTest;

import java.util.Stack;

/**
 * Created by lanxiaoli on 2022/7/8.
 * 包含min函数的栈
 */
public class GetMin {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public GetMin(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>x)
            stack2.push(x);
        else
            stack2.push(stack2.peek());
    }

    public void pop(){
        stack1.pop();
        stack2.pop();
    }

    public int top(){
        return stack1.peek();
    }

    public int getMin(){
        return stack2.peek();
    }
    public static void main(String[] args) {
        GetMin obj = new GetMin();
        obj.push(-1);
        obj.push(3);
        obj.push(-4);
        obj.push(0);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3+ " "+param_4);
    }
}
