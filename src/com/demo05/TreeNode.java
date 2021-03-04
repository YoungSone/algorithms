package com.demo05;

public class TreeNode implements Comparable<TreeNode>{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(TreeNode o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
