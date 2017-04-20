package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wanghl11 on 2017/4/20.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

//    添加事物控制
    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl();

        girlA.setAge(18);
        girlA.setCupSize("F");

        girlRepository.save(girlA);


        Girl girlB=new Girl();

        girlB.setAge(28);
        girlB.setCupSize("D");

        girlRepository.save(girlB);
    }
}
