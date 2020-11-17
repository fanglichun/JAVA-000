package com.flc.service;

import com.flc.aop.ISchool;
import com.flc.bean.Klass;
import com.flc.bean.Student;

import javax.annotation.Resource;

public class School implements ISchool {
    
    @Resource
    private Klass class1;
    
    @Resource
    private Student student100;
    
    public void ding(){
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
    
}
