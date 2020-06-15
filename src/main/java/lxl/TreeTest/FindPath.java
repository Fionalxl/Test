package lxl.TreeTest;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lanxiaoli on 2020/6/12.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
 */
public class FindPath {
    class  BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
    public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root,int expectedSum){
        ArrayList<ArrayList<Integer>> pathList=new ArrayList<>();
        if(root==null) return null;
        Stack<Integer> path=new Stack<>();//定义栈来存储一条路径
        findPath(root, expectedSum, path, pathList); //调用查找方法
        return pathList;
    }
    public void  findPath(BinaryTreeNode root,int expectedSum,Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList){
        if(root==null) return;
        ////判断其是不是叶子结点，如果是看其是不是等于期望值，是的话直接添加到ArrayList集合当中
        if(root.left==null&&root.right==null){
            if(root.data==expectedSum){
                ArrayList<Integer> list=new ArrayList<>();
                for(int value:path){ //将路径上的值添加集合中
                    list.add(value);
                }
                list.add(root.data);//将根节点值添加入集合
                pathList.add(list);//将这条路径添加到pathList集合中
            }

        }else {
            //不是叶子结点，前序遍历，将当前结点值放入path栈中
            path.push(root.data);
            findPath(root.left, expectedSum - root.data, path, pathList);
            findPath(root.right, expectedSum - root.data, path, pathList);
            //在返回到父结点之前，在路径上删除当前结点的值
            path.pop();

        }

    }
}
