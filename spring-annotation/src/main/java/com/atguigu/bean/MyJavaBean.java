package com.atguigu.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyJavaBean implements InitializingBean {
    private String desc;
    private String remark;

    public MyJavaBean() {
        System.out.println("MyJavaBean==============");
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        System.out.println("调用setDesc方法");
        this.desc = desc;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        System.out.println("调用setRemark方法");
        this.remark = remark;
    }
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        this.desc = "init";
    }
    @PostConstruct
    public void initMethod() {

        setDesc("1");
        setRemark("2");
        System.out.println("initMethod");
    }
    public String toString() {
     StringBuilder builder = new StringBuilder();
     builder.append("描述").append(desc);
     builder.append("备注").append(remark).append("]");
     return builder.toString();
    }
}