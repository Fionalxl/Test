package lxl.TreeTest;

/**
 * Created by lanxiaoli on 2020/6/12.
 *输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class DoseTreeAHaveTreeB {
    class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public boolean doseTreeAHaveTreeB(BinaryTreeNode root1,BinaryTreeNode root2){
        if(root1==null||root2==null) return false;
        boolean res=isEqual(root1,root2);
        if(res){
            return true;
        }else {
            return doseTreeAHaveTreeB(root1.left,root2)||doseTreeAHaveTreeB(root1.right,root2);
        }
    }
    public  boolean isEqual(BinaryTreeNode root1,BinaryTreeNode root2){
        //检查到了B的末尾
        if(root2==null)  return true;
        //如果在检查完B之前A到了底
        if(root1==null) return false;
        if(root1.data==root2.data){
            return isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right);
        }else {
            return false;
        }
    }
}
