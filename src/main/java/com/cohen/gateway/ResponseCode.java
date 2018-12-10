package com.cohen.gateway;

public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * 错误
     */
    ERROR(500, "ERROR");
    /**
     * 状态码
     */
    private final int code;
    /**
     * 描述信息
     */
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
