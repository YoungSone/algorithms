package com.demo02;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
         int[] arr=new int[]{4,123,213,21,3241,3231,32,3221,1};
         quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void quickSort(int[] array,int start,int end){
        if (start<end){
            //标准数
        int stard=array[start];
        //记录需要排序的下标
        int low=start;
        int high=end;
        //循环找比标准数大的数 和比标准数小的数
        while (low<high){
            //看右边的数是否比标准数大
            while (low<high&&array[high]>=stard){
                high--;
            }
            array[low]=array[high];
            //看左边的数字是否比标准数小
            while (low<high&&array[low]<=stard){
                low++;
            }
            array[high]=array[low];
        }
        //处理完后需要把标准数赋给所在位置的元素
        array[low]=stard;
        //处理所有小的数字
        quickSort(array,start,low);
        //处理所有大的数字
        quickSort(array,low+1,end);
        }
        
    }
}
