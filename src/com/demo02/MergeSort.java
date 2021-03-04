package com.demo02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
* @Title: mergeSort.java 
* @Package sortAlgorithm 
* @Description: 归并排序 O(nlog2n)
* @author YoungSone 
* @date 2019年9月22日 下午3:30:11 
* @version V1.0
 */
public class MergeSort {
	/*把长度为n的输入序列分成两个长度为n/2的子序列；
	对这两个子序列分别采用归并排序；
	将两个排序好的子序列合并成一个最终的排序序列。
	递归调用本身实现对序列的不可分化然后在进行组合得到新的拍好序的数组
	*/
	
	public static void merge(int []a,int left,int mid,int right) {
		int[] tmp = new int[a.length];
		int p1=left,p2=mid+1,k=left;//p1.p2检测指针 k存放指针
		while(p1<=mid&&p2<=right){
			//比较两个数组第一个元素的大小
			if(a[p1]<a[p2]){
				tmp[k++]=a[p1++];
			}else {
				tmp[k++]=a[p2++];
			}
		}
		//判断是否比较完毕 未比较完毕把还没有比较的数据放在tmp数组的后面
		while(p1<=mid)  tmp[k++]=a[p1++];
		while(p2<=right) tmp[k++]=a[p2++];
		
		for(int i=left;i<=right;i++){
			a[i]=tmp[i];//把排序好的临时数组赋值给原来的数组
		}
	}
	
	public static void mergeSort(int[] a,int start,int end) {
		if(start<end){
			int mid=(start+end)/2;//划分子序列
			mergeSort(a,start,mid);
			mergeSort(a,mid+1,end);
			merge(a, start, mid, end);
		}
	}
	public static void main(String[] args) {
		int[] aIntegers= {1,23,521,51,23,151,612,5555};
		mergeSort(aIntegers,0,aIntegers.length-1);
		for(int a:aIntegers){
			System.out.println(a);
		}
	
	}
}
