package lxl.LinkedListTest;

/**
 * Created by lanxiaoli on 2022/9/2.
 */
public class ReverseBetween {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node = new ListNode(3, node);
        node = new ListNode(2, node);
        node = new ListNode(1, node);
        ListNode tmp=node;
        while(tmp!=null){
            System.out.println(tmp.val+" ");
            tmp=tmp.next;
        }
//        System.out.println(node.val + " ");
//        System.out.println(node.next.val);
//        System.out.println(node.next.next.val);
//        Node head = reverse(node);
        ListNode head=reverseBetween1(node,3);
        ListNode tmpReverse=head;
        while(tmpReverse!=null){
            System.out.print(tmpReverse.val+" ");
            tmpReverse=tmpReverse.next;
        }
//        System.out.println(head.val + " ");
//        System.out.println(head.next.val);
//        System.out.println(head.next.next.val);
    }
    public static ListNode reverseBetween1(ListNode head, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - 1; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }


}
