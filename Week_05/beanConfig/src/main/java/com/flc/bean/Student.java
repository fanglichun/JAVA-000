package com.flc.bean;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:18
 * @desc
 */

public class Student {
    private int sNo;
    private String sName;

    public Student() {}

    public Student(int sNo, String sName) {
        this.sNo = sNo;
        this.sName = sName;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo=" + sNo +
                ", sName='" + sName + '\'' +
                '}';
    }
}
