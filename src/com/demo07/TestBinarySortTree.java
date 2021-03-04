package com.demo07;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr=new int[]{7,5,6,1,33,455,66};
        //创建一颗二叉树
        BinarySortTree bst=new BinarySortTree();
        //循环添加
        for (int i : arr) {
            bst.add(new Node(i));
        }
        //遍历输出二叉排序树
        bst.midShow();
        System.out.println("-------------");
        Node node=bst.search(1);
        System.out.println(node.value);
        System.out.println("--------------");
        bst.delete(7);
        bst.midShow();
    }
}
