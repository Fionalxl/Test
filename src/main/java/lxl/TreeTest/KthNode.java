package lxl.TreeTest;

import java.util.LinkedList;

/**
 * Created by lanxiaoli on 2020/6/11.
 * 二叉搜索树的第k个结点
 */
public class KthNode {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    public TreeNode kthNode(TreeNode pNode,int k){
        if(pNode==null||k<=0) return null;
        TreeNode curr=pNode;
        int count=0;
        TreeNode kNode=null;//用来保存第k个结点
        LinkedList<TreeNode> stack= new LinkedList<>();
        //中序遍历二叉搜索树
        while (!stack.isEmpty()&&curr!=null){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            if(!stack.isEmpty()){
                curr=stack.pop();
                count++;
                if(count==k){
                    kNode=curr;
                    break;
                }
                curr=curr.right;
            }
        }
        return  kNode;
    }

}
