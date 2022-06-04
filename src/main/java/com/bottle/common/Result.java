package com.bottle.common;

public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode("0");
        result.setMsg("成功！");
        return result;
    }

    public static <M> Result<M> success(M data) {
        Result<M> result = new Result<M>(data);
        result.setCode("0");
        result.setMsg("成功！");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode("1");
        result.setMsg("失败");
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode("1");
        result.setMsg(msg);
        return result;
    }
}
