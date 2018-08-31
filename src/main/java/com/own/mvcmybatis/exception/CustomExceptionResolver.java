package com.own.mvcmybatis.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhaozhi
 * @Date: 2018/8/24 0024 13:34
 * @Description:
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        if(e instanceof MessageException){//预期异常，比如自定义异常
            MessageException me = (MessageException) e;
            mv.addObject("error",me.getMessage());
        }else{
            mv.addObject("error","未知异常");
        }
        mv.setViewName("error");
        return mv;
    }
}
