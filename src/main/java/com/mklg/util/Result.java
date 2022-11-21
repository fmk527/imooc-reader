package com.mklg.util;


public class Result<T> {

    private Integer code;
    private String msg;
    private T data;
//    private Map data = new LinkedHashMap<> ();

    public static Result success() {
        return new Result(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg());
    }

    public  static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<T>(ResultCode.FAILED.getCode(),msg);
    }
    public static <T> Result<T> fail() {
        return new Result<T>(ResultCode.FAILED.getCode(),ResultCode.FAILED.getMsg());
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg,T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
