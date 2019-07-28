package com.imooc.enums;

/**
 * 定义错误代码枚举
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "位置错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "上小学"),
    MIDDLE_SCHOOL(101,"上初中")

    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
