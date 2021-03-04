package com.demo05;


import com.demo1.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
    public static void main(String[] args) {
        int[] arr=new int[]{3,29,7,8,11,14,23,5};
        TreeNode node=createHuffmanTree(arr);
    }
    //创建赫夫曼树
    public static TreeNode createHuffmanTree(int[] arr){
        //先使用数组中所有的元素创建若干二叉树，（只有一个结点）
        List<TreeNode> nodes=new ArrayList<>();
        for (int value : arr) {
            nodes.add(new TreeNode(value));
        }
        //循环处理
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树
            TreeNode left=nodes.get(0);
            TreeNode right=nodes.get(1);
            //创建一颗新的二叉树
            TreeNode parent=new TreeNode(left.value+right.value);
            parent.left=left;
            parent.right=right;
            //把取出来的二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树聚合中
            nodes.add(parent);
        }
        System.out.println(nodes);
        return nodes.get(0);
    }
}
