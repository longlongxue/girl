package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanghl11 on 2017/4/19.
 */
@RestController
public class HelloController {

//    使用属性注解的方式

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

//    使用类对象注解的方式
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value ={"/hello","hi"},method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot!";
    }

    @RequestMapping(value ="/helloCupSize",method = RequestMethod.GET)
    public String sayCupSize(){
        return cupSize;
    }

    @RequestMapping(value ="/helloContent",method = RequestMethod.GET)
    public String sayContent(){
        return girlProperties.getCupSize();
    }

//    required:是否为必传，defaultValue:默认值，value:参数的名称
//    @RequestMapping(value ="/say",method = RequestMethod.GET)
//    根据方法的类型也可以使用简写的注解，如果是GET方式则使用GetMapping,POST方式则使用PostMapping
    @GetMapping("/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "1") Integer id){
        return "id为："+id;
    }


}
