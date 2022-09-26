package lxl.LinkedListTest;

import java.util.Stack;

/**
 * 链表倒叙（反转链表）
 */
public class Reverse {
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
   //遍历方法,会改变链表的结构
    public static Node reverse(Node head) {
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
        //递归传入下一个节点，目的是为了到达最后一个节点
        Node node = reverse1(head.next);
         /*
            以链表1->2->3->4->5举例
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head;
        head.next = null;
        return node;
    }

    //使用栈实现反转
    public static Node reverse2(Node head){
        Stack<Node> stack = new Stack<>();
        Node start = new Node(0, new Node(0));
        Node temp = start;
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return start.next;
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
        Node head=reverse2(node);
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
