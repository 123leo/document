package com.githup.bean;

import com.githup.annotation.MyValue;
import org.springframework.stereotype.Component;

@Component
public class Person {

    @MyValue("张三")
    private String name;

    Person(){
        System.out.println("========================");
    }


    public void init(){
        System.out.println("TestBean---init()");
        this.name = "test";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
