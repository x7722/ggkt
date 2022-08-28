package com.xu.ggkt.exception;

import com.xu.ggkt.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理
 */
@RestControllerAdvice //aop
public class GlobalExceptionHandler {


    /**
     * 全局统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail("出现了异常Exception",null);
    }


    /**
     * 特定的异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public Result arithmeticExceptionError(ArithmeticException e){
        e.printStackTrace();
        return Result.fail("特定的异常处理 arithmeticExceptionError",null);
    }

    /**
     * 特定的异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({GgktException.class})
    public Result ggktExceptionError(GgktException e){
        e.printStackTrace();
        return Result.fail("异常代码："+e.getCode()+"   异常信息："+e.getMsg(),null);
    }



}
