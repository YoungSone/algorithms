package com.demo09;

public class HashTable {
    private StudentInfo[] data=new StudentInfo[1024];

    /**
     * 向散列表中添加元素
     * @param studentInfo
     */
    public void put(StudentInfo studentInfo){
        //调用散列函数获取存储位置
        int index=studentInfo.hashCode();
        //添加元素
        data[index]=studentInfo;
    }
    
    public StudentInfo get(StudentInfo studentInfo){
        return data[studentInfo.hashCode()];
    }
}
