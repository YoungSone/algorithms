package com.demo1;

public class TestArray {
    public static void main(String[] args) {
        //创建一个数组
        int[] arr1=new int[3];
        int length=arr1.length;
        System.out.println(length);
        //访问数组中的元素 数组名[下标] 从0开始
        int element0=arr1[0];
        System.out.println("elment0:"+element0);
        //为数组中的元素赋值
        arr1[0]=99;
        arr1[1]=96;
        arr1[2]=91;
        System.out.println("element0:"+arr1[0]);
        //遍历数组
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }
}
