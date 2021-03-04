package com.demo09;

public class TestHashTable {
    public static void main(String[] args) {
        StudentInfo s1=new StudentInfo(16,3);
        StudentInfo s2=new StudentInfo(17,3);
        StudentInfo s3=new StudentInfo(18,4);
        StudentInfo s4=new StudentInfo(19,5);
        StudentInfo s5=new StudentInfo(20,6);
        
        HashTable ht=new HashTable();
        ht.put(s1);
        ht.put(s2);
        ht.put(s3);
        ht.put(s4);
        ht.put(s5);
        //获取目标数据
        StudentInfo target=new StudentInfo(18);
        StudentInfo info=ht.get(target);
        System.out.println(info.getCount());
    }
}
