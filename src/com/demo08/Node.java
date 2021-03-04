package com.demo08;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查询高度
     * @return
     */
    public int height(){
        
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }

    /**
     * 左子树高度
     * @return
     */
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }

    /**
     * 右子树高度
     * @return
     */
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
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
        //检查是否为平衡二叉树 单旋转
        //进行右旋转
        if((leftHeight()-rightHeight())>=2){
            //双旋转
            if (left!=null&&left.leftHeight()<left.rightHeight()){
                left.leftRotate();
                rightRotate();
                //单旋转
            }else {
                rightRotate();
            }
            
           
        }
        //左旋转
        if((leftHeight()-rightHeight())<=-2){
            if (right!=null&&right.rightHeight()<right.leftHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                 leftRotate();
            }
           
            
        }
    }

    /**
     * 左旋转
     */
    public void  leftRotate(){
//        1.创建一个新节点，值等于当前节点的值
        Node newLeft=new Node(this.value);
//        2.把新节点的左子树设置为当前节点的左子树
        newLeft.left=this.left;
//        3.把新节点的右子树设置为当前节点的右子树的左子树
        newLeft.right=this.right.left;
//        4.把当前节点的值换为右子节点的值
        this.value=this.right.value;
//        5.把当前节点的右子树设置为右子树的右子树
        this.right=this.right.right;
//        6把当前节点的左子树设置为新节点
        this.left=newLeft;
    }
    
    
    /**
     * 右旋转
     */
    public void rightRotate(){
//       	1.创建一个新节点，值等于当前节点的值
        Node newRight=new Node(this.value);
//        2.把新节点的右子树设置为当前节点的右子树
        newRight.right=this.right;
//        3.把新节点的左子树设置为当前节点的左子树的右子树
        newRight.left=this.left.right;
//        4.把当前节点的值换为左子节点的值
        this.value=this.left.value;
//        5.把当前节点的左子树设置为左子树的左子树
        this.left=this.left.left;
//        6把当前节点的右子树设置为新节点
        this.right=newRight;
        
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
