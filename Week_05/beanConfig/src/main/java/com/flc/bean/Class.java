package com.flc.bean;

import java.util.List;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:18
 * @desc
 */

public class Class {
    public Class() {}
    public Class(int classNo, String className) {
        this.classNo = classNo;
        this.className = className;
    }

    private List<Student> studentList;

    private int classNo;
    private String className;

    public Class(String s) {

    }

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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Class{" +
                "studentList=" + studentList +
                ", classNo=" + classNo +
                ", className='" + className + '\'' +
                '}';
    }
}
