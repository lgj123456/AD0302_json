package com.example.yls.ad0302_json;

import java.util.ArrayList;

/**
 * Created by yls on 2017/3/2.
 */

public class Student {
    int id;
    String name;
    int age;
    ArrayList<Student> stuList;



    public Student(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
