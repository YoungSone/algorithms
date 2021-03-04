package com.demo03;

public class TestBinaryTree {
    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binTree=new BinaryTree();
        //创建一个根节点
        TreeNode root=new TreeNode(1);
        //把根节点赋给树
        binTree.setRoot(root);
        //在创建两个左节点和右节点组成二叉树
        TreeNode rootLeftNode=new TreeNode(2);
        TreeNode rootRightNode=new TreeNode(3);
        root.setLeftChild(rootLeftNode);
        root.setRightChild(rootRightNode);
        //为左节点添加子节点
        rootLeftNode.setLeftChild(new TreeNode(4));
        rootLeftNode.setRightChild(new TreeNode(5));
        //为右节点添加子节点
        rootRightNode.setLeftChild(new TreeNode(6));
        rootRightNode.setRightChild(new TreeNode(7));
        //前序遍历
        binTree.frontShow();
        //中序遍历
        binTree.midShow();
        //后序遍历
        binTree.backShow();
        System.out.println("--------------------");
        TreeNode result=binTree.frontSearch(6);
        System.out.println(result.value);
        System.out.println("-----------------");
        //删除节点
        binTree.delete(5);
        binTree.frontShow();
    }
}
