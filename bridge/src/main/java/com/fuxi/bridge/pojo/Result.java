package com.fuxi.bridge.pojo;

/**
 * @Auther: Laker
 * @Date: 2020/4/2 15:13
 * @Description:
 */
public class Result {

    private Boolean flag;

    private Object data=null;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public Result() {
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public Boolean getFlag() {
        return flag;
    }

    public static Result success() {
        return new Result(true, null);
    }

    public static Result success(Object data) {
        return new Result(true, data);
    }

    public static Result success(Object data, String msg) {
        return new Result(true, data, msg);
    }


    public static Result error() {
        return new Result(false, null);
    }

    public static Result error(String msg) {
        return new Result(false,"",msg);
    }


    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
