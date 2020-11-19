package com.flc.bean;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 20:18
 * @desc
 */

public class School {
    private String no;
    private String name;

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

    @Override
    public String toString() {
        return "School{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
