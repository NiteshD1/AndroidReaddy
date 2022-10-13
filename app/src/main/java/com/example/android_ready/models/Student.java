package com.example.android_ready.models;

import java.io.Serializable;

public class Student implements Serializable {

    String name, dob;

    public Student(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }
}
