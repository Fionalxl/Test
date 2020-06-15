package lxl.TreeTest;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if(root==null) return null;
        List<List<Integer>> res=new VirtualFlow.ArrayLinkedList<>();
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
