package com.demo07;

/**
 * 二叉排序树
 */
public class BinarySortTree {
    Node root;
    //添加
    public void add(Node node){
        //如果是一颗空树
        if (root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    
    //中序遍历二叉树
    public void midShow(){
        if (root!=null){
            root.midShow(root);
        }
    }
    //节点的查找
    public Node search(int value){
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public void delete(int value){
        if (root==null){
            return;
        }else {
            //找到这个节点
            Node target=search(value);
            if (target==null){
                return;
            }
            //找到他的父节点
            Node parent=searchParent(value);
            //1.要删除的节点是叶子节点
            if (target.left==null&&target.right==null){
                //要删除的节点是父节点的左儿子
                if (parent.left.value==value){
                    parent.left=null;
                }else {
                    parent.right=null;
                }
                //2.要删除的节点有两个子节点
            }else if (target.left!=null&&target.right!=null){
                //删除右子树中值最小的节点，并获取到该节点的值
                int min=deleteMin(target.right);
                //替换目标节点的值
                target.value=min;
                
                //3.要删除的节点有一个左节点或一个右节点
            }else {
                //target有左子节点
                if (target.left!=null){
                     //要删除的节点是父节点的左儿子
                    if (parent.left.value==value){
                        //将要删除的节点的父节点的左子节点指向要删除节点的左子节点
                        parent.left=target.left;
                        //要删除的节点是父节点的右儿子
                    }else {
                        parent.right=target.left;
                    }
                    //target有右子节点
                }else {
                      //要删除的节点是父节点的左儿子
                    if (parent.left.value==value){
                        //将要删除的节点的父节点的左子节点指向要删除节点的左子节点
                        parent.left=target.right;
                        //要删除的节点是父节点的右儿子
                    }else {
                        parent.right=target.right;
                    }
                }
            }
        }
    }

    /**
     * 删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target=node;
        //递归向左找
        while (target.left!=null){
            target=target.left;
        }
        //如果这个节点有右节点调用delete方法删除该节点
        delete(target.value);
        return target.value;
    }

    public Node searchParent(int value){
        if (root==null){
            return null;
        }else {
           return root.searchParent(value);
        }
    }
}
