package lxl.TreeTest;

/**
 * Created by lanxiaoli on 2020/6/11.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    class BinarTreeNode{
        int data;
        BinarTreeNode left;
        BinarTreeNode right;
    }
    public boolean verifySquenceOfBST(int sequence[]) {
        if(sequence == null){
            return false;
        }
        return verifySquenceOfBST1(sequence, 0, sequence.length - 1);
    }
    public boolean verifySquenceOfBST1(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end]; //后序遍历的最后一个结点为根结点

        //在二叉搜索树中左子树的结点小于根结点
        int i = 0;
        for (; i < end; ++i) {
            if (sequence[i] > root) {
                break;
            }
        }
        //在二叉搜索树中右子树的结点大于根结点
        int j = i;
        for (; j < end; ++j) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //判断左子树是不是二叉树
        boolean left = true;
        if (i > start) {
            left = verifySquenceOfBST1(sequence, start, i - 1);
        }
        //判断右子树是不是二叉树
        boolean right = true;
        if (i < end) {
            right = verifySquenceOfBST1(sequence, i, end - 1);
        }
        return (left && right);
    }

}
