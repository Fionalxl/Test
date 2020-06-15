package lxl.TreeTest;

/**
 * Created by lanxiaoli on 2020/6/11.
 * 重建二叉树
 */
public class RebuildBinaryTree {
    class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int data){
            this.data=data;
        }
    }
    //由前序遍历和中序遍历重建二叉树
    public BinaryTreeNode rebuildBinaryTree_1(int preorder[], int inorder[]){
        if (preorder == null || inorder == null) { //如果前序或者中序有一个是空直接返回
            return null;
        }
        // 定义构建二叉树的核心算法
        BinaryTreeNode root = rebuildBinaryTreeCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return root;

    }

    // 构建二叉树的核心算法
    public BinaryTreeNode rebuildBinaryTreeCore(int preorder[], int startPreorder,
                                          int endPreorder, int inorder[], int startInorder, int endInorder) {
        if (startPreorder > endPreorder || startInorder > endInorder) { //停止递归的条件
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[startPreorder]);
        for (int i = startInorder; i <= endInorder; i++) {
            if (preorder[startPreorder] == inorder[i]) {
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                //左子树
                root.left = rebuildBinaryTreeCore(preorder, startPreorder + 1,
                        startPreorder + (i - startInorder), inorder,
                        startInorder, i - 1);
                //右子树
                root.right = rebuildBinaryTreeCore(preorder, (i - startInorder)
                                + startPreorder + 1, endPreorder, inorder, i + 1,
                        endInorder);

            }
        }
        return root;

    }
    //由后序遍历和中序遍历重建二叉树
    public BinaryTreeNode rebuildBinaryTree_2(int postorder[], int inorder[]){

        if (postorder == null || inorder == null) {
            return null;
        }
        BinaryTreeNode root = rebuildBinaryTreeCore_2(postorder, 0,
                postorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
    // 构建二叉树的核心算法
    public  BinaryTreeNode rebuildBinaryTreeCore_2(int[] postorder,
                                                 int startPostorder, int endPostorder, int[] inorder,
                                                 int startInorder, int endInorder) {

        if (startPostorder > endPostorder || startInorder > endInorder) { // 终止递归的条件
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(postorder[endPostorder]);
        for (int i = startInorder; i <= endInorder; i++) {
            if (inorder[i] == postorder[endPostorder]) {
                root.left = rebuildBinaryTreeCore_2(postorder, startPostorder,
                        startPostorder - 1 + (i - startInorder), inorder,
                        startInorder, i - 1);
                root.right = rebuildBinaryTreeCore_2(postorder, startPostorder
                                + (i - startInorder), endPostorder - 1, inorder, i + 1,
                        endInorder);
            }
        }
        return root;
    }


}
