package com.demo1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7,8,9,10};
        int target=8;
        int begin=0;
        int end=a.length-1;
        int mid=(begin+end)/2;
        int index=-1;
        while (true){
            
            if (begin>=end){
                break;
            }
            
            if (a[mid]==target){
                index=mid;
                break;
            }else{
                if (a[mid]>target){
                   // mid=(begin+mid)/2;
                   end=mid-1; 
                }else {
                   // mid=(mid+end)/2;
                    begin=mid+1;
                }
                mid=(begin+end)/2;
            }
        }
        System.out.println(index);
    }
}
