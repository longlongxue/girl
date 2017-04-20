package com.imooc.controller;

import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/girls/two")
    public void saveMsgForGirls(){
        girlService.insertTwo();
    }


}
