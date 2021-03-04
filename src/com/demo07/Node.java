package com.demo07;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 向子树添加节点
     * @param node
     */
    public void add(Node node){
        if (node==null){
            return;
        }
        //判断传入的节点值比当前子树的根节点值大小
        if (node.value<this.value){
            //如果左节点为空
            if (this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            //如果右节点为空
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midShow(Node node) {
        if (node==null){
            return;
        }
        if (node.left!=null){
            midShow(node.left);
        }
        System.out.println(node.value);
        if (node.right!=null){
           midShow(node.right);
        }
    }


    /**
     * 查找节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value==value){
            return this;
        }else if (value<this.value){
            if (left==null){
                return null;
            }else {
                return left.search(value);
            }
        }else {
            if (right==null){
                return null;
            }else {
                return right.search(value);
            }
        }
    }

    /**
     * 从根节点开始搜索值位value的节点父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            if (this.value>value&&this.left!=null){
                return this.left.searchParent(value);
            }else if (this.value<value&&this.right!=null){
                return this.right.searchParent(value);
            }
            return null;
        }
        
    }
}
