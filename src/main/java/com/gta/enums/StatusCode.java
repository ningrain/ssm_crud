package com.gta.enums;

/**
 * StatusCode 状态码枚举类
 * Created by ningning.jiang on 2017/12/5.
 */
public enum StatusCode {

    SUCCESS(200, "成功"), FAIL(500, "失败");

    private int code;
    private String msg;

    StatusCode(int code, String msg) {
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
