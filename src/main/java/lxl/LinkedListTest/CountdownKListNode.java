package lxl.LinkedListTest;

/**
 * Created by lanxiaoli on 2020/6/9.
 * 链表中倒数第k个结点
 * 用两个结点，使第一个结点先到达k-1的结点处，然后再使两个结点一块走，在第一个结点到达链表的尾部，第二个结点所在的位置即为倒数第k个结点的位置。
 */
public class CountdownKListNode {
    static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode countdownKListNode(ListNode head,int k){
        if(head==null||k<0) return null;
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k-1;i++){
            if(fast.next!=null){
                fast=fast.next;
            }else {
                return null;
            }
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }
    public static void main(String[] args){
        ListNode ln1 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        ln1.val = 1;
        ln2.val = 2;
        ln3.val = 3;
        ln4.val = 4;
        ln5.val = 5;
        ln6.val = 6;
        ln7.val = 7;
        ln8.val = 8;
        CountdownKListNode m=new CountdownKListNode();
        System.out.println( m.countdownKListNode(ln1,1).val);

    }

}
