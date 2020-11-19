package com.flc.bean;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:18
 * @desc
 */

public class Class {
    private int classNo;
    private String className;

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classNo=" + classNo +
                ", className='" + className + '\'' +
                '}';
    }
}
