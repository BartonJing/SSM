package com.barton.common;

public enum ResponseCode {

    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "会话已过期，请从新登录!"),
    NEED_PERMISSION(11, "你没有这个权限访问此链接!"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),
    //可以接着自定义错误代码与错误描述
    LBCLB_EXIST_ERROR(100, "该罪犯已经存在此类别的老病残信息");

    private final int code;
    private final String desc;


    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
