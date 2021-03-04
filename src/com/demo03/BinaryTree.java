package com.demo03;

//二叉树
public class BinaryTree {
    TreeNode root;

    //设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    //获取根节点
    public TreeNode getRoot() {
        return root;
    }
    //前序遍历
    public void frontShow(){
        if (root!=null){
             root.frontShow();
        }
       
    }
    
    //中序遍历
    public void midShow(){
        if (root!=null){
            root.midShow();
        }
        
    }
    //前序遍历
    public void backShow(){
        if (root!=null){
            root.backShow();
        }
    }

    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if (root.value==i){
            root=null;
        }else {
            root.delete(i);
        }
    }
}
