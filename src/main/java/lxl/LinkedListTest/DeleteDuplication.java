package lxl.LinkedListTest;

import java.util.HashMap;

/**
 * Created by lanxiaoli on 2020/6/9.
 * 1、删除重复的结点，保留一个
 * 2、删除重复的结点，不保留
 */
public class DeleteDuplication {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //删除重复的结点，保留一个
    //map实现,O(n)
    public static ListNode deleteDuplication_1(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode newhead = new ListNode(-1);
        newhead.next=head;
        ListNode pre = newhead;
        ListNode curr = newhead.next;
        while (pre != null && pre.next != null) {
            if (map.containsKey(curr.val)) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                map.put(curr.val, 1);
                pre = curr;
                curr = curr.next;
            }
        }
        return newhead.next;
    }

    //方法二：一次遍历
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    //删除重复的结点，不保留
    // 一：递归实现
    /**
     * @param args
     * 还存在问题，Todo
     */
    public static ListNode deleteDuplication_2(ListNode pHead) {
        // 递归停止条件
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode current = pHead.next;
        // 如果pHead是重复元素
        if (pHead.val == current.val) {
            current = current.next;
            while (current != null && current.val == pHead.val)
                current = current.next;
            pHead = current;
            return deleteDuplication_1(current);
        } else {
            // pHead不是重复元素
            pHead.next = deleteDuplication_1(current);
            return pHead;
        }
    }


    //二：循环实现，对于连续出现的重复数字有效，若重复的数字不是连续出现，无用
    public static ListNode deleteDuplication_4(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                if (pPreNode == null)
                    pHead = pNext;
                else
                    pPreNode.next = pNext;
                pNode = pNext;
            }
        }
        return pHead;
    }

    //方法三：一次遍历
    public static ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode dummy = new ListNode(0, head);

            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int x = cur.next.val;
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }



    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=null;
//        while (node1!=null){
//            System.out.println(node1.val+" ");
//            node1=node1.next;
//        }
       ListNode m=deleteDuplicates(node1);
        while (m!=null){
            System.out.println(m.val+" ");
            m=m.next;
        }
    }
}
