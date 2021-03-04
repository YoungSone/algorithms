package com.demo03;


public class TreeNode {
    //节点值 权
    int value;
    //左儿子
    TreeNode leftChild;
    TreeNode rightChild;
    
    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    //前序遍历
    public void frontShow(){
        //先打印当前节点的内容
        System.out.println(value);
        //左节点
        if (leftChild!=null){
            leftChild.frontShow();
        }
        //右节点
        if (rightChild!=null){
            rightChild.frontShow();
        }
    }
    
    //中序遍历
    public void midShow(){
        //先打印左节点
        if (leftChild!=null){
            leftChild.midShow();
        }
        //再打印当前节点内容
        System.out.println(value);
        //最后打印右节点内容
        if (rightChild!=null){
            rightChild.midShow();
        }
    }
    
    //后序遍历
    public void backShow(){
        //先打印左节点
        if (leftChild!=null){
            leftChild.backShow();
        }
        //在打印右节点
        if (rightChild!=null){
            rightChild.backShow();
        }
        //最后打印当前节点内容
        System.out.println(value);
    }
    //前序查找
    public TreeNode frontSearch(int i) {
        TreeNode target= null;
        if (this.value==i){
            return this;
        }else if (leftChild!=null){
            target=leftChild.frontSearch(i);
            if (target!=null){
                return target;
            }else if (rightChild!=null){
                target=rightChild.frontSearch(i);
            }
        }
        return target;
    }


    //删除一个子树
    public void delete(int i) {
        TreeNode parent=this;
        //判断左儿子
        if (parent.leftChild!=null&&parent.leftChild.value==i){
            parent.leftChild=null;
            return;
        }
        //判断右儿子
        if (parent.rightChild!=null&&parent.rightChild.value==i){
            parent.rightChild=null;
            return;
        }
        //都找不到 将左儿子作为父节点找左儿子树
        parent=leftChild;
        if (parent!=null){
            parent.delete(i);
        }
         //都找不到 将右儿子作为父节点找右儿子树
        parent=rightChild;
        if (parent!=null){
            parent.delete(i);
        }
    }
}
