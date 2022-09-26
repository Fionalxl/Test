package lxl.LinkedListTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lanxiaoli on 2020/6/8.
 * 寻找两个相交链表的第一个公共节点
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

    /**
     * 方法一：
     * 1、分别读取两个链表长度，然后用两个指针分别指向两个链表
     * 2、长的先走lenMax-lenMin步，元素相等时，则找到第一个相交节点
     * 需要遍历两次(两个链表 + 一次寻找)
     */
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
    /**
     * 方法二：
     * 1、长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回NULL
     * 2、长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点；没有公共，一起到结尾NULL。
     * 时间复杂度O(m+n)。
     */
    public static ListNode findFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }

        return p1;

    }


    /**方法三：哈希集合
     * 判断两个链表是否相交，可以使用哈希集合存储链表节点。
     首先遍历链表 headA，并将链表headA 中的每个节点加入哈希集合中。然后遍历链表 headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
     如果当前节点不在哈希集合中，则继续遍历下一个节点；
     如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在两个链表的相交部分，因此在链表headB 中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回该节点。
     如果链表headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回null。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
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
//           System.out.println("link common node: " + findFirstCommonNode(head1, head2));

//        // 链表相交
        System.out.println("link common node: " + findFirstCommonNodeII(head1, head2));


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
