package lxl;

import sun.swing.plaf.windows.ClassicSortArrowIcon;

/**
 * 链表倒叙
 */
public class LinkListReverse {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverse(Node head) {
        //若输入head是null 或者这个链表只有一个元素
        //若输入head是null 或者这个链表只有一个元素,不需要反转
        //null -->null
        //a,null-->a,null
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    //使用递归使链表逆序
    public static Node reverse1(Node head) {
        if (head == null || head.next == null) return head;
        Node node = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        node = new Node(3, node);
        node = new Node(2, node);
        node = new Node(1, node);
        Node tmp=node;
        while(tmp!=null){
            System.out.print(tmp.val+" ");
            tmp=tmp.next;
        }
//        System.out.println(node.val + " ");
//        System.out.println(node.next.val);
//        System.out.println(node.next.next.val);
//        Node head = reverse(node);
        Node head=reverse1(node);
        Node tmpReverse=head;
        while(tmpReverse!=null){
            System.out.print(tmpReverse.val+" ");
            tmpReverse=tmpReverse.next;
        }
//        System.out.println(head.val + " ");
//        System.out.println(head.next.val);
//        System.out.println(head.next.next.val);
    }
}
