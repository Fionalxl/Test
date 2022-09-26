package lxl.StackTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lanxiaoli on 2020/6/15.
 * 1、用两个栈实现队列
 * 实现队列添加元素：当添加元素时，由stack1负责接收添加的元素。
 * 实现队列删除元素：首先需要分析stack2中不为空时，在stack2中的栈顶元素是最先进入队列的元素，可以弹出。
 * 如果stack2为空时，我们把stack1中的元素逐个弹出并压入stack2。由于先进入队列的元素被压到stack1的底端，经过弹出和压入之后就处于stack2的顶端了，又可以直接弹出。
 * 2、用两个队列实现栈
 * 模拟栈的入栈操作：如果两个队列都为空，优先选择队列1添加元素，否则，哪个队列有元素，就在哪个队列尾部追加元素。
 * 模拟栈的出栈操作：如果两个队列都为空，抛出异常；否则，模拟栈的出栈规则，后进先出，即将其中一个不为空的队列的前n-1个元素从当前队列删除，添加入另一个队列中，再把此队列剩余的最后一个元素删除。故模拟栈的出栈操作。
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
