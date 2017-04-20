package com.imooc.controller;

import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wanghl11 on 2017/4/20.
 **/
@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/showGirls")
    public List<Girl> girlList(){
        /*Integer a=new Integer(1);
        girlRepository.findOne(a);*/

        return girlRepository.findAll();
    }

//添加信息，并对信息进行表单验证
    @PostMapping("/girlAdd")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("程序提示："+bindingResult.getFieldError().getDefaultMessage());

            return null;
        }
        return girlRepository.save(girl);
    }

    @PostMapping("/girls/two")
    public void saveMsgForGirls(){
        girlService.insertTwo();
    }


}
