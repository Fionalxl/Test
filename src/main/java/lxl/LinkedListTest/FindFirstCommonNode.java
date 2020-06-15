package lxl.LinkedListTest;

/**
 * Created by lanxiaoli on 2020/6/8.
 * 寻找两个相交链表的第一个公共节点
 * 思路：
 * 1、分别读取两个链表长度，然后用两个指针分别指向两个链表
 * 2、长的先走lenMax-lenMin步，元素相等时，则找到第一个相交节点
 */
public class FindFirstCommonNode {
   static class ListNode {
       int val;
       ListNode next;

       ListNode(int val) {
           this.val = val;
       }
       @Override
       public String toString() {
           if (this.next == null) {
               return String.valueOf(this.val);
           }
           return this.val + "->" + this.next.toString();
       }

   }

       public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
           if (head1 == null || head1 == null)
               return null;
           int length1 = 0;
           int length2 = 0;
           ListNode tmpHead1 = head1;
           while (tmpHead1 != null) {
               length1++;
               tmpHead1 = tmpHead1.next;
           }
           ListNode tmpHead2 = head2;
           while (tmpHead2 != null) {
               length2++;
               tmpHead2 = tmpHead2.next;
           }
           ListNode fast = null;
           ListNode slow = null;
           int num = 0;
           if (length1 > length2) {
               fast = head1;
               slow = head2;
               num = length1 - length2;
           } else {
               fast = head2;
               slow = head1;
               num = length2 - length1;
           }
           //fast先走num步
           for (int i = 0; i < num; i++) {
               fast = fast.next;
           }
           while (fast != null && slow != null) {
               if (fast == slow) {
                   return fast;
               }
               fast = fast.next;
               slow = slow.next;
           }
           return null;
       }


       public static void main(String args[]) {

           ListNode node1 = new ListNode(11);
           ListNode node2 = new ListNode(12);
           node1.next = node2;

           ListNode head1 = createTestLinkedList(7, node1);
           ListNode head2 = createTestLinkedList(8, node1);


           // 链表相交
           System.out.println("link common node: " + findFirstCommonNode(head1, head2));

//        // 链表相交
//        System.out.println("link common node: " + findFirstCommonNodeII(head1, head2));
//
//        // 链表相交
//        System.out.println("link common node: " + findFirstCommonNodeIII(head1, head2));


       }

       private static ListNode createTestLinkedList(int n, ListNode addNode) {
           ListNode head = new ListNode(0);
           ListNode curNode = head;
           for (int i = 1; i < n; i++) {
               curNode.next = new ListNode(i);
               curNode = curNode.next;
           }
           curNode.next = addNode;
           return head;
       }
   }
