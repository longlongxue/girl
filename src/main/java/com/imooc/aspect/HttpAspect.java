package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wanghl11 on 2017/4/20.
 */
@Aspect
//把该文件引入到spring容器中去
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    定义一个通用的拦截方法，对如下路径下面的文件中的方法进行拦截
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void validLogin(){

    }

    @Before("validLogin()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("我是在所有方法之前执行的。。。。");

//        获取请求对象的url、请求方式（get或post）、ip、类方法、参数等
//      获取请求
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        logger.info("url={}",request.getRequestURL());
        logger.info("uri={}",request.getRequestURI());
        logger.info("ip={}",request.getRemoteAddr());

        logger.info("method={}",request.getMethod());

        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        logger.info("args={}",joinPoint.getArgs());
    }

    @After("validLogin()")
    public void doAfter(){
        logger.info("我是在所有方法执行之后执行的...");
    }


    @AfterReturning(returning = "object",pointcut = "validLogin()")
    public void doAfterRetuning(Object object){

        logger.info("response={}",object.toString());
    }



}
