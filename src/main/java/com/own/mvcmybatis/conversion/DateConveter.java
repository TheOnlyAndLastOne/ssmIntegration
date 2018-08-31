package com.own.mvcmybatis.conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhaozhi
 * @Date: 2018/8/24 0024 11:07
 * @Description: 转换日期 S:页面传递过来的类型 T:转换后的类型
 */
public class DateConveter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        try{
            if(null!=s){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                return sdf.parse(s);
            }
        }catch (Exception e){

        }
        return null;
    }
}
