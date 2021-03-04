package com.demo1;

public class NodeDemo01 {
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        node1.add(node2);
        node2.add(node3);
        System.out.println(node1.next().data);
        
    }
}
