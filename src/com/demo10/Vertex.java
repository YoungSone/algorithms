package com.demo10;

/**
 * 顶点类
 */
public class Vertex {
    private String value;
    public boolean visited;
    
    
    public Vertex(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
