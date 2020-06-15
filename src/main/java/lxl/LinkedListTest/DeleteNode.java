package lxl.LinkedListTest;

/**
 * Created by lanxiaoli on 2020/6/8.
 * 方法一：o(n)时间内删除链表结点
 * 方法二：o(1)时间内删除链表结点
 */
public class DeleteNode {
    static class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode1(ListNode head, ListNode delNode) {
        if (head == null || delNode == null) {
            return;
        }
        if (head == delNode) { //删除的是头结点
            ListNode pNext = delNode.next;
            delNode.val = pNext.val;
            delNode.next = pNext.next;
            return;
        }
        //利用O(n)的时间复杂度删除结点
        for (ListNode pNode = head; pNode.next != null; pNode = pNode.next) {
            if (pNode.next == delNode) {
                pNode.next = pNode.next.next;
                break;
            }
        }

    }

    //因为从某个链表的结点可以知道链表的下一个结点，故可以把下一结点的内容复制到需要删除的结点上覆盖原有的内容，
    //再把下一个结点删除，就相当于把当前需要删除的结点删除。
    //这是分为三种情况：删除的结点不在链表尾部；链表只有一个结点，删除头结点；链表中有多个结点，删除尾部结点。
    public void deleteNode2(ListNode head, ListNode delNode) {
        if (head == null || delNode == null) return;
        if (delNode.next != null) {//删除的不是尾节点
            ListNode tmp = delNode.next;
            delNode.val= tmp.val;
            delNode.next = tmp.next;
        } else if(head == delNode) {//链表只有一个节点，删除头结点
            head = null;
            delNode=null;
        } else {//链表有多个结点，且删除的是尾结点
            ListNode pNode = head;
            while (pNode.next != delNode) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }

    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode();
//        ListNode ln2 = new ListNode();
//        ListNode ln3 = new ListNode();
//        ListNode ln4 = new ListNode();
//        ListNode ln5 = new ListNode();
//        ListNode ln6 = new ListNode();
//        ListNode ln7 = new ListNode();
//        ListNode ln8 = new ListNode();
        ln1.next = null;
//        ln2.next = ln3;
//        ln3.next = ln4;
//        ln4.next = ln5;
//        ln5.next = ln6;
//        ln6.next = ln7;
//        ln7.next = ln8;
//        ln8.next = null;
        ln1.val = 1;
//        ln2.val = 2;
//        ln3.val = 3;
//        ln4.val = 4;
//        ln5.val = 5;
//        ln6.val = 6;
//        ln7.val = 7;
//        ln8.val = 8;

        DeleteNode m1 = new DeleteNode();
        m1.deleteNode2(ln1, ln1);
//        System.out.println(ln1.val);
        while (ln1 != null) {
            System.out.println(ln1.val);
            ln1 = ln1.next;
        }
    }
}
