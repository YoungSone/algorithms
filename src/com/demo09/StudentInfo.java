package com.demo09;

public class StudentInfo {
    private int age;
    private int count;

    /**
     * 散列函数
     * @return
     */
    public int hashCode(){
        return this.age;
    }

    public StudentInfo(int age) {
        this.age = age;
    }

    public StudentInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
