package com.envest.markdown.business.constant;

/**
 * 返回结果BaseResult编码
 */
public enum Code {

    FAIL(-1, "失败"),
    SUCCESS(0, "成功"),

    SYSTEM_ERROR(9998, "系统异常，请稍后重试");

    private int code;
    private String msg;

    // 构造方法
    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
