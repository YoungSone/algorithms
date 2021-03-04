package com.demo08;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8};
        //创建一颗二叉树
        BinarySortTree bst=new BinarySortTree();
        //循环添加
        for (int i : arr) {
            bst.add(new Node(i));
        }
        System.out.println(bst.root.height());
        
       
    }
}
