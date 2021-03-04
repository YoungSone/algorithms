package com.demo10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * 图
 */
public class Graph {
    private Vertex[] vertex;//顶点数组
    private int currentSize;//位置
    private int[][] adjMat;//邻接矩阵
    private Stack<Integer> stack=new Stack<>();//存储栈 深度优先
    private Queue<Integer> queue=new ArrayDeque<>();//存储队列，广度优先
    //当前遍历的下标
    private int currentIndex=0;
    
    
    public Graph(int size){
        vertex=new Vertex[size];
        adjMat=new int[size][size];
        setOne(adjMat);
    }

    //处理图顶点自联结
    public void  setOne(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i==j){
                    arr[i][j]=1;
                }
            }
        }
    }
    
    /**
     * 向图中加入一个顶点
     * @param v
     */
    public void addVertex(Vertex v){
        vertex[currentSize++]=v;
    } 
    //添加两个顶点关系
    public void addEdge(String v1,String v2){
        //找出两个顶点下标
        int index1=0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v1)){
                index1=i;
                break;
            }
        }
        int index2=0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v2)){
                index2=i;
                break;
            }
        }
        adjMat[index1][index2]=1;
        adjMat[index2][index1]=1;
    }

    public int[][] getAdjMat() {
        return adjMat;
    }

    /**
     * 广度优先搜索算法遍历图
     */
    public void bfs(){
        //把第0个顶点标记为已访问状态
        vertex[0].visited=true;
        //把第0个顶点的下标存入队列
        queue.add(0);
        //打印顶点的值
        System.out.println(vertex[0].getValue());
        //遍历
       out: while (!queue.isEmpty()){
            for (int i=currentIndex+1;i<vertex.length;i++){
                //判断顶点之间是否相通并且该顶点未被访问 然后将该顶点存入队列
                if (adjMat[currentIndex][i]==1&&vertex[i].visited==false){
                    //把下一个元素存入队列中
                    queue.add(i);
                    vertex[i].visited=true;
                    System.out.println(vertex[i].getValue());
                    continue out;
                }
            }
            //取出队列顶端元素
            queue.remove();
            //修改当前位置为队列顶点元素位置
            if (!queue.isEmpty()){
                currentIndex=queue.peek();
            }
        }
    }

    /**
     * 深度优先搜索算法遍历图
     */
    public void dfs(){
         //把第0个顶点标记为已访问状态
        vertex[0].visited=true;
        //把第0个顶点的下标压入栈
        stack.push(0);
        //打印顶点的值
        System.out.println(vertex[0].getValue());
        //遍历
       out: while (!stack.isEmpty()){
            for (int i=currentIndex+1;i<vertex.length;i++){
                //判断顶点之间是否相通并且该顶点未被访问 然后将该顶点压入栈
                if (adjMat[currentIndex][i]==1&&vertex[i].visited==false){
                    //把下一个元素压入栈中
                    stack.push(i);
                    vertex[i].visited=true;
                    System.out.println(vertex[i].getValue());
                    continue out;
                }
            }
            //弹出栈顶元素
            stack.pop();
            //修改当前位置为栈顶元素位置
            if (!stack.isEmpty()){
                currentIndex=stack.peek();
            }
        }
    }
}
