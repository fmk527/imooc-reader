package com.mklg.util;

public enum ResultCode implements IResult{
    SUCCESS(2001,"成功"),
    FAILED(3000,"失败"),
    VALIDATE_FAILED(2002,"参数校验失败");

    private Integer code;
    private String msg;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultCode() {
    }
}
