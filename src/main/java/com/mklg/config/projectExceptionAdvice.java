package com.mklg.config;

import com.mklg.util.Result;
import com.mklg.util.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class projectExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        e.printStackTrace();
        return new Result(ResultCode.FAILED.getCode(),e.getClass().getSimpleName());
    }
    @ExceptionHandler(MenberException.class)
    public Result memberException(MenberException e) {
        e.printStackTrace();
        return new Result(ResultCode.FAILED.getCode(),e.getMessage());
    }
}
