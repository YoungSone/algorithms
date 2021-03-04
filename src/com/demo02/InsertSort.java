package com.demo02;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
         int[] arr=new int[]{4,123,213,21,3241,3231,32,3221,1};
         insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void insertSort(int[] array){
        //遍历所有的数字
        for (int i = 1; i < array.length; i++) {
            //如果当前数字比前一个数字小
            if (array[i]<array[i-1]){
                int temp=array[i];
                int j;
                //遍历当前数字前面的所有数字
                for ( j=i-1;j>=0&&array[j]>temp;j--){
                    //把前一个数字赋给后一个数字
                    array[j+1]=array[j];
                }
                //把临时变量赋给不满足条件的后一个元素
                array[j+1]=temp;
            }
        }
    }
}
