package com.demo04;

import com.demo04.TreeNode;

//二叉树
public class BinaryTree {
    TreeNode root;
    
    //用于临时存储前驱节点
    TreeNode pre=null;

    //设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    //获取根节点
    public TreeNode getRoot() {
        return root;
    }
  
    //遍历线索二叉树
    public void treeTterate(){
        //用于临时存储当前遍历节点
        TreeNode node=root;
        while (node!=null){
            //循环找到最开始的节点
            while (node.leftType==0){
                node=node.leftChild;
            }
            //打印当前节点的值
            System.out.println(node.value);
            //如果当前节点的右指针指向的是后继节点，可能后继节点还有后继结点
            while (node.rightType==1){
                node=node.rightChild;
                System.out.println(node.value);
            }
            //替换遍历的节点
            node=node.rightChild;
        }
    }
    
    
    
    //中序线索化二叉树
     public void threadNodes(){
        threadNodes(root);
    }
    
    
    public void threadNodes(TreeNode node){
        //当前节点为null,直接返回
        if (node==null){
            return;
        }
        //处理左子树
        threadNodes(node.leftChild);
        //处理前驱节点
        if (node.leftChild==null){
            //让当前节点的左指针指向前驱节点
            node.leftChild=pre;
            //改变当前节点左指针的类型
            node.leftType=1;
        }
        //处理前驱节点的右指针，如果前驱节点的右指针为null(没有指向右子树)
        if (pre!=null&&pre.rightChild==null){
            //让前驱节点的右指针指向当前节点
            pre.rightChild=node;
            //改变前驱节点的右指针类型
            pre.rightType=1;
        }
        pre=node;
        //处理右子树
        threadNodes(node.rightChild);
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
