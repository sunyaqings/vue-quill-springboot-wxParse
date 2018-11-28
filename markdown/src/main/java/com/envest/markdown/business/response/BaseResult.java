package com.envest.markdown.business.response;


import com.envest.markdown.business.constant.Code;

public final class BaseResult<T> {
    private int code;
    private String message;
    private T data = (T) new Object();

    // 与Code码交互
    public BaseResult(Code code, String message, T data) {
        this.code = code.getCode();
        this.message = message;
        this.data = data;
    }
    // 与Code码交互
    public BaseResult(Code code, String message) {
        this.code = code.getCode();
        this.message = message;
    }
    // 与Code码交互
    public BaseResult(Code code, T data) {
        this.code = code.getCode();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
