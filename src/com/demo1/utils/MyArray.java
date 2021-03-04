package com.demo1.utils;

import java.util.Arrays;

public class MyArray {
    private int[] elements;

    public MyArray() {
        elements=new int[0];
    }
    
    public int size(){
        return elements.length;
    }
    
    public void add(int i){
        int[] newArray=new int[elements.length+1];
        for (int i1 = 0; i1 < elements.length; i1++) {
            newArray[i1]=elements[i1];
        }
        newArray[elements.length]=i;
        elements=newArray;
    }
    
    public void show(){
        System.out.println(Arrays.toString(elements));
    }
}
