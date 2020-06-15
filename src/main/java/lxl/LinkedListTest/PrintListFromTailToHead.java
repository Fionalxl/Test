package lxl.LinkedListTest;

import java.util.ArrayList;

/**
 * Created by lanxiaoli on 2020/6/10.
 * 从尾到头打印链表
 */
public class PrintListFromTailToHead {
   static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode head){
        if(head!=null){
            printListFromTailToHead(head.next);
            list.add(head.val);
        }
        return list;
    }
    public static void main(String[] args){
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(2);
        ListNode list3=new ListNode(3);
        list1.next=list2;
        list2.next=list3;
        list3.next=null;

        PrintListFromTailToHead solution=new PrintListFromTailToHead();
        ArrayList<Integer> list = solution.printListFromTailToHead(list1);
        list.forEach(item->{
            System.out.println(String.valueOf(item));
        });
    }

}
