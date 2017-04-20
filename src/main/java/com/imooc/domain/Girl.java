package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wanghl11 on 2017/4/19.
 */
@Entity
public class Girl {


    @Id
    @GeneratedValue
    private Integer Id;

    private String cupSize;

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
}
