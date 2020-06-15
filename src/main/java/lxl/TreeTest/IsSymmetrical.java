package lxl.TreeTest;

/**
 * Created by lanxiaoli on 2020/6/11.
 * 判断一个二叉树是对称的
 */
public class IsSymmetrical {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    public boolean isSymmetrical(TreeNode pNode){
        if(pNode==null) return true;
        return isSymmetrical(pNode.left,pNode.right);
    }
    public boolean isSymmetrical(TreeNode node1,TreeNode node2){
        if(node1==null){
            if(node2==null){
                return true;
            }else {
                return false;
            }
        }
        if(node2==null) return false;
        if(node1.data!=node2.data) return false;
        return isSymmetrical(node1.left,node2.right)&&isSymmetrical(node1.right,node2.left);
    }

}
