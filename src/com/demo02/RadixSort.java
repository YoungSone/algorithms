package com.demo02;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr=new int[]{4,123,213,21,3241,3231,32,3221,1};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void radixSort(int[] array){
        //存数组中最大的数字
        int max=Integer.MIN_VALUE;
        for (int i : array) {
            if (i>max){
                max=i;
            }
        }
        //计算最大数字是几位数
        String str=max+"";
        int maxLength=str.length();
        //用于临时存储数据的数组
        int temp[][] =new int[10][array.length];
        //用于记录在temp中相应数组中存放的数字的数量
        int[] count=new int[10];
        //根据最大长度的数决定比较次数 
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < array.length; j++) {
                //计算余数
                int ys=array[j]/n%10;
                temp[ys][count[ys]]=array[j];
                count[ys]++;
            }
            //记录存入array时下标
            int index=0;
            //取出元素存入数组array中
            for (int k = 0; k < count.length; k++) {
                if (count[k]!=0){
                    for (int l = 0; l < count[k]; l++) {
                        array[index]=temp[k][l];
                        index++;
                    }
                }
                //把数量置为零 temp不用清空 因为count决定要取到那些数字 ，而且会覆盖原来的数组
                count[k]=0;
            }
        }
        
    }
}
