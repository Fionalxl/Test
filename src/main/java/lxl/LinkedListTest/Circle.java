package lxl.LinkedListTest;

/**
 * Created by lanxiaoli on 2020/6/8.
 * 链表是否有环，链表环的入口，环长度
 */
public class Circle {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            next=null;
        }
    }
    //链表是否有环
    public static boolean hasCircle(ListNode node){
        if(node==null||node.next==null){
            return false;
        }
        ListNode slow=node.next;
        ListNode quick=node.next.next;
        while (quick!=null) {
            if (slow == quick)
                return true;
            slow=slow.next;
            quick=quick.next.next;
        }
        return false;
    }
    //链表环的入口
    public static ListNode listEntrance(ListNode node){
        if(node==null||node.next==null){
            return null;
        }
        ListNode slow=node.next;
        ListNode quick=node.next.next;
        while (quick!=null) {
            if (slow == quick) break;
            slow=slow.next;
            quick=quick.next.next;
        }
        if(quick==null) return null;
        quick=node;
        while (quick!=null){
            if(quick==slow) return slow;
            slow=slow.next;
            quick=quick.next;
        }
        return null;
    }
    //环长度
    public static int listLength(ListNode node){
        ListNode p=listEntrance(node);
        if(p==null) return 0;
        ListNode q=p.next;
        int length=1;
        while (p!=q){
            length++;
            q=q.next;
        }
        return length;
    }

}
