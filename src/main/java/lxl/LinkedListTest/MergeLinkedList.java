package lxl.LinkedListTest;

/**
 * Created by lanxiaoli on 2020/6/9.
 * 合并两个排序的链表
 */
public class MergeLinkedList {
    static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode mergeLinkedList(ListNode head1,ListNode head2){
        if(head1==null&&head2==null) return  null;
        if(head1==null&&head2!=null) return head2;
        if(head1!=null&&head2==null) return head1;
        ListNode newHead=null;
        if(head1.val>head2.val){
            newHead=head2;
            head2=head2.next;
            newHead.next=mergeLinkedList(head1,head2);
        }else {
            newHead=head1;
            head1=head1.next;
            newHead.next=mergeLinkedList(head1,head2);
        }
        return newHead;
    }

}
