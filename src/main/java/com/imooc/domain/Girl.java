package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by wanghl11 on 2017/4/19.
 */
@Entity
public class Girl {


    @Id
    @GeneratedValue
    private Integer Id;

    private String cupSize;

//  做一个对象的表单验证，小于18岁的进行提示
    @Min(value = 18,message = "未成年人禁止入内!")
    private Integer age;

//    创建一个空的构造方法，必须
    public Girl() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "Id=" + Id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
