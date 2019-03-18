package com.hey.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public static BaseResult ofSuccess(Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(Code.SUCCESS.getCode());
        baseResult.setMsg(Code.SUCCESS.getMsg());
        baseResult.setData(data);
        return baseResult;
    }

    public static BaseResult ofSuccess(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(Code.SUCCESS.getCode());
        baseResult.setMsg(Code.SUCCESS.getMsg());
        return baseResult;
    }

    public static BaseResult ofError(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(Code.ERROR.getCode());
        baseResult.setMsg(Code.ERROR.getMsg());
        return baseResult;
    }


    enum Code{
        SUCCESS(200,"成功"),
        ERROR(500,"服务器内部错误");

        private int code;
        private String msg;

        Code(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}