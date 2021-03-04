package com.demo10;

public class TestGraph {
    public static void main(String[] args) {
        Vertex v1=new Vertex("A");
        Vertex v2=new Vertex("B");
        Vertex v3=new Vertex("C");
        Vertex v4=new Vertex("D");
        Vertex v5=new Vertex("E");
        Graph graph=new Graph(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        //增加边
        graph.addEdge("A","C");
        graph.addEdge("B","C");
        graph.addEdge("A","B");
        graph.addEdge("B","D");
        graph.addEdge("B","E");

        int[][] a=graph.getAdjMat();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        
        graph.bfs();
    }
}
