package com.demo1;

public class Node {
    
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
    
    //为节点追加节点
    public void add(Node node){
        Node currentNode=this;
        while (true){
            Node nextNode=currentNode.next;
            if (nextNode==null){
                break;
            }
            currentNode=nextNode;
        }
        //把需要追加的节点追加到找到的当前节点的下一个节点
        currentNode.next=node;
       
    }
    
    //获取下一个节点
    public Node next(){
        return this.next;
    }
}
