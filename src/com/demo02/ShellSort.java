package com.demo02;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
       int[] arr=new int[]{4,123,213,21,3241,3231,32,3221,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void shellSort(int[] arr){
        //遍历所有的步长
        for (int i = arr.length/2; i >0;i/=2) {
            //遍历该步长包含的所有的元素
            for (int j = i; j < arr.length; j++) {
                //遍历本组中所有的元素
                for (int k=j-i;k>=0;k-=i){
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[k]>arr[k+i]){
                        int temp=arr[k];
                        arr[k]=arr[k+i];
                        arr[k+i]=temp;
                    }
                    System.out.println("  --步长为"+i+"第"+k+"次排序后的数组"+Arrays.toString(arr));
                }
                
            }
            System.out.println("步长为"+i+"排序后的数组"+Arrays.toString(arr));
        }
    }
}
