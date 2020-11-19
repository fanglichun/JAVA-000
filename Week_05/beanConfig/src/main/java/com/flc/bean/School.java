package com.flc.bean;

import java.util.List;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:18
 * @desc
 */

public class School {
    private String no;
    private String name;

    private List<Class> classList;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "School{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", classList=" + classList +
                '}';
    }
}
