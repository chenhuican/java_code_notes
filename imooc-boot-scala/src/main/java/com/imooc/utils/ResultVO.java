package com.imooc.utils;

import java.io.Serializable;

/**
 * 使查询返回相同的内容
 * @param <T>
 */
public class ResultVO<T> implements Serializable{

    /**错误码**/
    private Integer code;

    /**提示信息**/
    private String msg;

    /**具体内容**/
    private T Data;

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
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
