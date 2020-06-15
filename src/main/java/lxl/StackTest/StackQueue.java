package lxl.StackTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lanxiaoli on 2020/6/15.
 * 1、用两个栈实现队列
 * 2、用两个队列实现栈
 */
public class StackQueue {
    //用两个栈实现队列
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public void appendTail(int item){
        stack1.push(item);
    }
    public int deleteHead(){
        while (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push (stack1.pop());
        }
        return stack2.pop();
    }


    //用两个队列实现栈
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();
    public void push(int item){
        if(queue1.isEmpty()&&queue2.isEmpty()){
            queue1.add(item);
            return;
        }
        if(queue1.isEmpty()){
            queue2.add(item);
            return;
        }
        if(queue2.isEmpty()){
            queue1.add(item);
            return;
        }
    }
    public int pop(){
        if(queue1.isEmpty()&&queue2.isEmpty()){
            try {
                throw new Exception("栈为空");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        if(queue2.isEmpty()){
            while (queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return 0;
    }
}
