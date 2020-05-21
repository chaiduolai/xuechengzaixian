package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @program: xcEduService01
 * @description: 异常抛出类
 * @author: Chai.duolai
 * @create: 2020-03-07 16:43
 **/
public class ExceptionCast {
    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}