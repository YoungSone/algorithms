package com.demo02;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,123,213,21,3241,3231,32,3221,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //选择排序
    public static void selectSort(int[] array){
        //循环数组
        for (int i = 0; i < array.length; i++) {
            int minIndex=i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录下最小数的下标
            for (int j = i+1; j < array.length; j++) {
                //如果后面比较的数比记录的最小数小
                if (array[minIndex]>array[j]){
                    minIndex=j;
                }
            }
            //如果最小数的下标不等于当前循环开始标记的最小数下标即i 则说明找到了比array[i]更小的数交互位置
            if (i!=minIndex){
                int temp=array[i];
                array[i]=array[minIndex];
                array[minIndex]=temp;
            }
        }
    }
}
