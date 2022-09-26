package lxl.TreeTest;


import java.util.*;

/**
 * Created by lanxiaoli on 2020/6/15.
 * 按之字形顺序打印二叉树
 * 用队列实现层次遍历
 *用一个变量记录奇数层还是偶数层 奇数层插入list后面 偶然数层插入list前面 如果队列不为空就循环取
 */
public class ZigzagLevelOrder {
    class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root){
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null) return res;

        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> list=new ArrayList<>();
            while (count>0){
                BinaryTreeNode node=queue.poll();
                if(i%2==0){
                    list.add(0,node.data);
                }else {
                    list.add(node.data);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
            i++;
        }
        return res;
    }


}
