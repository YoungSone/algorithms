package com.demo02;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,123,213,21,3241,3231,32,3221,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void bubbleSort(int[] arrary){
        //控制比较多少轮
        for (int i = 0; i < arrary.length-1; i++) {
            for (int j = 0; j < arrary.length-1-i; j++) {
                if (arrary[j]>=arrary[j+1]){
                    int temp=arrary[j];
                    arrary[j]=arrary[j+1];
                    arrary[j+1]=temp;
                }
            }
        }
    }
}
