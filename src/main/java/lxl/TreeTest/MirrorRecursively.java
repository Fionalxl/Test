package lxl.TreeTest;

/**
 * Created by lanxiaoli on 2020/6/10.
 * 二叉树镜像
 */
public class MirrorRecursively {
    class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    //递归方法
    public void mirrorRecursively(BinaryTreeNode pNode){
        if(pNode==null) return;
        if(pNode.left==null||pNode.right==null) return;
        BinaryTreeNode tmpNode=pNode.left;//交换左右结点
        pNode.left=pNode.right;
        pNode.right=tmpNode;
        while (pNode.left!=null){
            mirrorRecursively(pNode.left);
        }
        while (pNode.right!=null){
            mirrorRecursively(pNode.right);
        }
    }


}
